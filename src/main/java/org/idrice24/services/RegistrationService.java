package org.idrice24.services;


import org.idrice24.controllers.RegistrationRequest;
import org.idrice24.entities.AppUser;
import org.idrice24.entities.AppUserRole;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if( !isValidEmail){
            throw new IllegalStateException("email is not valide");
        }
		return appUserService.signUpUser(
            new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getPassword(),
                request.getEmail(),
                AppUserRole.USER
            )
        );
    }
    
}
