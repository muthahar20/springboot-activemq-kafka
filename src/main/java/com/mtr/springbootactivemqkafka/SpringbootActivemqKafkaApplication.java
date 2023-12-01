package com.mtr.springbootactivemqkafka;

import org.apache.camel.CamelContext;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.apache.camel.language.bean.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringbootActivemqKafkaApplication {

	@Autowired
	private CamelContext context;

	@PostConstruct
	public void init() throws Exception {
		context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));
		//context.addComponent("kafka", new KafkaComponent());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActivemqKafkaApplication.class, args);
	}


}
