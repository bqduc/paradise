/**
 * 
 */
package net.ecoparadise.auth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ecoparadise.auth.entity.UserAccountPrivilege;
import net.ecoparadise.auth.entity.UserAccountProfile;
import net.ecoparadise.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface UserAccountPrivilegeRepository extends BaseRepository<UserAccountPrivilege, Long> {
	List<UserAccountPrivilege> findByUserAccount(UserAccountProfile userAccount);
}
