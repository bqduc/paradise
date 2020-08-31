package net.ecoparadise.auth.service;

import net.ecoparadise.auth.entity.Module;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

public interface ModuleService extends GenericService<Module, Long> {

	/**
	 * Get one Module with the provided code.
	 * 
	 * @param name
	 *            The Module name
	 * @return The Module
	 * @throws ObjectNotFoundException
	 *             If no such Module exists.
	 */
	Module getByName(String name) throws ObjectNotFoundException;
}
