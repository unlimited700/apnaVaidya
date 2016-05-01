package com.apnavaidya.treasure.v1.service;

import com.apnavaidya.treasure.dto.Response;
import com.apnavaidya.treasure.dto.SolutionRequest;

public interface SolutionService {

	public Response create(SolutionRequest solutionRequest);
}
