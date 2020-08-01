/**
 * 
 */
package net.aquarium.auth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.auth.entity.AccessDecisionPolicy;
import net.aquarium.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AccessDecisionPolicyRepository extends BaseRepository<AccessDecisionPolicy, Long> {
	List<AccessDecisionPolicy> findByAccessPattern(String accessPattern);
	//List<AccessDecisionPolicy> findByAuthority(Authority authority);
	
	boolean existsByAccessPattern(String accessPattern);
}
