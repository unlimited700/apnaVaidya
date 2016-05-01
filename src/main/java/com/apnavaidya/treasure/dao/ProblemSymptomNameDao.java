package com.apnavaidya.treasure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.ProblemSymptomName;

@RestResource(exported = false)
public interface ProblemSymptomNameDao extends CrudRepository<ProblemSymptomName, Long> {

}
