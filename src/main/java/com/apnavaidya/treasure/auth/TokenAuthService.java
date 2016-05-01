package com.apnavaidya.treasure.auth;

public interface TokenAuthService {

	public Boolean authenticateUserByToken(Long userId, String userToken);
}
