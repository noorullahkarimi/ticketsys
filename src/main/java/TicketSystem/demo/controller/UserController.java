package TicketSystem.demo.controller;

import TicketSystem.demo.dto.Users;
import TicketSystem.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@PreAuthorize("hasAnyAuthority('OP_USER')")
    @PostMapping("/adduser")
    public Users add(Users users){
        return userService.add(users);
    }
}
