package net.ecoparadise.service.trade;

import java.util.Optional;

import net.ecoparadise.entity.Portfolio;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

public interface PortfolioService extends GenericService<Portfolio, Long> {

	/**
	 * Get one Portfolio with the provided name.
	 * 
	 * @param name
	 *            The Portfolio name
	 * @return The Portfolio
	 * @throws ObjectNotFoundException
	 *             If no such Portfolio exists.
	 */
	Optional<Portfolio> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Portfolio with the provided code.
	 * 
	 * @param code
	 *            The Portfolio code
	 * @return The Portfolio
	 * @throws ObjectNotFoundException
	 *             If no such Portfolio exists.
	 */
	Optional<Portfolio> getByCode(String code) throws ObjectNotFoundException;
}
