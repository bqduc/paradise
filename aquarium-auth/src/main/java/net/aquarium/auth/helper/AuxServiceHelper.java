/**
 * 
 */
package net.aquarium.auth.helper;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import net.aquarium.auth.domain.UserSecurityProfile;
import net.aquarium.auth.entity.UserAccountProfile;
import net.aquarium.auth.service.UserAccountService;
import net.aquarium.common.CommonUtility;

/**
 * @author ducbq
 *
 */
@Component
public class AuxServiceHelper {
	@Inject 
	private UserAccountService userAuthenticationService;

	public UserSecurityProfile getUserAccountProfile(final String userAccountSsoId) {
		if (CommonUtility.isEmpty(userAccountSsoId))
			return null;

		UserAccountProfile userAccount = userAuthenticationService.get(userAccountSsoId);
		if (null==userAccount)
			return null;

		return UserSecurityProfile.builder()
				.userAccount(userAccount)
				.build();
	}
}
