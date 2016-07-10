package com.apnavaidya.treasure.v1.service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.apnavaidya.treasure.dao.ProblemDao;
import com.apnavaidya.treasure.model.DescriptionConvertor;
import com.apnavaidya.treasure.model.Problem;

@Service
public class ProblemRepository {

	/*
	 * the purpose of this class is to handle encryption or such scenarios
	 * before accessing dao layer
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ProblemRepository.class);

	@Autowired
	private ProblemDao problemDao;

	@Autowired
	private DescriptionConvertor convertor;

	public List<Problem> findByProblem(String problem) {
		return problemDao.findByProblem(convertor.convertToDatabaseColumn(problem));
	}

	public List<BigInteger> getProblemIdsByProblems(List<String> problems) {

		int i = 0;
		for (String problem : problems) {
			problems.set(i, convertor.convertToDatabaseColumn(problem));
			LOG.info( " value at i {} is {} , " ,new Object[] { i , problems.get(i) } ) ;
			i++;
		}

		return problemDao.getProblemIdsByProblems(problems);
	}

	public Problem findByProblemAndProbType(String problem, String probType) {
		return problemDao.findByProblemAndProbType(convertor.convertToDatabaseColumn(problem), probType);
	}

	public List<Problem> getProblemsByIds(@Param("diagnosedProbIds") List<Integer> diagnosedProbIds) {
		return problemDao.getProblemsByIds(diagnosedProbIds);
	}
}
