package com.example.project.Controller;

import com.example.project.Business.ClientService;
import com.example.project.Persistence.Entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class Client2Controller {
    @Inject
    ClientService clientService;

    @RequestMapping(value = "/client2", method = RequestMethod.GET)
    public ModelAndView getClients()
    {
        List<Client> clientList = clientService.getAllClients();

        ModelAndView mav = new ModelAndView("see_clients");
        mav.addObject("clientsList", clientList);
        mav.addObject("newClient", new Client());
        return mav;
    }
}
