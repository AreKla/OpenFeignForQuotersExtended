package com.example.openfeignforquotersextended;

import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;

import java.util.List;


@SpringBootApplication
@EnableFeignClients
@Log4j2
public class OpenFeignForQuotersExtendedApplication {

    QuoterExtendProxy quoterExtendClient;

    public OpenFeignForQuotersExtendedApplication(QuoterExtendProxy quoterExtendClient) {
        this.quoterExtendClient = quoterExtendClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignForQuotersExtendedApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToQuoterExtend() {

        try {
            log.info(quoterExtendClient.showAllQuotes());
            log.info(quoterExtendClient.getById(3));
            log.info(quoterExtendClient.getRandomQuote());
            log.info(quoterExtendClient.getByParam(7));
            log.info(quoterExtendClient.getAllWithHeader());
            log.info(quoterExtendClient.addQuote(new QuoteValue(null, "New quote ADDER XXX")));
            log.info(quoterExtendClient.deleteById(10));
        } catch (FeignException.FeignClientException feignException) {
            log.error("Client exception: " + feignException.status());
        } catch (FeignException.FeignServerException feignException) {
            log.error("Server exception: " + feignException.status());
        } catch (RetryableException retryableException) {
            log.error("RetryableException: " + retryableException.getMessage());
        } catch (FeignException feignException) {
            log.error(feignException.status() + " " + feignException.getMessage());
        }

    }
}