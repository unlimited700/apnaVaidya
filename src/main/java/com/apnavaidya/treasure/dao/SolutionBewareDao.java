package com.apnavaidya.treasure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.SolutionBeware;

@RestResource(exported = false)
public interface SolutionBewareDao extends CrudRepository<SolutionBeware, Long> {

}
