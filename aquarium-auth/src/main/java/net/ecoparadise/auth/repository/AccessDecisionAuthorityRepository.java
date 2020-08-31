/**
 * 
 */
package net.ecoparadise.auth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ecoparadise.auth.entity.AccessDecisionAuthority;
import net.ecoparadise.auth.entity.Authority;
import net.ecoparadise.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AccessDecisionAuthorityRepository extends BaseRepository<AccessDecisionAuthority, Long> {
	List<AccessDecisionAuthority> findByAuthority(Authority authority);

	boolean existsByAuthority(Authority authority);
}
