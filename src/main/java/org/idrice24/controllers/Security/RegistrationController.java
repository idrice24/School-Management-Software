package org.idrice24.controllers.Security;

import org.idrice24.services.Security.RegistrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping("/")
    public ModelAndView welcomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView signUp(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("api/v2/registration")
    public ModelAndView register(@RequestBody RegistrationRequest request){
        ModelAndView modelAndView = new ModelAndView();
        registrationService.register(request);
        System.out.print(registrationService.register(request));
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
