package com.apnavaidya.treasure.dto;

import java.util.List;

public class ProblemSolutionList {

	List<ProblemSolutionDose> problemSolutionDose;

	public List<ProblemSolutionDose> getProblemSolutionDose() {
		return problemSolutionDose;
	}

	public void setProblemSolutionDose(List<ProblemSolutionDose> problemSolutionDose) {
		this.problemSolutionDose = problemSolutionDose;
	}

	@Override
	public String toString() {
		return "ProblemSolutionList [problemSolutionDose=" + problemSolutionDose + "]";
	}

}
