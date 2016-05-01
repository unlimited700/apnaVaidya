package com.apnavaidya.treasure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recommended_solution")
public class RecommendedSolution {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "solution", columnDefinition = "varchar(255) NOT NULL")
	private String solution;

	@Column(name = "sol_type", columnDefinition = "varchar(255) NOT NULL")
	private String solType;

	@Column(name = "step", columnDefinition = "mediumtext")
	private String step;

	@Column(name = "duration", columnDefinition = "varchar(20) DEFAULT NULL")
	private String duration;

	@Column(name = "days", columnDefinition = "int(10) DEFAULT '0'")
	private Long days;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

}
