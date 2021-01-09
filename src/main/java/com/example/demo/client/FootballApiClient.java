package com.example.demo.client;

import com.example.demo.config.ClientConfiguration;
import com.example.demo.model.Country;
import com.example.demo.model.League;
import com.example.demo.model.Standing;
import com.example.demo.model.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "apifootball",
        url = "${feign.client.config.apifootball.url:https://apiv2.apifootball.com/}",
        configuration = ClientConfiguration.class)
public interface FootballApiClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "",
            produces = "application/json" ,
            consumes = "application/json")
    List<Country> getCountry(@RequestParam(value = "action") String action, @RequestParam(value = "APIkey") String apiKey );

    @RequestMapping(method = RequestMethod.GET,
            value = "",
            produces = "application/json" ,
            consumes = "application/json")
    List<League> getLeague(@RequestParam(value = "action") String action,
                           @RequestParam(value = "country_id") String countryId,
                           @RequestParam(value = "APIkey") String apiKey );

    @RequestMapping(method = RequestMethod.GET,
            value = "",
            produces = "application/json" ,
            consumes = "application/json")
    List<Team> getTeam(@RequestParam(value = "action") String action,
                       @RequestParam(value = "league_id") String leagueId,
                       @RequestParam(value = "APIkey") String apiKey );

    @RequestMapping(method = RequestMethod.GET,
            value = "",
            produces = "application/json" ,
            consumes = "application/json")
    List<Standing> getStanding(@RequestParam(value = "action") String action,
                               @RequestParam(value = "league_id") String leagueId,
                               @RequestParam(value = "APIkey") String apiKey );
}