/**
 * 
 */
package net.aquarium.auth.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import net.aquarium.auth.domain.UserSecurityProfile;
import net.aquarium.auth.entity.AccessDecisionPolicy;
import net.aquarium.auth.entity.UserAccountProfile;
import net.aquarium.exceptions.NgepAuthException;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.entity.auth.AuthenticationDetails;
import net.aquarium.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
public interface AuthorizationService {
	UserSecurityProfile authenticate(String ssoId, String password) throws NgepAuthException;
	UserSecurityProfile authenticate(String token) throws NgepAuthException;

	UserSecurityProfile getActiveSecuredProfile() throws NgepAuthException;
	
	boolean hasPermission(String target, String action) throws NgepAuthException;

	UserAccountProfile saveSecurityAccountProfile(UserAccountProfile securityAccountProfile) throws NgepAuthException;

	UserSecurityProfile register(ExecutionContext context) throws NgepAuthException;

	UserAccountProfile getUserAccount(String ssoId)  throws ObjectNotFoundException;

	UserSecurityProfile confirmByToken(String token)  throws ObjectNotFoundException;

	List<AccessDecisionPolicy> getAccessDecisionPolicies(String accessPattern) throws ObjectNotFoundException;

	List<AccessDecisionPolicy> getAccessDecisionPolicies(AuthenticationDetails authenticationDetails) throws ObjectNotFoundException;

	boolean hasAccessDecisionPolicy(FilterInvocation filterInvocation, Authentication authentication);
}
