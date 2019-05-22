package com.example.project.Controller;

import com.example.project.Business.InfoPlayService;
import com.example.project.Persistence.Entity.InfoPlay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class InfoPlay2Controller {
    @Inject
    InfoPlayService infoPlayService;

    @RequestMapping(value = "/infoplay2", method = RequestMethod.GET)
    public ModelAndView getInfos()
    {
        List<InfoPlay> infoPlayList = infoPlayService.getAllInfo();

        ModelAndView mav = new ModelAndView("info2_view");
        mav.addObject("infoPlaysList", infoPlayList);
        mav.addObject("newInfoPlay", new InfoPlay());
        return mav;

    }
}
