package com.apnavaidya.treasure.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solution")
public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "solution", columnDefinition = "varchar(255) NOT NULL")
	@Convert(converter = DescriptionConvertor.class)
	private String solution;

	@Column(name = "sol_type", columnDefinition = "varchar(255) NOT NULL")
	@Convert(converter = DescriptionConvertor.class)
	private String solType;

	@Column(name = "step", columnDefinition = "mediumtext")
	@Convert(converter = DescriptionConvertor.class)
	private String step;

	@Column(name = "contradiction", columnDefinition = "mediumtext")
	@Convert(converter = DescriptionConvertor.class)
	private String contradiction;

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

	public String getContradiction() {
		return contradiction;
	}

	public void setContradiction(String contradiction) {
		this.contradiction = contradiction;
	}

}
