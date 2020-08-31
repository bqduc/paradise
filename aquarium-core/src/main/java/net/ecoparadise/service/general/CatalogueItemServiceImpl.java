package net.ecoparadise.service.general;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.domain.entity.general.CatalogueItem;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.CatalogueItemRepository;


@Service
public class CatalogueItemServiceImpl extends GenericServiceImpl<CatalogueItem, Long> implements CatalogueItemService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4566594774661053895L;

	@Inject 
	private CatalogueItemRepository repository;
	
	protected BaseRepository<CatalogueItem, Long> getRepository() {
		return this.repository;
	}

	@Override
	public CatalogueItem getByName(String name) throws ObjectNotFoundException {
		return super.getOptional(this.repository.findByName(name));
	}
}
