package com.apnavaidya.treasure.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.apnavaidya.treasure.dao.SolutionDao;
import com.apnavaidya.treasure.model.DescriptionConvertor;
import com.apnavaidya.treasure.model.Solution;

@Service
public class SolutionRepository {

	/*
	 * the purpose of this class is to handle encryption or such scenarios
	 * before accessing dao layer
	 */
	@Autowired
	private SolutionDao solutionDao;

	@Autowired
	private DescriptionConvertor convertor;

	public List<Solution> findBySolution(@Param("solution") String solution) {
		return solutionDao.findBySolution(convertor.convertToDatabaseColumn(solution));
	}
}
