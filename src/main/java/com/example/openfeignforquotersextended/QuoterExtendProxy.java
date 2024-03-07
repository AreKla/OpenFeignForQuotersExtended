package com.example.openfeignforquotersextended;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "quoter-extend-server-client")
@Component
interface QuoterExtendProxy {

    @GetMapping("/api")
    String showAllQuotes();

    @GetMapping("/api/{id}")
    String getById(@PathVariable("id") long id);

    @GetMapping("/api/random")
    String getRandomQuote();

    @GetMapping("/apiWithRequestParam")
    String getByParam(@RequestParam("id") long id);

    @GetMapping("/apiWithHeader")
    String getAllWithHeader();

    @RequestMapping(method = RequestMethod.POST, value = "/api/quote")
    ResponseEntity<QuoteExtendResponse> addQuote(@RequestBody QuoteExtendResult quote);

    @DeleteMapping("/api/quote/{id}")
    void deleteById(@PathVariable("id") long id);

}