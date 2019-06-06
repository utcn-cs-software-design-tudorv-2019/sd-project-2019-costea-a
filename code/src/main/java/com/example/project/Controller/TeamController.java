package com.example.project.Controller;

import com.example.project.Business.AdminService;
import com.example.project.Business.TeamService;
import com.example.project.Persistence.Entity.Play;
import com.example.project.Persistence.Entity.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class TeamController {
    @Inject
    TeamService teamService;

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public ModelAndView getTeam()
    {
        List<Team> teamList = teamService.getAllTeam();

        ModelAndView mav = new ModelAndView("team_view");
        mav.addObject("teamList", teamList);
        mav.addObject("newTeam", new Team());
        return mav;
    }


    @RequestMapping(value = "/team", method = RequestMethod.POST)
    public ModelAndView postTeam(@RequestParam(value = "action") String action, @ModelAttribute(value = "newTeam") Team newTeam)
    {
        if(action.equals("Add Member"))
            teamService.create(newTeam);
        else if(action.equals("Update Member"))
            teamService.update(new Team(), newTeam);
        else
            teamService.delete(newTeam);
        return new ModelAndView("redirect:team");
    }
}
