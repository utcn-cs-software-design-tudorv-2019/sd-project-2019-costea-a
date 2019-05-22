package com.example.project.Controller;

import com.example.project.Business.ClientService;
import com.example.project.Business.LoginService;
import com.example.project.Persistence.Entity.Client;
import com.example.project.Persistence.Entity.Login;
import org.springframework.stereotype.Controller;
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


}
