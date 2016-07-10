package com.apnavaidya.treasure.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnavaidya.treasure.dto.ProblemRequest;
import com.apnavaidya.treasure.dto.ProblemsDTO;
import com.apnavaidya.treasure.dto.Response;
import com.apnavaidya.treasure.v1.service.ProblemService;

@RestController
public class ProblemController {

	private static final Logger LOG = LoggerFactory.getLogger(ProblemController.class);

	@Autowired
	private ProblemService problemService;

	@RequestMapping(method = RequestMethod.POST, value = "/v1/problem", produces = "application/json", consumes = "application/json")
	public Response create(@RequestBody ProblemRequest problemRequest) {
		Response response = null;
		LOG.info("Request received to creating problems with values {} ", new Object[] { problemRequest });
		try {
			response = problemService.create(problemRequest);
		} catch (Exception e) {
			LOG.error(" Error while creating problems " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned to create problems with values {} ", new Object[] { response });
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/v1/problems", produces = "application/json", consumes = "application/json")
	public ProblemsDTO getProblems() {
		ProblemsDTO response = null;
		LOG.info("Request received of fetching list of problems");
		try {
			response = problemService.getProblems();
		} catch (Exception e) {
			LOG.error(" Error while fetching problems " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned of fetching list of problems {} ", new Object[] { response });
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/v1/problem-symptom-mapping", produces = "application/json", consumes = "application/json")
	public Response problemSymptomMapping() {
		Response response = null;
		response = problemService.problemSymptomMapping();
		return response;
	}
}
