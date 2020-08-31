/**
 * 
 */
package net.ecoparadise.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

/**
 * @author ducbq
 *
 */
public interface Identity {
	/**
	 * Checks that the current authenticated user has permission for the specified name and action
	 */
	boolean hasPermission(Object target, String action);

	/**
	 * Performs a permission check for the specified name and action 
	 */
	boolean hasPermission(String name, String action, Object... arg);

	/**
	 * Checks if the authenticated user is a member of the specified role.
	 */
	boolean hasRole(Object authentication, String role);

	boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
