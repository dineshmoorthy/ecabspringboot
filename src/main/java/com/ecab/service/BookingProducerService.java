package com.ecab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecab.exchange.MessageExchange;
import com.ecab.model.Employez;
import com.ecab.repository.EmployeeRepository;

@Service
public class BookingProducerService {

	@Autowired
	MessageExchange messageExchange;
	
	@Autowired
    EmployeeRepository repository;
	
	public String createbooking(Employez emp) {
	
		messageExchange.saveAndSend(emp);

		return "Message sent to the RabbitMQ Ecab Successfully"+emp.toString();
	}

	public String updatebooking(Employez emp) {
	
		System.out.println("\nfind the id \n");
		messageExchange.updateAndSend(emp);

		return "Message sent to the RabbitMQ Ecab Successfully";
	}
	
	
	public String deletebooking(int id) {
		messageExchange.delete(id);
		System.out.println("\nfind the id \n");
		return "Given booking id is not available in database";
	}
	
	
	
    public List<Employez> getAllEmployee(){
        return messageExchange.getAllBooking();
    }
}

