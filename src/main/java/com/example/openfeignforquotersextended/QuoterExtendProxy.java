package com.example.openfeignforquotersextended;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "quoter-extend-server-client")
public interface QuoterExtendProxy {

    @RequestMapping("/api/random")
    String getRandom();

    @RequestMapping("/api/{id}")
    String getId(
            @RequestParam("id") long id
    );

    @RequestMapping("/api")
    String showALlQuots();
}