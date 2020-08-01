package net.aquarium.service.general;

import java.util.Optional;

import org.springframework.data.domain.Page;

import net.aquarium.domain.entity.general.CatalogueSubtype;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.service.GenericService;

public interface CatalogueSubtypeService extends GenericService<CatalogueSubtype, Long> {

	/**
	 * Get one Catalogue with the provided name.
	 * 
	 * @param code
	 *            The CatalogueSubtype name
	 * @return The CatalogueSubtype
	 * @throws ObjectNotFoundException
	 *             If no such Catalogue exists.
	 */
	Optional<CatalogueSubtype> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Catalogues with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable Catalogues
	 */
	Page<CatalogueSubtype> getObjects(SearchParameter searchParameter);

}
