package com.example.project.Controller;

import com.example.project.Business.AdminService;
import com.example.project.Business.PlayService;
import com.example.project.Persistence.Entity.Play;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class PlayController {
    @Inject
    PlayService playService;

    @RequestMapping(value = "/play2", method = RequestMethod.GET)
    public ModelAndView getPlays()
    {
        List<Play> playsList = playService.getAllPlays();

        ModelAndView mav = new ModelAndView("play_view");
        mav.addObject("playsList", playsList);
        mav.addObject("newPlay", new Play());
        return mav;
    }
}
