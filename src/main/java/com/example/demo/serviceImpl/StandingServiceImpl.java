package com.example.demo.serviceImpl;

import com.example.demo.client.FootballApiClientFacade;
import com.example.demo.model.Country;
import com.example.demo.model.League;
import com.example.demo.model.Standing;
import com.example.demo.model.Team;
import com.example.demo.service.StandingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandingServiceImpl implements StandingService {

    private final FootballApiClientFacade footballApiClientFacade;


    public StandingServiceImpl(final FootballApiClientFacade footballApiClientFacade) {
        this.footballApiClientFacade = footballApiClientFacade;
    }

    @Override
    public Standing findStanding(final String countryName, final String leagueName, final String teamName) {
        Optional<Country> country = footballApiClientFacade.getCountry(countryName);
        Optional<League> league = footballApiClientFacade.getLeague(leagueName, country.map(Country::getCountryId).orElse(null));
        Optional<Team> team = footballApiClientFacade.getTeam(teamName, league.map(League::getLeagueId).orElse(null));
        List<Standing> standings = footballApiClientFacade.getStanding(league.map(League::getLeagueId).orElse(null));

        return standings.stream()
                .filter(s -> s.getTeamName().equals(team.map(Team::getTeamName).orElse(null)))
                .findFirst()
                .map(s -> {
                    s.setCountryId(country.map(Country::getCountryId).orElse(null));
                    return s;
                })
                .orElse(null);
    }
}
