package me.confidencep.ipldashboard.repository;

import me.confidencep.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);

}
