package com.apnavaidya.treasure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.Solution;

@RestResource(exported = false)
public interface RecommendedSolutionDao extends CrudRepository<Solution, Long> {

}
