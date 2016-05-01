package com.apnavaidya.treasure.dto;

import java.io.Serializable;

public class RecommendedSolutionDTO implements Serializable {

	private String solution;
	private String solType;
	private String step;
	private String duration;
	private Integer days;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getSolType() {
		return solType;
	}

	public void setSolType(String solType) {
		this.solType = solType;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "SolutionDTO [solution=" + solution + ", sol_type=" + solType + ", step=" + step + ", duration="
				+ duration + ", days=" + days + "]";
	}

	public RecommendedSolutionDTO(String solution, String sol_type, String step, String duration, Integer days) {
		super();
		this.solution = solution;
		this.solType = sol_type;
		this.step = step;
		this.duration = duration;
		this.days = days;
	}

	public RecommendedSolutionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
