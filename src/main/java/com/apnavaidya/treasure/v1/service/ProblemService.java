package com.apnavaidya.treasure.v1.service;

import com.apnavaidya.treasure.dto.ProblemRequest;
import com.apnavaidya.treasure.dto.ProblemsDTO;
import com.apnavaidya.treasure.dto.Response;

public interface ProblemService {

	public Response create(ProblemRequest problemRequest);

	public ProblemsDTO getProblems();

	public Response problemSymptomMapping();
}
