package net.ecoparadise.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.entity.general.TaxGroup;
import net.ecoparadise.exceptions.AppException;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.trade.TaxGroupRepository;
import net.ecoparadise.service.trade.TaxGroupService;

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
