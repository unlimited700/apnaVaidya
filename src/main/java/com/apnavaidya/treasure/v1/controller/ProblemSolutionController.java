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

import com.apnavaidya.treasure.dto.ProblemSolutionList;
import com.apnavaidya.treasure.dto.Response;
import com.apnavaidya.treasure.v1.service.ProblemSolutionService;

@RestController
public class ProblemSolutionController {

	@Autowired
	private ProblemSolutionService problemSolutionService;

	private static final Logger LOG = LoggerFactory.getLogger(ProblemSolutionController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/v1/upload-problem-solution", produces = "application/json", consumes = "application/json")
	public Response create(@RequestBody ProblemSolutionList problemSolutionList, HttpServletRequest httpReq) {
		Response response = null;
		String auth = httpReq.getHeader("auth");
		LOG.info("Request received to creating problemSolutionList with values {} ",
				new Object[] { problemSolutionList });
		try {
			if (null != auth && auth.equals("apnavadiya!@#")) {
				response = problemSolutionService.create(problemSolutionList);
			}
		} catch (Exception e) {
			LOG.error(" Error while creating problemSolutionList " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned to create problemSolutionList with response {} ", new Object[] { response });
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/v1/problem-solution-mapping", produces = "application/json", consumes = "application/json")
	public Response problemSolutionMapping() {
		Response response = null;
		response = problemSolutionService.problemSolutionMapping();
		return response;
	}

}
