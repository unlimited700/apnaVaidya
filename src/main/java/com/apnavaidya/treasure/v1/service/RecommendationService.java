package com.apnavaidya.treasure.v1.service;

import com.apnavaidya.treasure.dto.RecommendationRequest;
import com.apnavaidya.treasure.dto.RecommendationResponse;

public interface RecommendationService {

	public RecommendationResponse recommend(RecommendationRequest recommendationRequest, Long userId) throws Exception;
}
