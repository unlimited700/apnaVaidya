package com.apnavaidya.treasure.dto;

import java.io.Serializable;
import java.util.List;

public class SolutionsNameDTO extends Response implements Serializable {

	private List<String> solutions;

	public List<String> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<String> solutions) {
		this.solutions = solutions;
	}

}
