package com.apnavaidya.treasure.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnavaidya.treasure.accounts.v1.service.UserService;

@Service
public class TokenAuthServiceImpl implements TokenAuthService {

	@Autowired
	UserService userService;

	@Override
	public Boolean authenticateUserByToken(Long userId, String userToken) {

		if (userId == null || userToken == null) {
			return false;
		}
		String token = userService.getToken(userId);
		if (token == null || !token.equals(userToken)) {
			return false;
		}
		return true;
	}

}
