package com.example.project.Controller;

import com.example.project.Business.TeamService;
import com.example.project.Persistence.Entity.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class Team2Controller {
    @Inject
    TeamService teamService;

    @RequestMapping(value = "/team2", method = RequestMethod.GET)
    public ModelAndView getTeam()
    {
        List<Team> teamList = teamService.getAllTeam();

        ModelAndView mav = new ModelAndView("team2_view");
        mav.addObject("teamList", teamList);
        mav.addObject("newTeam", new Team());
        return mav;
    }
}
