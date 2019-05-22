package com.example.project.Controller;
import com.example.project.Business.TicketService;
import com.example.project.Persistence.Entity.Review;
import com.example.project.Persistence.Entity.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class TicketController {
    @Inject
    TicketService ticketService;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public ModelAndView getTickets()
    {
        List<Ticket> ticketList = ticketService.getAllTickets();

        ModelAndView mav = new ModelAndView("ticket_view");
        mav.addObject("ticketList", ticketList);
        mav.addObject("newTicket", new Ticket());
        return mav;

    }


    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public ModelAndView postTickets(@RequestParam(value = "action") String action, @ModelAttribute(value = "newTicket") Ticket newTicket)
    {
        if(action.equals("Buy Ticket"))
            ticketService.create(newTicket);

        return new ModelAndView("redirect:ticket");
    }

}
