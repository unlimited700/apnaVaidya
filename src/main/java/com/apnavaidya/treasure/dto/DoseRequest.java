package com.apnavaidya.treasure.dto;

import java.util.List;

public class DoseRequest extends Request {

	List<DoseDTO> doses;

	public List<DoseDTO> getDoses() {
		return doses;
	}

	public void setDoses(List<DoseDTO> doses) {
		this.doses = doses;
	}

}
