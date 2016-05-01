package com.apnavaidya.treasure.dto;

import java.io.Serializable;

public class ProblemSolutionDTO implements Serializable {

	private Long probId;

	private Long solId;

	private Long rating;

	private Long doseId;

	public Long getProbId() {
		return probId;
	}

	public void setProbId(Long probId) {
		this.probId = probId;
	}

	public Long getSolId() {
		return solId;
	}

	public void setSolId(Long solId) {
		this.solId = solId;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public Long getDoseId() {
		return doseId;
	}

	public void setDoseId(Long doseId) {
		this.doseId = doseId;
	}

}
