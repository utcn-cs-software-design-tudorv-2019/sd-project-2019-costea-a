package com.example.project.Controller;
import com.example.project.Business.InfoTicketService;
import com.example.project.Persistence.Entity.InfoTicket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class InfoTicketController {
    @Inject
    InfoTicketService ticketService;

    @RequestMapping(value = "/infoticket", method = RequestMethod.GET)
    public ModelAndView getTickets()
    {
        List<InfoTicket> ticketList = ticketService.getAllTickets();

        ModelAndView mav = new ModelAndView("ticket_view");
        mav.addObject("ticketList", ticketList);
        mav.addObject("newTicket", new InfoTicket());
        return mav;

    }


    @RequestMapping(value = "/infoticket", method = RequestMethod.POST)
    public ModelAndView postTickets(@RequestParam(value = "action") String action, @ModelAttribute(value = "newTicket") InfoTicket newTicket)
    {
        if(action.equals("Buy Ticket"))
            ticketService.create(newTicket);

        return new ModelAndView("redirect:infoticket");
    }

}
