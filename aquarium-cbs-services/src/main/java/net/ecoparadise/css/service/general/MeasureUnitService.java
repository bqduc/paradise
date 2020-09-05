package net.ecoparadise.css.service.general;

import java.util.Optional;

import org.springframework.data.domain.Page;

import net.ecoparadise.entity.Unit;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.service.GenericService;

public interface MeasureUnitService extends GenericService<Unit, Long> {

	/**
	 * Get one Unit with the provided name.
	 * 
	 * @param code
	 *            The Unit name
	 * @return The Unit
	 * @throws ObjectNotFoundException
	 *             If no such Unit exists.
	 */
	Optional<Unit> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Unit with the provided name locale.
	 * 
	 * @param nameLocal
	 *            The Unit name local
	 * @return The Unit
	 * @throws ObjectNotFoundException
	 *             If no such Unit exists.
	 */
	Optional<Unit> getByNameLocale(String nameLocal) throws ObjectNotFoundException;

	/**
	 * Get one Measure units with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable Measure units
	 */
	Page<Unit> getObjects(SearchParameter searchParameter);

}
