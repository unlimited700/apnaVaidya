package com.apnavaidya.treasure.constant;

public class ErrorConstants {

	/**
	 * Accounts 5XX code initilization
	 */
	public static final ErrorCodes INTERNAL_SERVER_ERROR = new ErrorCodes(500, "Internal Server Error");
	public static final ErrorCodes USERNAME_EMPTY = new ErrorCodes(510, "Username can't be empty");
	public static final ErrorCodes USERNAME_INVALID = new ErrorCodes(510, "Entred username is not valid");
	public static final ErrorCodes USERNAME_ALREADY_EXIST = new ErrorCodes(510,
			"Sorry, that username is already exists!");
	public static final ErrorCodes USER_ALREADY_BAN = new ErrorCodes(520, "User is already Banned");

	public static final ErrorCodes CANNT_BAN_UNVERIFIED_USER = new ErrorCodes(520, "We can not ban Unverified User");
	public static final ErrorCodes USER_WITH_UNKNOWN_STATUS = new ErrorCodes(520, "User status is not known!");
	public static final ErrorCodes USER_ALREADY_VERIFIED = new ErrorCodes(520, "User is already Verified");

	public static final ErrorCodes DEVICE_NOT_VALID = new ErrorCodes(401, "Device not Valid");
	public static final ErrorCodes USER_BANNED = new ErrorCodes(403, "User is banned");
	public static final ErrorCodes NOT_FOUND = new ErrorCodes(404, "NOT FOUND");
	public static final ErrorCodes RETRY_ATTEMPT_EXCEEDED = new ErrorCodes(510,
			"Retry attempt to create username reached to threashold");
	public static final ErrorCodes GENERATED_EMPTY_USERNAME = new ErrorCodes(510, "Could not create username");
	public static final ErrorCodes UNAUTHORIZED_USER = new ErrorCodes(403,
			"Forbidden!, User is not authorized to perform this action");

	// Need to change error code of opt
	public static final ErrorCodes OTP_ERROR = new ErrorCodes(575, "Internal Server Error");
	public static final ErrorCodes OTP_DOESNT_MATCH = new ErrorCodes(575,
			"Otp & mobile number combination does not exist!");

	public static final ErrorCodes INVALID_REQUEST = new ErrorCodes(400, "BAD REQUEST/ INVALID REQUEST PARAMETERS");
	public static final ErrorCodes INVALID_ACCESSTOKEN = new ErrorCodes(451, "Access token is not valid");
	public static final ErrorCodes ALREADY_INACTIVE = new ErrorCodes(452, "User already Inactive");
	public static final ErrorCodes EMAIL_FACEBOOKID_NOT_FOUND = new ErrorCodes(512, "Email or FacebookId not found");

	public static final ErrorCodes FOLLOW_SELF = new ErrorCodes(400, "User cannot follow itself");
	public static final ErrorCodes ALREADY_ACTIVE = new ErrorCodes(453,
			"Your Facebook account is already linked to an existing Shopo account");
	public static final ErrorCodes INACTIVE_FACEBOOK_USER = new ErrorCodes(454, "User is not active on facebook");
	public static final ErrorCodes FB_MORE_SHOPO_ACNT = new ErrorCodes(455,
			"One Facebook account can not linked to more than one Shopo account");

	// 560, "Device not valid"
}
