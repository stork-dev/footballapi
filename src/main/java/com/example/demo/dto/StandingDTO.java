package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StandingDTO {

    private String countryId;
    private String countryName;

    private String leagueId;
    private String leagueName;

    private String teamId;
    private String teamName;

    private String overallLeaguePosition;

}
