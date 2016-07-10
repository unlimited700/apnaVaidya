package com.apnavaidya.treasure.v1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.apnavaidya.treasure.Enum.ProblemType;
import com.apnavaidya.treasure.dao.ProblemDao;
import com.apnavaidya.treasure.dao.ProblemSolutionDao;
import com.apnavaidya.treasure.dao.ProblemSolutionNameDao;
import com.apnavaidya.treasure.dao.SolutionDao;
import com.apnavaidya.treasure.dto.ProblemSolutionDose;
import com.apnavaidya.treasure.dto.ProblemSolutionList;
import com.apnavaidya.treasure.dto.Response;
import com.apnavaidya.treasure.model.DescriptionConvertor;
import com.apnavaidya.treasure.model.Problem;
import com.apnavaidya.treasure.model.ProblemSolution;
import com.apnavaidya.treasure.model.ProblemSolutionName;
import com.apnavaidya.treasure.model.ProblemSymptom;
import com.apnavaidya.treasure.model.ProblemSymptomName;
import com.apnavaidya.treasure.model.Solution;

@Service
public class ProblemSolutionServiceImpl implements ProblemSolutionService {

	private static final Logger LOG = LoggerFactory.getLogger(ProblemSolutionServiceImpl.class);

	@Autowired
	private ProblemDao problemDao;

	@Autowired
	private SolutionDao solutionDao;

	@Autowired
	private ProblemSolutionDao problemSolutionDao;

	@Autowired
	private ProblemSolutionNameDao problemSolutionNameDao;

	@Autowired
	private ProblemRepository problemRepo;

	@Autowired
	private SolutionRepository solutionRepo;

	@Override
	public Response create(ProblemSolutionList problemSolutionList) {
		Response response = new Response();

		try {
			if (null == problemSolutionList)
				throw new Exception("Null Value problemSolutionList");

			Problem problem = null;
			Solution solution = null;
			List<Problem> problems;
			List<Solution> solutions;

			Long probId;
			Long solId;
			Long doseId;
			Long rating;

			for (ProblemSolutionDose problemSolutionDose : problemSolutionList.getProblemSolutionDose()) {
				if (null == problemSolutionDose)
					throw new Exception("Null Value problemSolutionDose");

				problems = problemRepo.findByProblem(problemSolutionDose.getProblem());

				if (null == problems || problems.isEmpty()) {
					problem = new Problem();
					problem.setProblem(problemSolutionDose.getProblem());
					problemDao.save(problem);

				} else {
					problem = problems.get(0);
				}
				probId = problem.getId();

				solutions = solutionRepo.findBySolution(problemSolutionDose.getSolution());
				if (null == solutions || solutions.isEmpty()) {
					solution = new Solution();
					solution.setSolution(problemSolutionDose.getSolution());
					solutionDao.save(solution);
				} else {
					solution = solutions.get(0);
				}
				solId = solution.getId();
				doseId = problemSolutionDose.getDoseId();

				if (null == problemSolutionDose.getRating())
					rating = 0L;
				else
					rating = problemSolutionDose.getRating();

				ProblemSolution problemSolution = new ProblemSolution();
				if (null == probId || null == solId || null == problemSolutionDose.getDoseId())
					throw new Exception("Null either probId or solId or doseId");
				problemSolution.setProbId(probId);
				problemSolution.setSolId(solId);
				problemSolution.setDoseId(doseId);
				problemSolution.setRating(rating);

				problemSolutionDao.save(problemSolution);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage("Exception occured!!!");
			response.setResponseCode(500);
		}

		return response;
	}

	@Override
	public Response problemSolutionMapping() {
		Response response = new Response();
		List<ProblemSolutionName> problemSolutionNameList = (List<ProblemSolutionName>) problemSolutionNameDao
				.findAll();

		for (ProblemSolutionName problemSolutionName : problemSolutionNameList) {
			ProblemSolution problemSolution = new ProblemSolution();

			List<Problem> problems = problemRepo.findByProblem(problemSolutionName.getProblem());
			List<Solution> solutions = solutionRepo.findBySolution(problemSolutionName.getSolution());

			Problem problem = null;
			Solution solution = null;
			try {
				if (null != problems && !problems.isEmpty() && null != solutions && !solutions.isEmpty()) {
					problem = problems.get(0);
					solution = solutions.get(0);
					if (null != problem && null != solution) {
						problemSolution.setProbId(problem.getId());
						problemSolution.setSolId(solution.getId());
						problemSolution.setDoseId(1L);
						problemSolution.setRating(0L);
						problemSolutionDao.save(problemSolution);
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
