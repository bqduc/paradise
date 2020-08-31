package net.ecoparadise.service.trade;

import java.util.Optional;

import net.ecoparadise.entity.Bank;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

public interface BankService extends GenericService<Bank, Long> {

	/**
	 * Get one Bank with the provided name.
	 * 
	 * @param name
	 *            The Bank name
	 * @return The Bank
	 * @throws ObjectNotFoundException
	 *             If no such Bank exists.
	 */
	Optional<Bank> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Bank with the provided code.
	 * 
	 * @param code
	 *            The Bank code
	 * @return The Bank
	 * @throws ObjectNotFoundException
	 *             If no such Bank exists.
	 */
	Optional<Bank> getByCode(String code) throws ObjectNotFoundException;
}
