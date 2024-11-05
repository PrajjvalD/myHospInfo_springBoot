package com.myhospinfos.oauth.config;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private final UserDetailsService userDetailsService;

	// store failed attempts per username
	private final ConcurrentHashMap<String, Integer> failedAttempts = new ConcurrentHashMap<>();
	private final ConcurrentHashMap<String, Long> lockoutTime = new ConcurrentHashMap<>();
	private static final int MAX_FAILED_ATTEMPTS = 5;
	private static final long LOCKOUT_DURATION = TimeUnit.MINUTES.toMillis(5); // 5 minutes lockout

	public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		HttpServletRequest request = null;

		// Check if the user is locked out
		if (isLockedOut(username)) {
			throw new BadCredentialsException("Account is locked due to too many failed attempts. Try again later.");
		}

		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			// Check the provided credentials
			if (!bc.matches(password, userDetails.getPassword())) {
				// handleFailedAttempt(username);
				throw new BadCredentialsException("Invalid username or password");
			}

			// Reset failed attempts on successful authentication
			resetFailedAttempts(username);

			return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
		} catch (Exception e) {
			handleFailedAttempt(username);
			throw new BadCredentialsException("Invalid username or password");
		}
	}

	private void handleFailedAttempt(String username) {
		failedAttempts.merge(username, 1, Integer::sum);

		if (failedAttempts.get(username) >= MAX_FAILED_ATTEMPTS) {
			lockoutTime.put(username, System.currentTimeMillis());
		}
	}

	private boolean isLockedOut(String username) {
		Long lockoutEndTime = lockoutTime.get(username);
		if (lockoutEndTime == null) {
			return false;
		}

		// If lockout time has passed, unlock the account
		if (System.currentTimeMillis() - lockoutEndTime > LOCKOUT_DURATION) {
			resetFailedAttempts(username);
			return false;
		}

		return true;
	}

	private void resetFailedAttempts(String username) {
		failedAttempts.remove(username);
		lockoutTime.remove(username);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}