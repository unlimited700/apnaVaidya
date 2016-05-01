package com.apnavaidya.treasure.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.apnavaidya.treasure.model.Dose;

@RestResource(exported = false)
public interface DoseDao extends CrudRepository<Dose, Long> {

}
