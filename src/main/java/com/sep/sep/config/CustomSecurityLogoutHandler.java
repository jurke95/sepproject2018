package com.sep.sep.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;

public class CustomSecurityLogoutHandler  {
	
	protected final Log logger = LogFactory.getLog(this.getClass());

	private boolean invalidateHttpSession = true;
	private boolean clearAuthentication = true;

	public String  logout(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		Assert.notNull(request, "HttpServletRequest required");
		if (invalidateHttpSession) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				logger.debug("Invalidating session: " + session.getId());
				session.invalidate();
			}
		}

		if (clearAuthentication) {
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(null);
		}

		SecurityContextHolder.clearContext();
		return "ok";
	}

	public boolean isInvalidateHttpSession() {
		return invalidateHttpSession;
	}

	/**
	 * Causes the {@link HttpSession} to be invalidated when this {@link LogoutHandler} is
	 * invoked. Defaults to true.
	 *
	 * @param invalidateHttpSession true if you wish the session to be invalidated
	 * (default) or false if it should not be.
	 */
	public void setInvalidateHttpSession(boolean invalidateHttpSession) {
		this.invalidateHttpSession = invalidateHttpSession;
	}

	/**
	 * If true, removes the {@link Authentication} from the {@link SecurityContext} to
	 * prevent issues with concurrent requests.
	 *
	 * @param clearAuthentication true if you wish to clear the {@link Authentication}
	 * from the {@link SecurityContext} (default) or false if the {@link Authentication}
	 * should not be removed.
	 */
	public void setClearAuthentication(boolean clearAuthentication) {
		this.clearAuthentication = clearAuthentication;
	}

}
