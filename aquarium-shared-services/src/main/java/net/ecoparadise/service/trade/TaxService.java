package net.ecoparadise.service.trade;

import java.util.Optional;

import net.ecoparadise.entity.Tax;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

public interface TaxService extends GenericService<Tax, Long> {

	/**
	 * Get one Tax with the provided name.
	 * 
	 * @param name
	 *            The Tax name
	 * @return The Tax
	 * @throws ObjectNotFoundException
	 *             If no such Tax exists.
	 */
	Optional<Tax> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Tax with the provided code.
	 * 
	 * @param code
	 *            The Tax code
	 * @return The Tax
	 * @throws ObjectNotFoundException
	 *             If no such Tax exists.
	 */
	Optional<Tax> getByCode(String code) throws ObjectNotFoundException;
}
