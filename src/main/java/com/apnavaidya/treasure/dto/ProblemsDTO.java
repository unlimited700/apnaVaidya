package com.apnavaidya.treasure.dto;

import java.util.List;

public class ProblemsDTO extends Response {

	List<String> problems;

	public List<String> getProblems() {
		return problems;
	}

	public void setProblems(List<String> problems) {
		this.problems = problems;
	}

	@Override
	public String toString() {
		return "ProblemsDTO [problems=" + problems + "]";
	}

}
