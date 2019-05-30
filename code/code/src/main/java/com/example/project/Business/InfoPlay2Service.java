package com.example.project.Business;

import com.example.project.Persistence.Entity.InfoPlay;
import com.example.project.Persistence.Repo.InfoPlayRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class InfoPlay2Service {
    @Inject
    InfoPlayRepository infoPlayRepository;

    //operations for theatre plays info
    public List<InfoPlay> getAllInfo()
    {
        return infoPlayRepository.findAll();
    }

}
