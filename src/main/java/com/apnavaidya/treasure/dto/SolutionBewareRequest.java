package com.apnavaidya.treasure.dto;

import java.util.List;

public class SolutionBewareRequest extends Request {

	List<SolutionBewareDTO> solutionBewareList;

	public List<SolutionBewareDTO> getSolutionBewareList() {
		return solutionBewareList;
	}

	public void setSolutionBewareList(List<SolutionBewareDTO> solutionBewareList) {
		this.solutionBewareList = solutionBewareList;
	}

}
