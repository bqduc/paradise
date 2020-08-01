package net.aquarium.auth.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.auth.entity.Module;
import net.aquarium.auth.repository.ModuleRepository;
import net.aquarium.auth.service.ModuleService;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;


@Service
public class ModuleServiceImpl extends GenericServiceImpl<Module, Long> implements ModuleService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7409137083581193634L;

	@Inject 
	private ModuleRepository repository;
	
	protected BaseRepository<Module, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Module getByName(String name) throws ObjectNotFoundException {
		return (Module)super.getOptionalObject(repository.findByName(name));
	}
}
