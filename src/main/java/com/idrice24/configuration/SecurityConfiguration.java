package com.idrice24.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery).passwordEncoder(bCryptPasswordEncoder);

    }

    // "/", "/home","/salut","/greeting","/results","/salutation"

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll().antMatchers("/registration").permitAll().antMatchers("/userPage").access("hasRole('ROLE_USER')").antMatchers("/home").permitAll().antMatchers("/salut").permitAll().antMatchers("/greeting").permitAll().antMatchers("/results").permitAll().antMatchers("/salutation").permitAll().antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/index").usernameParameter("email").passwordParameter("password").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home").and().exceptionHandling().accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/vendor/**");
    }

}
