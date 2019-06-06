package com.example.project.Business;

import com.example.project.Persistence.Entity.Admin;
import com.example.project.Persistence.Entity.InfoPlay;
import com.example.project.Persistence.Entity.Play;
import com.example.project.Persistence.Repo.AdminRepository;
import com.example.project.Persistence.Repo.InfoPlayRepository;
import com.example.project.Persistence.Repo.PlayRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class AdminService {
    @Inject
    PlayRepository playRepository;

    @Inject
    AdminRepository adminRepository;

    public Admin findByFirstName(String username)
    {
        return adminRepository.findByFirstName(username);
    }

    public void saveAdmin(Admin admin){
        adminRepository.save(admin);
    }


    public List<Play> getAllPlays()
    {
        return playRepository.findAll();
    }

    public Play create(Play newPlay)
    {
        return playRepository.save(newPlay);
    }

    public void update(Play newPlay, Play oldPlay) {
        if (oldPlay == null) {
            System.out.println("ERROR! Play does not exist !!!");
        } else {
            newPlay.setId(oldPlay.getId());
            newPlay.setName(newPlay.getName());
            newPlay.setAuthorPlay(newPlay.getAuthorPlay());
            newPlay.setTypePlay(newPlay.getTypePlay());

            playRepository.save(newPlay);
        }
    }

    public void delete(Play play){
        playRepository.delete(play);
    }


}
