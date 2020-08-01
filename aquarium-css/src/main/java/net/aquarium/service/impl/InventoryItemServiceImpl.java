package net.aquarium.service.impl;

import javax.inject.Inject;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import net.aquarium.css.repository.stock.InventoryItemRepository;
import net.aquarium.css.service.stock.InventoryItemService;
import net.aquarium.css.specification.InventoryItemSpecification;
import net.aquarium.entity.stock.InventoryItem;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;


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
