package com.example.project.Controller;

import com.example.project.Business.AdminService;
import com.example.project.Business.InfoPlayService;
import com.example.project.Persistence.Entity.InfoPlay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class InfoPlayController {
    @Inject
    InfoPlayService infoPlayService;

    @RequestMapping(value = "/infoplay", method = RequestMethod.GET)
    public ModelAndView getInfos()
    {
        List<InfoPlay> infoPlayList = infoPlayService.getAllInfo();

        ModelAndView mav = new ModelAndView("info_view");
        mav.addObject("infoPlaysList", infoPlayList);
        mav.addObject("newInfoPlay", new InfoPlay());
        return mav;

    }


    @RequestMapping(value = "/infoplay", method = RequestMethod.POST)
    public ModelAndView postInfoPlays(@RequestParam(value = "action") String action, @ModelAttribute(value = "newInfoPlay") InfoPlay newPlay)
    {
        if(action.equals("Create InfoPlay"))
            infoPlayService.create(newPlay);
        else if(action.equals("Update InfoPlay"))
            infoPlayService.update(new InfoPlay(), newPlay);
        else
            infoPlayService.delete(newPlay);
        return new ModelAndView("redirect:infoplay");
    }
}
