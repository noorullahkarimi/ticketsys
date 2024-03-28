package TicketSystem.demo.controller;

import TicketSystem.demo.dto.Tickets;
import TicketSystem.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<Tickets> showTickets(){
        return ticketService.showAll();
    }

    @PostMapping("/addticket")
    public Tickets addTicket(Tickets ticket){
        return ticketService.add(ticket);
    }

    @DeleteMapping("/deletticket/{id}")
    public Boolean deleteTicket(@PathVariable("id") String id){
        return ticketService.delete(id);
    }
    //this route is for supporter and they can see the tickets by their id
    //id comes from authentication but we supposed we have authentication system
    @GetMapping("/showticket/{id}")
    public List<Tickets> showTicketsOfSupporters(@PathVariable("id") String id){
        return ticketService.showTicketsOfSupporters(id);
    }
}
