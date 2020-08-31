/**
 * 
 */
package net.ecoparadise.auth.repository;

import org.springframework.stereotype.Repository;

import net.ecoparadise.auth.entity.AccessRight;
import net.ecoparadise.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AccessRightRepository extends BaseRepository<AccessRight, Long> {
	AccessRight findByName(String name);
}
