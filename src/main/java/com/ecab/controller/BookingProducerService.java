package com.ecab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecab.model.Employez;
import com.ecab.service.BookingExchange;
import com.ecab.service.MessageExchange;

@RestController
@RequestMapping(value = "/booking")
public class BookingProducerService {

	@Autowired
	MessageExchange messageExchange;
	
	@Autowired
	BookingExchange bookingExchange;
	

	@PostMapping(value = "/add")
	public String bookingCreate(@RequestBody Employez emp) {
	
		messageExchange.send(emp);

		return "Message sent to the RabbitMQ Ecab Successfully"+emp.toString();
	}

	@PutMapping(value = "/update")
	public String bookingUpdate(@RequestBody Employez emp) {
	
		System.out.println("\nfind the id \n");
		messageExchange.send(emp);

		return "Message sent to the RabbitMQ Ecab Successfully";
	}
	
	
	@DeleteMapping(value = "/update")
	public String bookingDelete(int id) {
	
		System.out.println("\nfind the id \n");
		// rabbitMQSender.send(emp);

		return "Given booking id is not available in database";
	}
	
	
	
	@GetMapping(value = "/getmesg")
	public Employez consumerTwo() {
	
		System.out.println("\n Entereed producer\n");
		return messageExchange.listen();		
	}
	
	@GetMapping(value = "/employees")
    List<Employez> getAllEmployee(){
        return bookingExchange.findAll();
    }
}

