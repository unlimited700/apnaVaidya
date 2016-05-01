package com.apnavaidya.treasure.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnavaidya.treasure.dao.SolutionDao;
import com.apnavaidya.treasure.dto.SolutionDTO;
import com.apnavaidya.treasure.dto.SolutionRequest;
import com.apnavaidya.treasure.model.Solution;
import com.apnavaidya.treasure.dto.Response;
import com.apnavaidya.treasure.dto.SolutionRequest;

@Service
public class SolutionServiceImpl implements SolutionService {

	@Autowired
	private SolutionDao solutionDao;

	@Override
	public Response create(SolutionRequest SolutionRequest) {
		Response response = new Response();

		for (SolutionDTO solutionDTO : SolutionRequest.getSolutions()) {
			Solution solution = new Solution();
			solution.setSolution(solutionDTO.getSolution());
			solution.setSolType(solutionDTO.getSolType());
			solution.setStep(solutionDTO.getStep());
			solution.setContradiction(solutionDTO.getContradiction());
			solutionDao.save(solution);
		}
		return response;
	}
}
