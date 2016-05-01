package com.apnavaidya.treasure.dto;

import java.util.List;

public class SolutionRequest extends Request {

	List<SolutionDTO> solutions;

	public List<SolutionDTO> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<SolutionDTO> solutions) {
		this.solutions = solutions;
	}

	@Override
	public String toString() {
		return "SolutionRequest [solutions=" + solutions + "]";
	}

}
