package org.idrice24.entities;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class AppUser implements UserDetails {
    
    @SequenceGenerator(
         name = "student_sequence",
         sequenceName = "student_sequence",
         allocationSize = 1
     )
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean enabled = true; // TODO: change after email verification
    private Boolean locked = false;

    public AppUser(String firstName, String lastName, String password, String email, AppUserRole appUserRole){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.appUserRole = appUserRole;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        
        return password;
    }

    @Override
    public String getUsername() {
      
        return email;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       
        return true;
    }

    @Override
    public boolean isEnabled() {
       
        return enabled;
    }
}
