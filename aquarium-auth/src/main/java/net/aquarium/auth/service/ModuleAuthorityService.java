package net.aquarium.auth.service;

import java.util.List;

import net.aquarium.auth.entity.Authority;
import net.aquarium.auth.entity.Module;
import net.aquarium.auth.entity.ModuleAuthority;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.service.GenericService;

public interface ModuleAuthorityService extends GenericService<ModuleAuthority, Long> {

	/**
	 * Get one Module with the provided code.
	 * 
	 * @param module
	 *            The Module
	 * @param authority
	 *            The Authority
	 * @return The list
	 * @throws ObjectNotFoundException
	 *             If no such Module exists.
	 */
	List<ModuleAuthority> get(Module module, Authority authority) throws ObjectNotFoundException;
}
