/**
 * 
 */
package net.ecoparadise.security;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import net.ecoparadise.auth.entity.AccessDecisionPolicy;
import net.ecoparadise.auth.entity.Authority;
import net.ecoparadise.auth.model.AccessDecision;
import net.ecoparadise.auth.service.AccessDecisionPolicyService;
import net.ecoparadise.common.CommonConstants;
import net.ecoparadise.common.ListUtility;

/**
 * @author ducbq
 *
 */
@Component
public class CerberusIdentity implements Identity {
	@Inject
	private AccessDecisionPolicyService accessDecisionPolicyService;

	private UserDetails getCurrentUser() {
		UserDetails fetchedUserDetails = null;
		Authentication authentication = null;
		try {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication.getPrincipal() instanceof UserDetails) {
				fetchedUserDetails = (UserDetails)authentication.getPrincipal();
			} else {
					String username = authentication.getName();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return fetchedUserDetails;
	}

	/**
	 * Checks that the current authenticated user has permission for the specified name and action
	 * 
	 * @param target: The permission name
	 * @param action: The permission action
	 */
	@Override
	public boolean hasPermission(Object target, String action) {
		UserDetails  userDetails = getCurrentUser();
		System.out.println("Current user: " + userDetails);
		System.out.println("Tracking action: [" + action + "] has permission on target resource: [" + target + "]");
		return false;
	}

	/**
	 * Performs a permission check for the specified name and action 
	 * @param target: The permission name
	 * @param action: The permission action
	 * @param arg: Optional object parameter used to make a permission decision
	 */
	@Override
	public boolean hasPermission(String name, String action, Object... arg) {
		System.out.println("Tracking permission name: [" + name + "] has permission action [" + action + "] to make permission decision: [" + arg + "]");
		return false;
	}

	/**
	 * Checks if the authenticated user is a member of the specified role.
	 */
	@Override
	public boolean hasRole(Object authentication, String role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		if (authentication == null || CommonConstants.ANONYMOUS_USER.equals(authentication.getPrincipal())) {
			return false;
		}

		final String MY_ACCESSED_DECISION_POLICIES = "myAccessedDecisionPolicies";
		boolean hasAccessedPermission = false;
		List<AccessDecisionPolicy> accessDecisionPolicies = null;
		List<AccessDecisionPolicy> currentADPs = null; 
		PathMatcher pathMatcher = null;

		accessDecisionPolicies = (List<AccessDecisionPolicy>)request.getSession(false).getAttribute(MY_ACCESSED_DECISION_POLICIES);
    if (null==accessDecisionPolicies) {
    	accessDecisionPolicies = ListUtility.createDataList();
  		for (GrantedAuthority authority :authentication.getAuthorities()) {
  			currentADPs = accessDecisionPolicyService.getAccessDecisionPoliciesByAuthority((Authority)authority);
  			if (!currentADPs.isEmpty()) {
  	  		for (AccessDecisionPolicy accessDecisionPolicy :currentADPs) {
  	  			if (AccessDecision.ACCESS_GRANTED.equals(accessDecisionPolicy.getAccessDecision())) {
  	  				accessDecisionPolicies.add(accessDecisionPolicy);
  	  			}
  	  		}
  			}
  		}

  		request.getSession(false).setAttribute(MY_ACCESSED_DECISION_POLICIES, accessDecisionPolicies);
    }

		pathMatcher = new AntPathMatcher();
		for (AccessDecisionPolicy accessDecisionPolicy :accessDecisionPolicies) {
			if (pathMatcher.match(accessDecisionPolicy.getAccessPattern(), request.getRequestURI())) {
				hasAccessedPermission = true;
			}
		}
		return hasAccessedPermission;
	}

}
