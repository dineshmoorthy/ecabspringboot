package com.ecab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecab.model.Employez;
import com.ecab.service.BookingProducerService;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

	@Autowired
	BookingProducerService bookingproducerservice;

	@PostMapping(value = "/add")
	public String bookingCreate(@RequestBody Employez emp) {

		bookingproducerservice.createbooking(emp);

		return "Message sent to the RabbitMQ Ecab Successfully" + emp.toString();
	}

	@PutMapping(value = "/update")
	public String bookingUpdate(@RequestBody Employez emp) {

		System.out.println("\nfind the id \n");
		bookingproducerservice.updatebooking(emp);

		return "Message sent to the RabbitMQ Ecab Successfully";
	}

	@DeleteMapping(value = "/delete/{id}")
	public String bookingDelete(@PathVariable Integer id) {

		System.out.println("\nfind the id : " + id);
		bookingproducerservice.deletebooking(id);

		return "Given booking id is Deleted in database";
	}

	@GetMapping(value = "/employees")
	List<Employez> getAllEmployee() {
		return bookingproducerservice.getAllEmployee();
	}
}
