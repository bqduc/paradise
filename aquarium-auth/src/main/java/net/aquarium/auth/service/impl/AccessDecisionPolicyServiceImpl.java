package net.aquarium.auth.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.auth.entity.AccessDecisionAuthority;
import net.aquarium.auth.entity.AccessDecisionPolicy;
import net.aquarium.auth.entity.Authority;
import net.aquarium.auth.repository.AccessDecisionAuthorityRepository;
import net.aquarium.auth.repository.AccessDecisionPolicyRepository;
import net.aquarium.auth.service.AccessDecisionPolicyService;
import net.aquarium.common.ListUtility;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;


@Service
public class AccessDecisionPolicyServiceImpl extends GenericServiceImpl<AccessDecisionPolicy, Long> implements AccessDecisionPolicyService {
	private static final long serialVersionUID = 7987317340813933975L;

	@Inject 
	private AccessDecisionPolicyRepository repository;

	@Inject
	private AccessDecisionAuthorityRepository accessDecisionAuthorityRepository;
	
	protected BaseRepository<AccessDecisionPolicy, Long> getRepository() {
		return this.repository;
	}

	@Override
	public List<AccessDecisionPolicy> getAccessDecisionPolicies(String accessPattern) {
		return this.repository.findByAccessPattern(accessPattern);
	}

	@Override
	public List<AccessDecisionPolicy> getAccessDecisionPoliciesByAuthority(Authority authority) {
		List<AccessDecisionPolicy> fetchedResults = ListUtility.createList();
		List<AccessDecisionAuthority> accessDecisionAuthorities = accessDecisionAuthorityRepository.findByAuthority(authority);
		for (AccessDecisionAuthority accessDecisionAuthority :accessDecisionAuthorities) {
			fetchedResults.add(accessDecisionAuthority.getAccessDecisionPolicy());
		}
		return fetchedResults;//this.repository.findByAuthority(authority);
	}
}
