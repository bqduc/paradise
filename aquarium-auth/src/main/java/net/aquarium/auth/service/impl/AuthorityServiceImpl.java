package net.aquarium.auth.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.auth.constants.AuxGlobalConstants;
import net.aquarium.auth.entity.Authority;
import net.aquarium.auth.repository.AuthorityRepository;
import net.aquarium.auth.service.AuthorityService;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;


@Service
public class AuthorityServiceImpl extends GenericServiceImpl<Authority, Long> implements AuthorityService{
	private static final long serialVersionUID = 7761477574156308888L;

	@Inject 
	private AuthorityRepository repository;
	
	protected BaseRepository<Authority, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Authority getByName(String name) throws ObjectNotFoundException {
		Optional<Authority> opt = repository.findByName(name);
		return (Authority)super.getOptionalObject(repository.findByName(name));
	}

	@Override
	public Authority getMinimumUserAuthority() throws ObjectNotFoundException {
		Authority fetchedResult = null;
		Optional<Authority> optAuthority = this.repository.findByName(AuxGlobalConstants.MINIMUM_USER_AUTHORITY);
		if (!optAuthority.isPresent()) {
			fetchedResult = Authority.builder().name(AuxGlobalConstants.MINIMUM_USER_AUTHORITY).displayName("Default minimum authority").build();
			this.repository.save(fetchedResult);
		} else {
			fetchedResult = optAuthority.get();
		}
		return fetchedResult;
	}
}
