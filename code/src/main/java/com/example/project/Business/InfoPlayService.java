package com.example.project.Business;

import com.example.project.Persistence.Entity.InfoPlay;
import com.example.project.Persistence.Repo.InfoPlayRepository;
import com.example.project.Persistence.Repo.PlayRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class InfoPlayService {
    @Inject
    InfoPlayRepository infoPlayRepository;

    //operations for theatre plays info
    public List<InfoPlay> getAllInfo()
    {
        return infoPlayRepository.findAll();
    }

    public InfoPlay create(InfoPlay newPlay)
    {
        return infoPlayRepository.save(newPlay);
    }

    public void update(InfoPlay newPlay, InfoPlay oldPlay) {
        if (oldPlay == null) {
            System.out.println("ERROR! Play does not exist !!!");
        } else {
            newPlay.setId(oldPlay.getId());
            newPlay.setName(newPlay.getName());
            newPlay.setDirectorPlay(newPlay.getDirectorPlay());
            newPlay.setMajorActors(newPlay.getMajorActors());
            newPlay.setDate(newPlay.getDate());
            newPlay.setDuration(newPlay.getDuration());
            newPlay.setPrice(newPlay.getPrice());

            infoPlayRepository.save(newPlay);
        }
    }

    public void delete(InfoPlay play){
        infoPlayRepository.delete(play);
    }
}
