package TicketSystem.demo.repository;

import TicketSystem.demo.dto.Comments;
import TicketSystem.demo.dto.Tickets;
import TicketSystem.demo.dto.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//id is String instead int and it is because mongo
public interface CommentRepository extends MongoRepository<Comments, String> {
    //return ticket with id = supporterId & status = open
//    @Query("SELECT t FROM Ticket t WHERE t.supporterId = :supporterId AND t.status = 'OPEN'")
//    List<Tickets> findOpenTicketsBySupporterId(@Param("supporterId") String supporterId);

}
