package com.example.project.Business;

import com.example.project.Persistence.Entity.Play;
import com.example.project.Persistence.Entity.Registration;
import com.example.project.Persistence.Repo.RegistrationRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RegistrationService {
    @Inject
    RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations()
    {
        return registrationRepository.findAll();
    }


    public Registration create(Registration newRegistration)
    {
        return registrationRepository.save(newRegistration);
    }

}
