package com.apnavaidya.treasure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solution_beware")
public class SolutionBeware {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "prob_id", columnDefinition = "bigint(20) NOT NULL")
	private Long probId;

	@Column(name = "sol_id", columnDefinition = "bigint(20) NOT NULL")
	private Long solId;

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

}
