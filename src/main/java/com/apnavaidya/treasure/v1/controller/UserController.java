package com.apnavaidya.treasure.v1.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnavaidya.treasure.accounts.dto.Response;
import com.apnavaidya.treasure.accounts.dto.UserLoginRequest;
import com.apnavaidya.treasure.accounts.dto.UserLoginResponse;
import com.apnavaidya.treasure.accounts.dto.UserSignUpRequest;
import com.apnavaidya.treasure.accounts.v1.service.UserService;

@RestController
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = "/v1/signup", produces = "application/json", consumes = "application/json")
	public Response signUp(@RequestBody UserSignUpRequest userSignUpRequest, HttpServletRequest httpReq) {
		Response response = null;
		String auth = httpReq.getHeader("authtoken");
		LOG.info("Request received to signup user with values {} , auth {} ", new Object[] { userSignUpRequest, auth });
		try {
			if (auth != null && auth.equals("apnavadiya!@#")) {
				response = userService.signUp(userSignUpRequest);
			}
		} catch (Exception e) {
			LOG.error(" Error while signing up user " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned to signup user with response {} ", new Object[] { response });
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/v1/login", produces = "application/json", consumes = "application/json")
	public UserLoginResponse login(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest httpReq) {
		UserLoginResponse response = null;
		String auth = httpReq.getHeader("authtoken");
		LOG.info("Request received to login user with values {} , auth {} ", new Object[] { userLoginRequest, auth });
		try {
			if (auth != null && auth.equals("apnavadiya!@#")) {
				response = userService.login(userLoginRequest);
			}
		} catch (Exception e) {
			LOG.error(" Error while login user " + e);
			e.printStackTrace();
		}
		LOG.info("Response returned to login user with response {} ", new Object[] { response });
		return response;
	}
}
