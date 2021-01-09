package com.example.demo;

import com.example.demo.dto.StandingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "test",
        url = "${feign.client.config.standing.url:http://localhost:8080}",
        configuration = TestClientConfiguration.class)
public interface StandingApiClient {


    @RequestMapping(method = RequestMethod.GET,
            value = "/standing",
            produces = "application/json",
            consumes = "application/json")
    StandingDTO getStanding(@RequestParam(value = "countryName") String countryName,
                            @RequestParam(value = "leagueName") String leagueName,
                            @RequestParam(value = "teamName") String teamName);
}