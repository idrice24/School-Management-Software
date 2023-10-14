package org.idrice24.SMSApplication.config;

import org.idrice24.services.AppUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/fees/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/api/v*/registration/**").permitAll()
                .antMatchers("/userPage").access("hasRole('USER')")
                            .antMatchers("/userHome").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login").failureUrl("/404?error=true");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception  {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
