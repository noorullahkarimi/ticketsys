package TicketSystem.demo.dto;

import TicketSystem.demo.staticquantity.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "users")
//automatic setter & getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    //id with type string automatically fill with mongodb
    private String id;
    private String name;

    //prevent of the showing password in output
    @JsonIgnore
    private String password;
    //in real project roles define in another table role(but we make it easy)
    //it just accept from the enum value (ADMIN, SUPPORT, CUSTOMER)
    private UserRole role;

    @CreatedDate
    private Date createdDate;//fill automatically date

 //it prevent of id is coming from user to insert. and it not shows the id in output
    private void setId(String id) {
        this.id = id;
    }
}
