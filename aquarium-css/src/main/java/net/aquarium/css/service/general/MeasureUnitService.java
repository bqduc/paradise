package net.aquarium.css.service.general;

import java.util.Optional;

import org.springframework.data.domain.Page;

import net.aquarium.entity.general.MeasureUnit;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.service.GenericService;

public interface MeasureUnitService extends GenericService<MeasureUnit, Long> {

	/**
	 * Get one MeasureUnit with the provided name.
	 * 
	 * @param code
	 *            The MeasureUnit name
	 * @return The MeasureUnit
	 * @throws ObjectNotFoundException
	 *             If no such MeasureUnit exists.
	 */
	Optional<MeasureUnit> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one MeasureUnit with the provided name locale.
	 * 
	 * @param nameLocal
	 *            The MeasureUnit name local
	 * @return The MeasureUnit
	 * @throws ObjectNotFoundException
	 *             If no such MeasureUnit exists.
	 */
	Optional<MeasureUnit> getByNameLocale(String nameLocal) throws ObjectNotFoundException;

	/**
	 * Get one Measure units with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable Measure units
	 */
	Page<MeasureUnit> getObjects(SearchParameter searchParameter);

}
