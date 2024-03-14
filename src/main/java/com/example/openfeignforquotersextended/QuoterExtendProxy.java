package com.example.openfeignforquotersextended;

import org.apache.logging.log4j.Marker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "quoter-extend-server-client")
@Component
interface QuoterExtendProxy {

    @GetMapping("/api")
    List<QuoteExample> showAllQuotes();

    @GetMapping("/api/{id}")
    QuoteExample getById(@PathVariable("id") long id);

    @GetMapping("/api/random")
    QuoteExample getRandomQuote();

    @GetMapping("/apiWithRequestParam")
    QuoteExample getByParam(@RequestParam("id") long id);

    @GetMapping("/apiWithHeader")
    List<QuoteExample> getAllWithHeader();

    @RequestMapping(method = RequestMethod.POST, value = "/api/quote")
    ResponseEntity<QuoteExample> addQuote(@RequestBody QuoteValue quote);

    @DeleteMapping("/api/quote/{id}")
    Marker deleteById(@PathVariable("id") long id);

}