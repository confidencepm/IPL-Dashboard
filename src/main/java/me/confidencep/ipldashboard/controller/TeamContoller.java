package me.confidencep.ipldashboard.controller;

import me.confidencep.ipldashboard.model.Team;
import me.confidencep.ipldashboard.repository.MatchRepository;
import me.confidencep.ipldashboard.repository.TeamRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
public class TeamContoller {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamContoller(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = this.teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));

        return team;
    }
}
