/**
 * 
 */
package net.aquarium.auth.repository;

import org.springframework.stereotype.Repository;

import net.aquarium.auth.entity.AccessRight;
import net.aquarium.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AccessRightRepository extends BaseRepository<AccessRight, Long> {
	AccessRight findByName(String name);
}
