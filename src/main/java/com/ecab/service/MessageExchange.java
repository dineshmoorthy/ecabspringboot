package com.ecab.service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ecab.model.Employez;

@Service
public class MessageExchange {
	
	@Autowired
//	private AmqpTemplate amqpTemplate;
	private RabbitTemplate template;
	
	

	@Value("${ecab.rabbitmq.queue}")
	String queueName;

	@Value("${ecab.rabbitmq.exchange}")
	String exchange;

	@Value("${ecab.rabbitmq.routingkey}")
	private String routingkey;

	@Autowired
	private BookingExchange bookingexchange;
	
	@Bean Queue queue() { return new Queue(queueName, true); }
	 

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
		//return new DirectExchange(queueName);
	}

	
	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		System.out.println("\n Binding done\n" + exchange.getName()+"\n"+queue.getName());
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}
	
	public void send(Employez employee) {
		//template.convertAndSend("OMMMMMG");
		//template.convertAndSend(exchange, routingkey, "Silkkkkkk");
		// To do add db here
		Employez savedEmployee = bookingexchange.save(employee);
		template.convertAndSend(exchange, routingkey, employee);
		System.out.println("Send msg = " + employee);
	    
	}
	
	public void firstSend(String message) {
		System.out.println("\n start ::: "+template.toString()+"\n Entered service :::: " + message);
		template.convertAndSend("OMMMMMG");
		//amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg ======= " + message);
	    
	}


	public Employez listen() {
		Employez result = (Employez) template.receiveAndConvert(queueName);
		System.out.println("\n listen ::: "+ result);
		return result;
		
	}
}