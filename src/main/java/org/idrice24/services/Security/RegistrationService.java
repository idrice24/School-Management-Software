package org.idrice24.services.Security;


import org.idrice24.controllers.Security.RegistrationRequest;
import org.idrice24.entities.Security.AppUser;
import org.idrice24.entities.Security.AppUserRole;
import org.idrice24.services.AppUserService;
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
