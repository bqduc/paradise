package net.aquarium.service.general;

import java.util.Optional;

import net.aquarium.domain.entity.general.CatalogueItem;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.service.GenericService;

public interface CatalogueItemService extends GenericService<CatalogueItem, Long> {

	/**
	 * Get one Module with the provided code.
	 * 
	 * @param code
	 *            The CatalogueItem's code
	 * @return The CatalogueItem
	 * @throws ObjectNotFoundException
	 *             If no such CatalogueItem exists.
	 */
	Optional<CatalogueItem> getByCode(String code) throws ObjectNotFoundException;

	/**
	 * Get one Module with the provided code.
	 * 
	 * @param name
	 *            The CatalogueItem's name
	 * @return The CatalogueItem
	 * @throws ObjectNotFoundException
	 *             If no such CatalogueItem exists.
	 */
	CatalogueItem getByName(String name) throws ObjectNotFoundException;
}
