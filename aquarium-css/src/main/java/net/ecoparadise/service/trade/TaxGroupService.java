package net.ecoparadise.service.trade;

import java.util.Optional;

import net.ecoparadise.entity.general.TaxGroup;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

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
