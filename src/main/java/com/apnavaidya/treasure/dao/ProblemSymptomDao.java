package com.apnavaidya.treasure.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.ProblemSymptom;

@RestResource(exported = false)
public interface ProblemSymptomDao extends CrudRepository<ProblemSymptom, Long> {

	@Query(value = "select prob_id from problem_symptom where symp_id = :sympId", nativeQuery = true)
	List<BigInteger> findProbIdsBySympId(@Param("sympId") BigInteger sympId);

	@Query(value = "select symp_id from problem_symptom where prob_id = :probId", nativeQuery = true)
	List<BigInteger> findSympIdsByProbId(@Param("probId") BigInteger probId);

}
