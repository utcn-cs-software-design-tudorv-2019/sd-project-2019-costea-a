package com.example.project.Business;

import com.example.project.Persistence.Entity.Client;
import com.example.project.Persistence.Repo.ClientRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class Client2Service {
    @Inject
    ClientRepository clientRepository;

    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }
}
