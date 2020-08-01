package net.aquarium.css.service.contact;

import java.util.List;

import org.springframework.data.domain.Page;

import net.aquarium.entity.contact.CTAContact;
import net.aquarium.entity.contact.ContactAddress;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.service.GenericService;

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
