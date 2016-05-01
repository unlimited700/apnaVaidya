package com.apnavaidya.treasure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "problem_solution")
public class ProblemSolution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "prob_id", columnDefinition = "bigint(20) NOT NULL")
	private Long probId;

	@Column(name = "sol_id", columnDefinition = "bigint(20) NOT NULL")
	private Long solId;

	@Column(name = "rating", columnDefinition = "int(10) DEFAULT 0")
	private Long rating;

	@Column(name = "dose_id", columnDefinition = "bigint(20) NOT NULL")
	private Long doseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
