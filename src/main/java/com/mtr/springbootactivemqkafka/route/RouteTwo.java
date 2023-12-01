package com.mtr.springbootactivemqkafka.route;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RouteTwo extends RouteBuilder {


    @Value("${topic.name.producer}")
    private String topicName;

    private static final String KAFKA_HOST_SERVER   = "kafka://localhost:9092?";
    private static final String KAFKA_TOPIC_NAME    = "topic=testTopicMsg";
    private static final String KAFKA_BROKER_NAME   = "&brokers=localhost:9092";
    String destination = KAFKA_HOST_SERVER + KAFKA_TOPIC_NAME + KAFKA_BROKER_NAME;


    @Override
    public void configure() throws Exception {
        from("activemq:queue:orders").
                log("+++++++++++++++++++ Consume Data from File and save data in output folder  +++++++++++++++++++").
                log("Pattern: ${exchange.pattern}").

                to(destination).
              //  to("kafka:topicName?brokers=localhost:9092").
                to("file:/Users/muthaharshaik/Desktop/AAAA/output");

    }
}
