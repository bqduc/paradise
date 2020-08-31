package net.ecoparadise.auth.service;

import java.util.List;

import net.ecoparadise.auth.entity.Authority;
import net.ecoparadise.auth.entity.Module;
import net.ecoparadise.auth.entity.ModuleAuthority;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

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
