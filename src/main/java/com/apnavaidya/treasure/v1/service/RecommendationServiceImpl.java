package com.apnavaidya.treasure.v1.service;

import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnavaidya.treasure.Enum.SolutionType;
import com.apnavaidya.treasure.dao.ProblemDao;
import com.apnavaidya.treasure.dao.ProblemSolutionDao;
import com.apnavaidya.treasure.dao.ProblemSymptomDao;
import com.apnavaidya.treasure.dao.RequestResponseDao;
import com.apnavaidya.treasure.dto.RecommendationRequest;
import com.apnavaidya.treasure.dto.RecommendationResponse;
import com.apnavaidya.treasure.dto.RecommendedSolutionDTO;
import com.apnavaidya.treasure.model.DescriptionConvertor;
import com.apnavaidya.treasure.model.Problem;
import com.apnavaidya.treasure.model.RequestResponse;
import com.apnavaidya.treasure.v1.controller.RecommendationController;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	private static final Logger LOG = LoggerFactory.getLogger(RecommendationController.class);

	@Autowired
	private ProblemDao problemDao;

	@Autowired
	private ProblemRepository problemRepo;

	@Autowired
	private ProblemSolutionDao problemSolutionDao;

	@Autowired
	private RequestResponseDao requestResponseDao;

	@Autowired
	private ProblemSymptomDao problemSymptomDao;

	@Autowired
	private DescriptionConvertor convertor;

	private final static int MAX_PROBLEM_SIZE = 10000000;

	@SuppressWarnings("deprecation")
	public RecommendationResponse recommend(RecommendationRequest recommendationRequest, Long userId) throws Exception {

		ObjectMapper mapperObject = new ObjectMapper();
		RequestResponse requestResponse = new RequestResponse();

		List<RecommendedSolutionDTO> recommendedYoga = new ArrayList<RecommendedSolutionDTO>();
		List<RecommendedSolutionDTO> recommendedFood = new ArrayList<RecommendedSolutionDTO>();
		List<RecommendedSolutionDTO> recommendedRemedies = new ArrayList<RecommendedSolutionDTO>();
		List<String> recommendedDoctor = new ArrayList<String>();
		List<String> diagnosedSymptoms = new ArrayList<String>();
		List<Problem> daignosedproblems = null;
		RecommendationResponse recommendationResponse = new RecommendationResponse();

		int[] problemStatus = new int[MAX_PROBLEM_SIZE];

		try {
			String recomendationRequestAsString = mapperObject.writeValueAsString(recommendationRequest);
			requestResponse.setRequest(recomendationRequestAsString);
			requestResponse.setUserId(userId);

			List<String> problems = new ArrayList<String>();
			for (String problem : recommendationRequest.getProblems()) {
				problems.add(problem);
			}

			List<BigInteger> probIds = problemRepo.getProblemIdsByProblems(problems);

			// Logic for problem diagnosis on the basis of input symptom...
			// cur logic returns disease which having maximum occurance count in
			// all symptoms ..
			if (recommendationRequest.getDiagnose() != null && recommendationRequest.getDiagnose()) {
				int[] commonProblem = new int[MAX_PROBLEM_SIZE];
				int maxValue = 0;
				for (BigInteger probId : probIds) {
					problemStatus[probId.intValue()]++;
					List<BigInteger> probIdsOfSymptom = problemSymptomDao.findProbIdsBySympId(probId);
					if (null != probIdsOfSymptom && !probIdsOfSymptom.isEmpty()) {
						for (BigInteger sympId : probIdsOfSymptom) {
							commonProblem[sympId.intValue()]++;
							if (maxValue < commonProblem[sympId.intValue()])
								maxValue = commonProblem[sympId.intValue()];
						}
					}
				}

				List<BigInteger> diagnosedProbIds = new ArrayList<BigInteger>();
				for (int i = 1; i < MAX_PROBLEM_SIZE; i++) {
					if (maxValue != 0 && commonProblem[i] == maxValue) {
						BigInteger id = new BigInteger((new Integer(i)).toString());
						diagnosedProbIds.add(id);
						// diagnosedProbIds are added in original probIds...
						probIds.add(id);
					}

				}

				// calculating symptoms question to be asked....
				if (null != diagnosedProbIds && !diagnosedProbIds.isEmpty()) {

					// find all symptoms for each diagnosedProbId...

					for (BigInteger probId : diagnosedProbIds) {
						List<BigInteger> sympIdsofProblem = problemSymptomDao.findSympIdsByProbId(probId);
						for (BigInteger sympId : sympIdsofProblem) {
							if (problemStatus[sympId.intValue()] == 0) {
								Problem symptom = problemDao.findOne(Long.parseLong(sympId.toString()));
								if (null != symptom && null != symptom.getProblem())
									diagnosedSymptoms.add(symptom.getProblem());
							}
						}
					}

				}

			}

			LOG.info(" problem Ids : ", new Object[] { probIds.toString() });

			// getting recommendations...
			List<Object[]> recommendedSolutions = problemSolutionDao.getRecommendation(probIds);

			LOG.info(" value in recommendedSolutions , {} ", new Object[] { recommendedSolutions });

			if (null == recommendedSolutions || recommendedSolutions.isEmpty())
				throw new Exception("RECOMMENDATION NOT FOUND");

			for (Object[] recommendedSolution : recommendedSolutions) {
				RecommendedSolutionDTO solutionDTO = new RecommendedSolutionDTO();

				// setting solutiondto with databases values...
				if (null != recommendedSolution[0])
					solutionDTO.setSolution(convertor.convertToEntityAttribute(recommendedSolution[0].toString()));
				if (null != recommendedSolution[1])
					solutionDTO.setSolType(convertor.convertToEntityAttribute(recommendedSolution[1].toString()));
				if (null != recommendedSolution[2])
					solutionDTO.setStep(convertor.convertToEntityAttribute(recommendedSolution[2].toString()));
				if (null != recommendedSolution[3])
					solutionDTO.setDuration(recommendedSolution[3].toString());
				if (null != recommendedSolution[4])
					solutionDTO.setDays(Integer.parseInt(recommendedSolution[4].toString()));

				if (solutionDTO.getSolType().equals(SolutionType.YOGA.toString())) {
					recommendedYoga.add(solutionDTO);

				} else if (solutionDTO.getSolType().equals(SolutionType.FOOD.toString())) {
					recommendedFood.add(solutionDTO);

				} else if (solutionDTO.getSolType().equals(SolutionType.REMEDIES.toString())) {
					for (String problem : problems) {
						String str = solutionDTO.getSolution();
						if (str.toUpperCase().startsWith(problem.toUpperCase()))
							solutionDTO.setSolution(str.substring(problem.length()));

					}
					recommendedRemedies.add(solutionDTO);

				}
			}

			// set recommended doctor...

			recommendationResponse.setRecommendedYoga(recommendedYoga);
			recommendationResponse.setRecommendedRemedies(recommendedRemedies);
			recommendationResponse.setRecommendedFood(recommendedFood);
			recommendationResponse.setRecommendedDoctors(recommendedDoctor);
			recommendationResponse.setDiagnosedSymptoms(diagnosedSymptoms);

			String recommendationResponseAsString = mapperObject.writeValueAsString(recommendationResponse);
			requestResponse.setResponse(recommendationResponseAsString);
			return recommendationResponse;
		} catch (Exception e) {
			LOG.error("Error while getting solution of problem", e);
			throw new Exception("RECOMMENDATION NOT FOUND");
		} finally {
			requestResponseDao.save(requestResponse);
		}
	}

}
