package com.apnavaidya.treasure.dto;

import java.util.List;

public class ProblemSolutionRequest extends Request {

	List<ProblemSolutionDTO> problemSolutionList;

	public List<ProblemSolutionDTO> getProblemSolutionList() {
		return problemSolutionList;
	}

	public void setProblemSolutionList(List<ProblemSolutionDTO> problemSolutionList) {
		this.problemSolutionList = problemSolutionList;
	}

}
