package TicketSystem.demo.controller;

import TicketSystem.demo.dto.Comments;
import TicketSystem.demo.dto.Tickets;
import TicketSystem.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    private CommentService commentService;
    @Autowired

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addcomment")
    public Comments ShowComments(Comments comments){
        return commentService.addComment(comments);
    }
}
