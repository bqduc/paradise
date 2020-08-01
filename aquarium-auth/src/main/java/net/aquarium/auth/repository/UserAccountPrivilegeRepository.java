/**
 * 
 */
package net.aquarium.auth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.auth.entity.UserAccountPrivilege;
import net.aquarium.auth.entity.UserAccountProfile;
import net.aquarium.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface UserAccountPrivilegeRepository extends BaseRepository<UserAccountPrivilege, Long> {
	List<UserAccountPrivilege> findByUserAccount(UserAccountProfile userAccount);
}
