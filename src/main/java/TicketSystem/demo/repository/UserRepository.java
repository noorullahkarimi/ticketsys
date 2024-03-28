package TicketSystem.demo.repository;
import TicketSystem.demo.dto.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

//id is String instead int and it is because mongo
public interface UserRepository extends MongoRepository<Users,String>{
    @Query(value = "{'role': ?0}")
    List<Users> findByRole(String role);

    @Query(value = "{'role': 'SUPPORT', 'id': {$nin: {$addToSet: '$supporter'}}}")
    List<Users> findSupportersWithNoTickets();

    @Query(value = "{$group: {_id: '$supporter', totalTickets: {$sum: 1}}}, {$sort: {totalTickets: 1}}, {$limit: 1}")
    String findSupporterWithLeastTickets();
}
