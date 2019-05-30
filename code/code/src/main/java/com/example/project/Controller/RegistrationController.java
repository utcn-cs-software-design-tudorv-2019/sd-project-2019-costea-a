package com.example.project.Controller;

import com.example.project.Business.RegistrationService;
import com.example.project.Persistence.Entity.InfoPlay;
import com.example.project.Persistence.Entity.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class RegistrationController {
    @Inject
    RegistrationService registrationService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegistration()
    {
        List<Registration> registrationList = registrationService.getAllRegistrations();

        ModelAndView mav = new ModelAndView("register");
        mav.addObject("registerList", registrationList);
        mav.addObject("newRegistration", new Registration());
        return mav;

    }

   /* @RequestMapping(value="/register",method = RequestMethod.GET)
    public String getRegistationForm(){
        return "register";
    }*/

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView postRegistration(@RequestParam(value = "action") String action, @ModelAttribute(value = "newRegistration") Registration newRegistration)
    {
        if(action.equals("Create New Account"))
            registrationService.create(newRegistration);
        return new ModelAndView("redirect:register");
    }
}
