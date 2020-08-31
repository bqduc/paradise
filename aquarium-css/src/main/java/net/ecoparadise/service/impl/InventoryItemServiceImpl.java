package net.ecoparadise.service.impl;

import javax.inject.Inject;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import net.ecoparadise.css.repository.stock.InventoryItemRepository;
import net.ecoparadise.css.service.stock.InventoryItemService;
import net.ecoparadise.css.specification.InventoryItemSpecification;
import net.ecoparadise.entity.stock.InventoryItem;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;


@Service
public class InventoryItemServiceImpl extends GenericServiceImpl<InventoryItem, Long> implements InventoryItemService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7761477574156308888L;

	@Inject 
	private InventoryItemRepository repository;
	
	protected BaseRepository<InventoryItem, Long> getRepository() {
		return this.repository;
	}

	@Override
	public InventoryItem getByBarcode(String barcode) throws ObjectNotFoundException {
		return (InventoryItem)super.getOptionalObject(repository.findByBarcode(barcode));
	}

	@Override
	protected Specification<InventoryItem> getRepoSpecification(SearchParameter searchParameter) {
		return InventoryItemSpecification.buildSpecification(searchParameter);
	}
}
