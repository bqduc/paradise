package net.aquarium.auth.service;

import java.util.List;

import net.aquarium.auth.entity.AccessDecisionPolicy;
import net.aquarium.auth.entity.Authority;
import net.aquarium.framework.service.GenericService;

public interface AccessDecisionPolicyService extends GenericService<AccessDecisionPolicy, Long> {
	List<AccessDecisionPolicy> getAccessDecisionPolicies(String accessPattern);
	List<AccessDecisionPolicy> getAccessDecisionPoliciesByAuthority(Authority authority);
}
