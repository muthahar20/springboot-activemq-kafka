package com.mtr.springbootactivemqkafka.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RouteOne extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:orders?noop=true").
                log("    fiel:order ===> activeMQ   ").
                to("activemq:queue:orders");
    }
}
