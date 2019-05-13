package com.example.project.Business;

import com.example.project.Persistence.Entity.Client;
import com.example.project.Persistence.Repo.ClientRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ClientService {
    @Inject
    ClientRepository clientRepository;

    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }

    public Client create(Client newClient)
    {
        return clientRepository.save(newClient);
    }

    public void update(Client newClient, Client oldClient) {
        if (oldClient == null) {
            System.out.println("ERROR! Client does not exist !!!");
        } else {
            newClient.setId(oldClient.getId());
            newClient.setFirstName(newClient.getFirstName());
            newClient.setLastName(newClient.getLastName());
            newClient.setEmail(newClient.getEmail());
            newClient.setAddress(newClient.getAddress());

            clientRepository.save(newClient);
        }
    }

    public void delete(Client client){
        clientRepository.delete(client);
    }
}

