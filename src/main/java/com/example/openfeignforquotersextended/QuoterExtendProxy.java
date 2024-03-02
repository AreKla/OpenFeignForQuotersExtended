package com.example.openfeignforquotersextended;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "quoter-extend-server-client")
interface QuoterExtendProxy {

    @RequestMapping("/api/random")
    String getRandomQuote();

    @GetMapping("/api/{id}")
    String getById(@PathVariable("id") long id);

    @GetMapping("/api")
    String showAllQuotes();

    @GetMapping("/apiWithRequestParam")
    String getByParam(@RequestParam("id") long id);
}