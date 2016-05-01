package com.apnavaidya.treasure.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnavaidya.treasure.dto.RecommendationRequest;
import com.apnavaidya.treasure.dto.RecommendationResponse;
import com.apnavaidya.treasure.v1.service.RecommendationService;

@RestController
public class RecommendationController {

	private static final Logger LOG = LoggerFactory.getLogger(RecommendationController.class);

	@Autowired
	RecommendationService recommendationService;

	@RequestMapping(value = "/v1/recommend", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public RecommendationResponse recommend(@RequestHeader(value = "uid") Long userId ,@RequestBody RecommendationRequest recommendationRequest) {
		RecommendationResponse recommendationResponse = null;
		LOG.info("Request received to recommend with values {} ", new Object[] { recommendationRequest });
		try {
			recommendationResponse = recommendationService.recommend(recommendationRequest,userId);
		} catch (Exception e) {
			LOG.error(" Error while getting recommendation " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned to recommend with values {} ", new Object[] { recommendationResponse });
		return recommendationResponse;
	}

}
