package com.vivek.ipldashbaord.repository;

import com.vivek.ipldashbaord.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository <Team,Long>{

        Team findByTeamName(String teamName);
    
}
