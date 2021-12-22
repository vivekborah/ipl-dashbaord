package com.vivek.ipldashbaord.repository;

import java.util.List;

import com.vivek.ipldashbaord.model.MatchIpl;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;



public interface MatchRepository extends CrudRepository<MatchIpl,Long> {
    
    List<MatchIpl> getByTeam1OrTeam2OrderByMatchDateDesc(String teamName1, String teamName2, Pageable pageable);

}
