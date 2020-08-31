package net.ecoparadise.auth.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.auth.entity.Authority;
import net.ecoparadise.auth.entity.Module;
import net.ecoparadise.auth.entity.ModuleAuthority;
import net.ecoparadise.auth.repository.ModuleAuthorityRepository;
import net.ecoparadise.auth.service.ModuleAuthorityService;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;


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
