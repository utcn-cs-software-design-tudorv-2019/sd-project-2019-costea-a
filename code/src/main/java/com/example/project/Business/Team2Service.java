package com.example.project.Business;

import com.example.project.Persistence.Entity.Team;
import com.example.project.Persistence.Repo.TeamRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class Team2Service {
    @Inject
    TeamRepository teamRepository;


    public List<Team> getAllTeam()
    {
        return teamRepository.findAll();
    }
}
