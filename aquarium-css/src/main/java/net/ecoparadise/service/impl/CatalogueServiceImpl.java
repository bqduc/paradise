package net.ecoparadise.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ecoparadise.css.repository.general.CatalogueRepository;
import net.ecoparadise.css.specification.CatalogueSpecification;
import net.ecoparadise.domain.entity.general.Catalogue;
import net.ecoparadise.exceptions.AppException;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.service.general.CatalogueService;

@Service
public class CatalogueServiceImpl extends GenericServiceImpl<Catalogue, Long> implements CatalogueService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435351574637430464L;
	@Inject 
	private CatalogueRepository repository;
	
	protected BaseRepository<Catalogue, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Catalogue> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	public Optional<Catalogue> getByCode(String code) throws ObjectNotFoundException {
		return repository.findByCode(code);
	}

	@Override
	protected Page<Catalogue> performSearch(String keyword, Pageable pageable) {
		return repository.search(keyword, pageable);
	}

	@Override
	public Page<Catalogue> getObjects(SearchParameter searchParameter) {
		return this.repository.findAll(CatalogueSpecification.buildSpecification(searchParameter), searchParameter.getPageable());
	}

	@Override
	protected Optional<Catalogue> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}
}
