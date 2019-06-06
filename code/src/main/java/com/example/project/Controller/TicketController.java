package com.example.project.Controller;

import com.example.project.Business.TicketService;
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
    public ModelAndView getOrders()
    {
        List<Ticket>  cartList= ticketService.getAllOrders();

        ModelAndView mav = new ModelAndView("cart_view");
        mav.addObject("cartList", cartList);
        mav.addObject("newOrder", new Ticket());
        return mav;
    }


    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public ModelAndView postOrders(@RequestParam(value = "action") String action, @ModelAttribute(value = "newOrder") Ticket newOrder)
    {
        if(action.equals("Buy Ticket"))
            ticketService.create(newOrder);

        return new ModelAndView("redirect:ticket");
    }
}
