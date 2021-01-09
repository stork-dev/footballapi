package com.example.demo.service;

import com.example.demo.model.Standing;

public interface StandingService {
    Standing findStanding(String countryName, String leagueName, String teamName);
}
