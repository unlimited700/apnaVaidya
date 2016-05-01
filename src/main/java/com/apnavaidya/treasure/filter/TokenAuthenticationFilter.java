package com.apnavaidya.treasure.filter;

import java.io.IOException;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.apnavaidya.treasure.auth.TokenAuthService;
import com.apnavaidya.treasure.constant.URLConstants;

public class TokenAuthenticationFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

	@Autowired
	TokenAuthService tokenAuthService;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isValid = false;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		LOG.info(" Filtered URL - {} " + new Object[] { httpRequest.getRequestURI().toString() });
		Long userId = httpRequest.getHeader("uid") != null ? Long.parseLong(httpRequest.getHeader("uid")) : -1;
		String authToken = httpRequest.getHeader("authtoken");

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		LOG.info("Filtered URL - {}", new Object[] { path });
		boolean isByPassURl = checkByPassUrl(path);

		if (isByPassURl) {
			isValid = true;
		} else {
			isValid = tokenAuthService.authenticateUserByToken(userId, authToken);
			LOG.info("Auth token validated - {}", new Object[] { isValid });
		}
		if (isValid) {
			chain.doFilter(httpRequest, httpResponse);
		} else {
			String accessDeniedUrl = "/auth/access-denied";
			RequestDispatcher rd = httpRequest.getServletContext().getRequestDispatcher(accessDeniedUrl);
			rd.forward(httpRequest, httpResponse);
		}
	}

	private boolean checkByPassUrl(String path) {
		for (String pattern : URLConstants.EXCLUDE_URL) {
			Pattern r = Pattern.compile(pattern);
			// Now create Matcher object
			Matcher m = r.matcher(path);
			if (m.find()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
