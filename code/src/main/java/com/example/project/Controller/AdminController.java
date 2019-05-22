package com.example.project.Controller;

import com.example.project.Business.AdminService;
import com.example.project.Persistence.Entity.InfoPlay;
import com.example.project.Persistence.Entity.Play;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class AdminController {
    @Inject
    AdminService adminService;

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public ModelAndView getPlays()
    {
        List<Play> playsList = adminService.getAllPlays();

        ModelAndView mav = new ModelAndView("admin_view");
        mav.addObject("playsList", playsList);
        mav.addObject("newPlay", new Play());
        return mav;
    }


    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public ModelAndView postPlays(@RequestParam(value = "action") String action, @ModelAttribute(value = "newPlay") Play newPlay)
    {
        if(action.equals("Create Play"))
            adminService.create(newPlay);
        else if(action.equals("Update Play"))
            adminService.update(new Play(), newPlay);
        else
            adminService.delete(newPlay);
        return new ModelAndView("redirect:play");
    }


}

