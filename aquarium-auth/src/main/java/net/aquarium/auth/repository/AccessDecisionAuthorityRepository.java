/**
 * 
 */
package net.aquarium.auth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.auth.entity.AccessDecisionAuthority;
import net.aquarium.auth.entity.Authority;
import net.aquarium.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AccessDecisionAuthorityRepository extends BaseRepository<AccessDecisionAuthority, Long> {
	List<AccessDecisionAuthority> findByAuthority(Authority authority);

	boolean existsByAuthority(Authority authority);
}
