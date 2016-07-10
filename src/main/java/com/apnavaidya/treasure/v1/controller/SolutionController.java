package com.apnavaidya.treasure.v1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnavaidya.treasure.dto.ProblemsDTO;
import com.apnavaidya.treasure.dto.Response;
import com.apnavaidya.treasure.dto.SolutionRequest;
import com.apnavaidya.treasure.dto.SolutionsNameDTO;
import com.apnavaidya.treasure.v1.service.SolutionService;

@RestController
public class SolutionController {

	private static final Logger LOG = LoggerFactory.getLogger(SolutionController.class);

	@Autowired
	private SolutionService solutionService;

	@RequestMapping(method = RequestMethod.POST, value = "/v1/solution", produces = "application/json", consumes = "application/json")
	public Response create(@RequestBody SolutionRequest solutionRequest, HttpServletRequest httpReq) {
		Response response = null;
		String auth = httpReq.getHeader("auth");
		LOG.info("Request received to creating solution with values {} , auth {} ",
				new Object[] { solutionRequest, auth });
		try {
			if (auth != null && auth.equals("apnavadiya!@#")) {
				response = solutionService.create(solutionRequest);
			}
		} catch (Exception e) {
			LOG.error(" Error while creating solutions " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned to create solution with response {} ", new Object[] { response });
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/v1/solutions", produces = "application/json", consumes = "application/json")
	public SolutionsNameDTO getProblems() {
		SolutionsNameDTO response = null;
		LOG.info("Request received of fetching list of solutions");
		try {
			response = solutionService.getSolutions();
		} catch (Exception e) {
			LOG.error(" Error while fetching solutions " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned of fetching list of solutions {} ", new Object[] { response });
		return response;
	}

}
