package net.aquarium.auth.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.auth.entity.Authority;
import net.aquarium.auth.entity.Module;
import net.aquarium.auth.entity.ModuleAuthority;
import net.aquarium.auth.repository.ModuleAuthorityRepository;
import net.aquarium.auth.service.ModuleAuthorityService;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;


@Service
public class ModuleAuthorityServiceImpl extends GenericServiceImpl<ModuleAuthority, Long> implements ModuleAuthorityService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3269698913225344087L;

	@Override
	public List<ModuleAuthority> get(Module module, Authority authority) throws ObjectNotFoundException {
		return this.repository.findByModuleAndAuthority(module, authority);
	}

	@Inject 
	private ModuleAuthorityRepository repository;
	
	protected BaseRepository<ModuleAuthority, Long> getRepository() {
		return this.repository;
	}
}
