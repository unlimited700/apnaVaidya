package com.apnavaidya.treasure.dto;

import java.util.List;

public class ProblemRequest extends Request {

	private List<ProblemDTO> problems;

	public List<ProblemDTO> getProblems() {
		return problems;
	}

	public void setProblems(List<ProblemDTO> problems) {
		this.problems = problems;
	}

	@Override
	public String toString() {
		return "ProblemRequest [problems=" + problems + "]";
	}

}
