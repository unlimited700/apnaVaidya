package com.apnavaidya.treasure.v1.service;

import com.apnavaidya.treasure.dto.ProblemSolutionList;
import com.apnavaidya.treasure.dto.Response;

public interface ProblemSolutionService {
	public Response create(ProblemSolutionList problemSolutionList);

	public Response problemSolutionMapping();
}
