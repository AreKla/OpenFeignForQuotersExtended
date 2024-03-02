package com.example.openfeignforquotersextended;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "quoter-extend-server-client")
public interface QuoterExtendProxy {

    @RequestMapping("/api/random")
    String request();

}