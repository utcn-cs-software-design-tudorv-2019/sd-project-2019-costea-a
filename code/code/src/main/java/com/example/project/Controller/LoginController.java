package com.example.project.Controller;

import com.example.project.Business.AdminService;
import com.example.project.Business.ClientService;
import com.example.project.Business.LoginService;
import com.example.project.Persistence.Entity.Client;
import com.example.project.Persistence.Entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class LoginController {
    @Inject
    LoginService loginService;

/*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getAll()
    {
        List<Login> loginList = loginService.getAllUsersLoggedIn();

        ModelAndView mav = new ModelAndView("login_view");
        mav.addObject("loginList", loginList);
        mav.addObject("newLogin", new Login());
        return mav;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView postLogin(@RequestParam(value = "action") String action, @ModelAttribute(value = "newLogin") Login newLogin)
    {
        if(action.equals("Register Here"))
            loginService.create(newLogin);

        return new ModelAndView("redirect:login");
    }

@RequestMapping(value="/register",method = RequestMethod.GET)
public String getRegistationForm(){
    return "register";
}*/

    //@RequestMapping(method=RequestMethod.POST)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(@ModelAttribute(name="Login") Login loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if (loginService.findClientByUsername(username) != null)
            if(loginService.findClientByUsername(username).getPassword().equals(password)) {
                return "client";
            }
        if (loginService.findAdminByUsername(username) != null)
            if(loginService.findAdminByUsername(username).getPassword().equals(password)) {
                return "admin";
            }
        return "login_view";
    }

   /* @RequestMapping(value="/register",method =RequestMethod.POST)
    public String CreateAccount(@ModelAttribute(name="Client") Login client,Model model){
        if(loginService.findClientByUsername(client.getUsername())==null)
            loginService.create(client);
        else{
            model.addAttribute("Username already exists",client.getUsername());
            return "register";
        }
        return "login_view";
    }*/



}
