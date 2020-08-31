package net.ecoparadise.auth.service;

import java.util.List;

import net.ecoparadise.auth.entity.AccessDecisionPolicy;
import net.ecoparadise.auth.entity.Authority;
import net.ecoparadise.framework.service.GenericService;

public interface AccessDecisionPolicyService extends GenericService<AccessDecisionPolicy, Long> {
	List<AccessDecisionPolicy> getAccessDecisionPolicies(String accessPattern);
	List<AccessDecisionPolicy> getAccessDecisionPoliciesByAuthority(Authority authority);
}
