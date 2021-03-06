package com.cricketgullygully.console.controller;

import com.cricketgullygully.console.entity.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cricketgullygully.console.entity.Team;

import com.cricketgullygully.console.service.TeamService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("team")
@CrossOrigin
public class TeamController {

	@Autowired
	private TeamService teamService;

	@PostMapping("/create")
	public Team createTeam(@RequestBody Team team) {
		log.debug("called saveTeam");
		return teamService.saveTeam(team);
	}
	@PostMapping("/createMany")
	public List<Team> createTeams(@RequestBody List<Team> team) {
		log.debug("called createTeams");
		return teamService.saveManyTeam(team);
	}

	@GetMapping("/{id}")
	public Team getTeam(@PathVariable long id) {
		log.debug("Called getTeam");
		return teamService.getTeamById(id);
	}
	@GetMapping("/")
	public List<Team> getAllTeams() {
		log.debug("Called getAllTeams");
		return teamService.getTeams();
	}
	@GetMapping("/{teamId}/players")
	public List<Player> getPlayersByTeamId(@PathVariable long teamId) {
		log.debug("Called getPlayersByTeamId");
		return teamService.getPlayers(teamId);
	}
	@GetMapping("/players/{teamShortName}")
	public List<Player> getPlayersByTeamId(@PathVariable String teamShortName) {
		log.debug("Called getPlayersByTeamId");
		return teamService.getPlayers(teamShortName);
	}

}
