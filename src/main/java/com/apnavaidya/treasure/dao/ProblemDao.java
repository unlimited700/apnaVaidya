package com.apnavaidya.treasure.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.Problem;

@RestResource(exported = false)
public interface ProblemDao extends CrudRepository<Problem, Long> {

	/*
	 * problem column in problem table needs encryption to convert into hindi
	 */

	@Query(value = "select id from problem where problem in (:problems)", nativeQuery = true)
	public List<BigInteger> getProblemIdsByProblems(@Param("problems") List<String> problems);

	@Query(value = "select * from problem where problem = :problem", nativeQuery = true)
	public List<Problem> findByProblem(@Param("problem") String problem);

	@Query(value = "select * from problem where problem = :problem and prob_type = :probType", nativeQuery = true)
	public Problem findByProblemAndProbType(@Param("problem") String problem, @Param("probType") String probType);

	@Query(value = "select * from problem where id in (:diagnosedProbIds)", nativeQuery = true)
	public List<Problem> getProblemsByIds(@Param("diagnosedProbIds") List<Integer> diagnosedProbIds);
}
