package net.aquarium.service.trade;

import java.util.Optional;

import net.aquarium.entity.general.TaxGroup;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.service.GenericService;

public interface TaxGroupService extends GenericService<TaxGroup, Long> {

	/**
	 * Get one TaxGroup with the provided name.
	 * 
	 * @param name
	 *            The TaxGroup name
	 * @return The TaxGroup
	 * @throws ObjectNotFoundException
	 *             If no such TaxGroup exists.
	 */
	Optional<TaxGroup> getByName(String name) throws ObjectNotFoundException;
}
