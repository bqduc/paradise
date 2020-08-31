package net.ecoparadise.service.general;

import java.util.Optional;

import org.springframework.data.domain.Page;

import net.ecoparadise.domain.entity.general.CatalogueSubtype;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.service.GenericService;

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
