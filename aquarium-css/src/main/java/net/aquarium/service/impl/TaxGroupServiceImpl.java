package net.aquarium.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.entity.general.TaxGroup;
import net.aquarium.exceptions.AppException;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;
import net.aquarium.repository.trade.TaxGroupRepository;
import net.aquarium.service.trade.TaxGroupService;

@Service
public class TaxGroupServiceImpl extends GenericServiceImpl<TaxGroup, Long> implements TaxGroupService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6265119761602842252L;
	@Inject 
	private TaxGroupRepository repository;
	
	protected BaseRepository<TaxGroup, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<TaxGroup> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	protected Optional<TaxGroup> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}
}
