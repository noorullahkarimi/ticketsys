package TicketSystem.demo.service;
import TicketSystem.demo.dto.Comments;
import TicketSystem.demo.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comments addComment(Comments comment){
        return commentRepository.save(comment);
    }

}
