package TicketSystem.demo.service;

import TicketSystem.demo.dto.Tickets;
import TicketSystem.demo.dto.Users;
import TicketSystem.demo.repository.CommentRepository;
import TicketSystem.demo.repository.TicketRepository;
import TicketSystem.demo.repository.UserRepository;
import TicketSystem.demo.staticquantity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {


    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }


    //add a new record
    public Tickets add(Tickets tickets){
        //get the Id user with role SUPPORT
        String supporterId = findSupporterForTicketAssignment();
        //add id to ticket
        tickets.setSupporter(supporterId);
        return ticketRepository.save(tickets);
    }
    private String findSupporterForTicketAssignment() {
        // table tickets == empty
        System.out.println(ticketRepository.count() == 0);
        if (ticketRepository.count() == 0) {
            // get the user(0) with role=SUPPORT
            List<Users> supporters = userRepository.findByRole("SUPPORT");
            if (!supporters.isEmpty()) {
                System.out.println(supporters.get(0).getId());
                return supporters.get(0).getId();
            }
        } else {// table tickets != empty
            System.out.println("table is not empty");
            // user with role = SUPPORT haven't no record in ticket talble
            System.out.println(userRepository.findSupportersWithNoTickets()+"<<<------line 50");
            List<Users> supportersWithNoTickets = userRepository.findSupportersWithNoTickets();
            if (!supportersWithNoTickets.isEmpty()) {
                // get user (0) from the user have no record in ticket table
                System.out.println(supportersWithNoTickets.get(0).getId()+"<<<<----->>>>");
                return supportersWithNoTickets.get(0).getId();
            } else {
                // get user with less record than others
                System.out.println("<<<<--==============--->>>>");
                return userRepository.findSupporterWithLeastTickets();
            }
        }
        return null;
    }



    //show all ticket
    public List<Tickets> showAll(){
        return ticketRepository.findAll();
    }
    //delet method
    public Boolean delete(String id) {

        if (ticketRepository.existsById(id)) {//if we found it on table
             ticketRepository.deleteById(id);
        } else {
            //if record doesn't exist in the db
            throw new EmptyResultDataAccessException("Record does not exist", 1);

        }
        return true;
    }

    public List<Tickets> showTicketsOfSupporters(String supporterId){
        return ticketRepository.findOpenTicketsBySupporterId(supporterId);
    }


}
