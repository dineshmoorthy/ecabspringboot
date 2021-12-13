package com.ecab.exchange;

import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ecab.model.Employez;
import com.ecab.repository.EmployeeRepository;

@Component
public class MessageExchange {

	@Autowired
	private RabbitTemplate template;

	@Value("${ecab.rabbitmq.queue}")
	String queueName;

	@Value("${ecab.rabbitmq.exchange}")
	String exchange;

	@Value("${ecab.rabbitmq.routingkey}")
	private String routingkey;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Bean
	Queue queue() {
		return new Queue(queueName, true);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		System.out.println("\n Binding done\n" + exchange.getName() + "\n" + queue.getName());
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}

	public void saveAndSend(Employez employee) {
		System.out.println("Send msg = " + employee);
		employeeRepository.save(employee);
		template.convertAndSend(exchange, routingkey, employee);

	}

	public void updateAndSend(Employez employee) {
		System.out.println("Send msg = " + employee);
		employeeRepository.save(employee);
		template.convertAndSend(exchange, routingkey, employee);

	}

	public void delete(int id) {
		System.out.println("Send msg = " + id);
		Employez employez = employeeRepository.getOne(id);
		employeeRepository.delete(id);

	}

	public List<Employez> getAllBooking() {

		return employeeRepository.findAll();

	}
}