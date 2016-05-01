package com.apnavaidya.treasure.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.Solution;

@RestResource(exported = false)
public interface SolutionDao extends CrudRepository<Solution, Long> {

	@Query(value = "select * from solution where solution = :solution", nativeQuery = true)
	public List<Solution> findBySolution(@Param("solution") String solution);

}
