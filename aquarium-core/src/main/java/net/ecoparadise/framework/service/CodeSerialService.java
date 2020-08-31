package net.ecoparadise.framework.service;

import java.io.Serializable;
import java.util.Optional;

import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.entity.EntityBase;

public interface CodeSerialService<T extends EntityBase, K extends Serializable> extends GenericService<T, K> {

	/**
	 * Get one business object with the provided serial.
	 * 
	 * @param serial
	 *            The business object's serial
	 * @return The business object
	 * @throws ObjectNotFoundException
	 *             If no such business object exists.
	 */
	Optional<T> getBySerial(String serial) throws ObjectNotFoundException;

	/**
	 * Get one business object with the provided code.
	 * 
	 * @param code
	 *            The business object's code
	 * @return The business object
	 * @throws ObjectNotFoundException
	 *             If no such business object exists.
	 */
	Optional<T> getByCode(String code) throws ObjectNotFoundException;
}
