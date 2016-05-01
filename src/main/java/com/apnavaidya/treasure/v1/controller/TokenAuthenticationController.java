package com.apnavaidya.treasure.v1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnavaidya.treasure.dto.Response;

@RestController
public class TokenAuthenticationController {

	@RequestMapping(method = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.HEAD, RequestMethod.OPTIONS,
			RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.TRACE }, value = "/auth/access-denied", produces = "application/json", consumes = "application/json")
	public Response accessDenied(HttpServletResponse httpResponse, HttpServletRequest httpReq) {
		Response response = new Response();
		response.setMessage("Not Authorized");
		response.setResponseCode(520);
		return response;
	}
}
