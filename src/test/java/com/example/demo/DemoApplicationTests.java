package com.example.demo;

import com.example.demo.dto.StandingDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.openfeign.EnableFeignClients;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableFeignClients
class DemoApplicationTests {

	@Autowired
	StandingApiClient client;

	@Test
	void contextLoads() {
	}

	@Test
	public void testStanding(){
		StandingDTO dto = client.getStanding("England","Championship","Bournemouth");

		assertNotNull(dto);
		assertEquals(dto.getCountryName(), "England");
		assertEquals(dto.getLeagueName(), "Championship");
		assertEquals(dto.getTeamName(), "Bournemouth");
		assertNotNull(dto.getOverallLeaguePosition());
	}
}
