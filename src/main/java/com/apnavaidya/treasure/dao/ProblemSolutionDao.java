package com.apnavaidya.treasure.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.ProblemSolution;

@RestResource(exported = false)
public interface ProblemSolutionDao extends CrudRepository<ProblemSolution, Integer> {

	@Query(value = "select distinct s.solution,s.sol_type,s.step,d.duration,d.days from apnavaidya.solution as s,apnavaidya.problem_solution as ps,apnavaidya.dose as d  where s.id = ps.sol_id and ps.dose_id = d.id and s.id in ( select sol_id from apnavaidya.problem_solution where problem_solution.prob_id in  (:probIds) and problem_solution.sol_id not in ( select sol_id from apnavaidya.solution_beware where solution_beware.prob_id in (:probIds) ) )", nativeQuery = true)
	public List<Object[]> getRecommendation(@Param("probIds") List<BigInteger> probIds);
}
