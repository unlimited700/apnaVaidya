package com.apnavaidya.treasure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.ProblemSolutionName;

@RestResource(exported = false)
public interface ProblemSolutionNameDao extends CrudRepository<ProblemSolutionName, Long> {

}
