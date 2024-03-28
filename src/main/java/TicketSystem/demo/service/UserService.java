package TicketSystem.demo.service;
import TicketSystem.demo.dto.Users;
import TicketSystem.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users add(Users users){
        return userRepository.save(users);
    }
}
