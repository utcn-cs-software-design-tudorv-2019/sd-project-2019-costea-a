package com.example.project.Business;

import com.example.project.Persistence.Entity.Admin;
import com.example.project.Persistence.Entity.Client;
import com.example.project.Persistence.Entity.Login;
import com.example.project.Persistence.Repo.LoginRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class LoginService {
    @Inject
    LoginRepository loginRepository;

    public Login findAdminByUsername(String username)
    {
        return loginRepository.findAdminByUsername(username);
    }


    public Login findClientByUsername(String username)
    {
        return loginRepository.findClientByUsername(username);
    }



    public List<Login> getAllUsersLoggedIn()
    {
        return loginRepository.findAll();
    }

    public Login create(Login newLogin)
    {
        return loginRepository.save(newLogin);
    }


}
