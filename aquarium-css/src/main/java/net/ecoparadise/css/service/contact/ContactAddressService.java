package net.ecoparadise.css.service.contact;

import java.util.List;

import org.springframework.data.domain.Page;

import net.ecoparadise.entity.ContactAddress;
import net.ecoparadise.entity.contact.CTAContact;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.service.GenericService;

public interface ContactAddressService extends GenericService<ContactAddress, Long> {

	/**
	 * Get one Enterprise with the provided code.
	 * 
	 * @param code
	 *            The Enterprise code
	 * @return The Enterprise
	 * @throws ObjectNotFoundException
	 *             If no such Enterprise exists.
	 */
	List<ContactAddress> getByContact(CTAContact contact) throws ObjectNotFoundException;

	/**
	 * Get one Enterprises with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable Enterprises
	 */
	Page<ContactAddress> getObjects(SearchParameter searchParameter);
}
