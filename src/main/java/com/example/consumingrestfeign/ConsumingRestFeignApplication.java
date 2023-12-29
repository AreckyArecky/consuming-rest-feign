package com.example.consumingrestfeign;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

import java.util.List;

@Log4j2
@SpringBootApplication
@EnableFeignClients
public class ConsumingRestFeignApplication {

    @Autowired
    QuoteClient quoteClient;

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestFeignApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() {
        Quote result = quoteClient.makeSearchRequestWithParam("2");
       List<Quote> result2 = quoteClient.makeSearchRequestWithHeader("costam");
        log.info(result);
        log.info(result2);
        quoteClient.addQuote(new QuoteValueBuilder("Is this gonna work?").build());
        result2 = quoteClient.makeSearchRequestWithHeader("working???");
        log.info(result2);

//quoteClient.deleteQuoteById("14");

    }
}
