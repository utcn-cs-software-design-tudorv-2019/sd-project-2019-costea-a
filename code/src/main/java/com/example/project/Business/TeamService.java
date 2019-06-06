package com.example.project.Business;

import com.example.project.Persistence.Entity.Play;
import com.example.project.Persistence.Entity.Team;
import com.example.project.Persistence.Repo.PlayRepository;
import com.example.project.Persistence.Repo.TeamRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TeamService {
    @Inject
    TeamRepository teamRepository;


    public List<Team> getAllTeam()
    {
        return teamRepository.findAll();
    }

    public Team create(Team newTeam)
    {
        return teamRepository.save(newTeam);
    }

    public void update(Team newTeam, Team oldTeam) {
        if (oldTeam == null) {
            System.out.println("ERROR! This actor does not exist !!!");
        } else {
            newTeam.setId(oldTeam.getId());
            newTeam.setName(newTeam.getName());
            newTeam.setAge(newTeam.getAge());
            newTeam.setRole(newTeam.getRole());

            teamRepository.save(newTeam);
        }
    }

    public void delete(Team team){
        teamRepository.delete(team);
    }
}
