package com.example.openfeignforquotersextended;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "quoter-extend-server-client")
interface QuoterExtendProxy {

    @GetMapping("/api/random")
    String getRandomQuote();

    @GetMapping("/api/{id}")
    String getById(@PathVariable("id") long id);

    @GetMapping("/api")
    String showAllQuotes();

    @GetMapping("/apiWithRequestParam")
    String getByParam(@RequestParam("id") long id);

    @PostMapping("/api/quote")
    ResponseEntity<String> addQuote(@RequestBody Quote quote);

    @DeleteMapping("/api/quote/{id}")
    String deleteById(@PathVariable("id") long id);

}