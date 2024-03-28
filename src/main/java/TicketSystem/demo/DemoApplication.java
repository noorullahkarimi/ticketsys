package TicketSystem.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
//for connection to the mongo is nessessory
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//this anotation is for automatic fill date
@EnableMongoAuditing
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
