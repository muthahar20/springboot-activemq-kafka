package com.mtr.springbootactivemqkafka.route;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RouteTwo extends RouteBuilder {


    String kafkaServer = "kafka:localhost:9092";
    String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
    String serializerClass = "serializerClass=kafka.serializer.StringEncoder";
    String toKafka = new StringBuilder().append(kafkaServer).append("?").append("testTopoicMsg").append("&")
            .append(zooKeeperHost).append("&").append(serializerClass).toString();


    @Override
    public void configure() throws Exception {
        from("activemq:queue:orders").
                log("+++++++++++++++++++ Consume Data from File and save data in output folder  +++++++++++++++++++").
                log("Pattern: ${exchange.pattern}").

               // to(toKafka).
              //  to("kafka:testTopicMsg?brokers=localhost:9092").
                to("file:/Users/muthaharshaik/Desktop/AAAA/output");

    }
}
