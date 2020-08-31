package net.ecoparadise.service.trade;

import java.util.Optional;

import net.ecoparadise.entity.BankBranch;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

public interface BankBranchService extends GenericService<BankBranch, Long> {

	/**
	 * Get one Bank with the provided name.
	 * 
	 * @param name
	 *            The Bank Branch name
	 * @return The Bank Branch
	 * @throws ObjectNotFoundException
	 *             If no such Bank Branch exists.
	 */
	Optional<BankBranch> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Bank with the provided code.
	 * 
	 * @param code
	 *            The Bank Branch code
	 * @return The Bank Branch
	 * @throws ObjectNotFoundException
	 *             If no such Bank Branch exists.
	 */
	Optional<BankBranch> getByCode(String code) throws ObjectNotFoundException;
}
