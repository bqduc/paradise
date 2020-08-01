package net.aquarium.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.aquarium.css.repository.contact.ContactAddressRepository;
import net.aquarium.css.service.contact.ContactAddressService;
import net.aquarium.css.specification.ContactAddressSpecification;
import net.aquarium.entity.contact.CTAContact;
import net.aquarium.entity.contact.ContactAddress;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;


@Service
public class ContactAddressServiceImpl extends GenericServiceImpl<ContactAddress, Long> implements ContactAddressService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7761477574156308888L;

	@Inject 
	private ContactAddressRepository repository;
	
	protected BaseRepository<ContactAddress, Long> getRepository() {
		return this.repository;
	}

	@Override
	public List<ContactAddress> getByContact(CTAContact contact) throws ObjectNotFoundException {
		return repository.findByOwner(contact);
	}

	@Override
	public Page<ContactAddress> getObjects(SearchParameter searchParameter) {
		Page<ContactAddress> fetchedObjects = this.repository.findAll(ContactAddressSpecification.buildSpecification(searchParameter), searchParameter.getPageable());
		//Perform additional operations here
		return fetchedObjects;
	}
}
