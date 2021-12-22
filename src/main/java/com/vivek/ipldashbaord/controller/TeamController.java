package com.vivek.ipldashbaord.controller;

import com.vivek.ipldashbaord.model.Team;
import com.vivek.ipldashbaord.repository.MatchRepository;
import com.vivek.ipldashbaord.repository.TeamRepository;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {
    

private TeamRepository teamRepository;
private MatchRepository matchRepository;  


public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
    this.teamRepository = teamRepository;
    this.matchRepository = matchRepository;
}





@GetMapping("/team/{teamName}")
public Team getTeam(@PathVariable String teamName){

    Team team=teamRepository.findByTeamName(teamName);
    Pageable pageable=PageRequest.of(0, 4);
    team.setMatches(matchRepository.getByTeam1OrTeam2OrderByMatchDateDesc(teamName, teamName,pageable));
    return team;
    
}

}
