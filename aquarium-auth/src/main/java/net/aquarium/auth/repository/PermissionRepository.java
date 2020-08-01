/**
 * 
 */
package net.aquarium.auth.repository;

import org.springframework.stereotype.Repository;

import net.aquarium.auth.entity.Permission;
import net.aquarium.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {
}
