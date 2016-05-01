package com.apnavaidya.treasure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "problem_symptom")
public class ProblemSymptom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "prob_id", columnDefinition = "bigint(20) NOT NULL")
	private Long probId;

	@Column(name = "symp_id", columnDefinition = "bigint(20) NOT NULL")
	private Long sympId;

	public Long getProbId() {
		return probId;
	}

	public void setProbId(Long probId) {
		this.probId = probId;
	}

	public Long getSympId() {
		return sympId;
	}

	public void setSympId(Long sympId) {
		this.sympId = sympId;
	}

}
