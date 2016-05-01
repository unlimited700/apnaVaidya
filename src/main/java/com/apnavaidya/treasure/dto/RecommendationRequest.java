package com.apnavaidya.treasure.dto;

import java.util.List;

public class RecommendationRequest extends Request {

	List<String> problems;
	Boolean diagnose;

	public List<String> getProblems() {
		return problems;
	}

	public void setProblems(List<String> problems) {
		this.problems = problems;
	}

	public Boolean getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(Boolean diagnose) {
		this.diagnose = diagnose;
	}

}
