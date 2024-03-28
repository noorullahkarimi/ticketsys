package TicketSystem.demo.dto;

import TicketSystem.demo.staticquantity.StatusTicket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "tickets")
//automatic setter & getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tickets {
    @Id
    //id with type string automatically fill with mongodb
    private String id;
    private String title;
    //it just accept from the values is on the enum( OPEN, CLOSE)
    private StatusTicket status;
    private String description;
    //the user-id who created this ticket
    private String user;
    //this will fill automatically. id of a user with role supporter
    @JsonIgnore
    private String supporter;

    @CreatedDate
    private Date createdDate;//fill automatically date

    //it prevent of id is coming from user to insert. and it not shows the id in output
    private void setId(String id) {
        this.id = id;
    }


}
