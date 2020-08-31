package net.ecoparadise.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ecoparadise.entity.Tax;
import net.ecoparadise.exceptions.AppException;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.trade.TaxRepository;
import net.ecoparadise.service.trade.TaxService;

@Service
public class TaxServiceImpl extends GenericServiceImpl<Tax, Long> implements TaxService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1827391253714417691L;

	@Inject 
	private TaxRepository repository;
	
	protected BaseRepository<Tax, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Tax> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	public Optional<Tax> getByCode(String code) throws ObjectNotFoundException {
		return repository.findByCode(code);
	}

	@Override
	protected Page<Tax> performSearch(String keyword, Pageable pageable) {
		return repository.find(keyword, pageable);
	}

	@Override
	protected Optional<Tax> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}
}
