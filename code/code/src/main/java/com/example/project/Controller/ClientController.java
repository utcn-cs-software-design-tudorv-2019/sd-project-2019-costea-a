package com.example.project.Controller;

import com.example.project.Business.AdminService;
import com.example.project.Business.ClientService;
import com.example.project.Persistence.Entity.Client;
import com.example.project.Persistence.Entity.Play;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ClientController {
    @Inject
    ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public ModelAndView getClients()
    {
        List<Client> clientList = clientService.getAllClients();

        ModelAndView mav = new ModelAndView("see_clients");
        mav.addObject("clientsList", clientList);
        mav.addObject("newClient", new Client());
        return mav;
    }


    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ModelAndView postClients(@RequestParam(value = "action") String action, @ModelAttribute(value = "newClient") Client newClient)
    {
        if(action.equals("Create Client"))
            clientService.create(newClient);
        else if(action.equals("Update Client"))
            clientService.update(new Client(), newClient);
        else
            clientService.delete(newClient);
        return new ModelAndView("redirect:client");
    }


}
