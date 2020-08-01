package net.aquarium.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.aquarium.css.repository.general.CatalogueRepository;
import net.aquarium.css.specification.CatalogueSpecification;
import net.aquarium.domain.entity.general.Catalogue;
import net.aquarium.exceptions.AppException;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;
import net.aquarium.service.general.CatalogueService;

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
