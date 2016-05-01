package com.apnavaidya.treasure.dto;

import java.io.Serializable;

public class SolutionDTO implements Serializable {

	private String solution;
	private String solType;
	private String step;
	private String contradiction;

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

	public String getContradiction() {
		return contradiction;
	}

	public void setContradiction(String contradiction) {
		this.contradiction = contradiction;
	}

	@Override
	public String toString() {
		return "SolutionDTO [solution=" + solution + ", solType=" + solType + ", step=" + step + ", contradiction="
				+ contradiction + "]";
	}

}
