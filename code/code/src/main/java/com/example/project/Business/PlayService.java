package com.example.project.Business;

import com.example.project.Persistence.Entity.Play;
import com.example.project.Persistence.Repo.PlayRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PlayService {
    @Inject
    PlayRepository playRepository;

    public List<Play> getAllPlays()
    {
        return playRepository.findAll();
    }
}
