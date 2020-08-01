package net.aquarium.auth.service;

import net.aquarium.auth.entity.Module;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.service.GenericService;

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
