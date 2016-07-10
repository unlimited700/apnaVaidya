package com.apnavaidya.treasure.v1.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.apnavaidya.treasure.Enum.ProblemType;
import com.apnavaidya.treasure.dao.ProblemDao;
import com.apnavaidya.treasure.dao.ProblemSymptomDao;
import com.apnavaidya.treasure.dao.ProblemSymptomNameDao;
import com.apnavaidya.treasure.dto.ProblemDTO;
import com.apnavaidya.treasure.dto.ProblemRequest;
import com.apnavaidya.treasure.dto.ProblemsDTO;
import com.apnavaidya.treasure.dto.Response;
import com.apnavaidya.treasure.model.Problem;
import com.apnavaidya.treasure.model.ProblemSymptom;
import com.apnavaidya.treasure.model.ProblemSymptomName;
import com.apnavaidya.treasure.v1.controller.RecommendationController;

@Service
public class ProblemServiceImpl implements ProblemService {

	private static final Logger LOG = LoggerFactory.getLogger(ProblemServiceImpl.class);

	@Autowired
	private ProblemDao problemDao;

	@Autowired
	private ProblemSymptomNameDao problemSymptomNameDao;

	@Autowired
	private ProblemSymptomDao problemSymptomDao;

	@Autowired
	private ProblemRepository problemRepo;

	public Response create(ProblemRequest problemRequest) {
		Response response = new Response();

		for (ProblemDTO problemDTO : problemRequest.getProblems()) {
			Problem problem = new Problem();
			problem.setProblem(problemDTO.getProblem());
			problem.setProbType(problemDTO.getProbType());
			problemDao.save(problem);
		}
		return response;
	}

	@Override
	public ProblemsDTO getProblems() {
		ProblemsDTO problems = new ProblemsDTO();
		try {

			List<String> problemList = new ArrayList<String>();

			List<Problem> problemDaoList = (List<Problem>) problemDao.findAll();

			for (Problem problem : problemDaoList) {
				problemList.add(problem.getProblem());
			}
			problems.setProblems(problemList);

		} catch (Exception e) {
			e.printStackTrace();
			problems.setMessage("Exception Occured!!!");
			problems.setResponseCode(500);
		}
		return problems;
	}

	public Response problemSymptomMapping() {
		Response response = new Response();
		List<ProblemSymptomName> problemSymptomNameList = (List<ProblemSymptomName>) problemSymptomNameDao.findAll();

		for (ProblemSymptomName problemSymptomName : problemSymptomNameList) {
			ProblemSymptom problemSymptom = new ProblemSymptom();
			Problem symptom = problemRepo.findByProblemAndProbType(problemSymptomName.getSymptom(),
					ProblemType.SYMPTOM.toString());
			List<Problem> problems = problemRepo.findByProblem(problemSymptomName.getProblem());
			Problem problem = null;
			try {
				if (null != problems && !problems.isEmpty()) {
					problem = problems.get(0);
					if (null != problem && null != symptom) {
						problemSymptom.setProbId(problem.getId());
						problemSymptom.setSympId(symptom.getId());
						problemSymptomDao.save(problemSymptom);
					}

				}
			} catch (DataIntegrityViolationException ex) {
				LOG.error("error while saving...");
				ex.printStackTrace();
			}

		}
		return response;
	}
}
