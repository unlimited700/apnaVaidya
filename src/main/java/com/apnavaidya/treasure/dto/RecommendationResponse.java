package com.apnavaidya.treasure.dto;

import java.util.List;

public class RecommendationResponse extends Response {

	private List<RecommendedSolutionDTO> recommendedYoga;

	private List<RecommendedSolutionDTO> recommendedFood;

	private List<RecommendedSolutionDTO> recommendedRemedies;

	private List<String> recommendedDoctors;

	private List<String> diagnosedSymptoms;

	public List<RecommendedSolutionDTO> getRecommendedYoga() {
		return recommendedYoga;
	}

	public void setRecommendedYoga(List<RecommendedSolutionDTO> recommendedYoga) {
		this.recommendedYoga = recommendedYoga;
	}

	public List<RecommendedSolutionDTO> getRecommendedFood() {
		return recommendedFood;
	}

	public void setRecommendedFood(List<RecommendedSolutionDTO> recommendedFood) {
		this.recommendedFood = recommendedFood;
	}

	public List<RecommendedSolutionDTO> getRecommendedRemedies() {
		return recommendedRemedies;
	}

	public void setRecommendedRemedies(List<RecommendedSolutionDTO> recommendedRemedies) {
		this.recommendedRemedies = recommendedRemedies;
	}

	public List<String> getRecommendedDoctors() {
		return recommendedDoctors;
	}

	public void setRecommendedDoctors(List<String> recommendedDoctors) {
		this.recommendedDoctors = recommendedDoctors;
	}

	public List<String> getDiagnosedSymptoms() {
		return diagnosedSymptoms;
	}

	public void setDiagnosedSymptoms(List<String> diagnosedSymptoms) {
		this.diagnosedSymptoms = diagnosedSymptoms;
	}

}
