package TicketSystem.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "comments")
//automatic setter & getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    //id with type string automatically fill with mongodb
    private String id;
    private String comment;
    private String ticket;
    //id of a user with role supporter response
    private String supporter;

    @CreatedDate
    private Date createdDate;//fill automatically date

    //it prevent of id is coming from user to insert. and it not shows the id in output
    private void setId(String id) {
        this.id = id;
    }
}
