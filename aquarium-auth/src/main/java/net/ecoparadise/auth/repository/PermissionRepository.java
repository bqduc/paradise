/**
 * 
 */
package net.ecoparadise.auth.repository;

import org.springframework.stereotype.Repository;

import net.ecoparadise.auth.entity.Permission;
import net.ecoparadise.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {
}
