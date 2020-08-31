package net.ecoparadise.auth.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.auth.entity.Module;
import net.ecoparadise.auth.repository.ModuleRepository;
import net.ecoparadise.auth.service.ModuleService;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;


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
