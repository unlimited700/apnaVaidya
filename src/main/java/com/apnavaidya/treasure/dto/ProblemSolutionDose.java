package com.apnavaidya.treasure.dto;

import javax.persistence.Convert;

import org.springframework.beans.factory.annotation.Autowired;

public class ProblemSolutionDose {

	private String problem;
	private String solution;
	private Long rating;
	private Long doseId;

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Long getDoseId() {
		return doseId;
	}

	public void setDoseId(Long doseId) {
		this.doseId = doseId;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ProblemSolutionDose [problem=" + problem + ", solution=" + solution + ", rating=" + rating + ", doseId="
				+ doseId + "]";
	}

}
