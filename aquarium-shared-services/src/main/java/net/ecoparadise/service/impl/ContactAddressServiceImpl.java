package net.ecoparadise.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import net.ecoparadise.css.repository.contact.ContactAddressRepository;
import net.ecoparadise.css.service.contact.ContactAddressService;
import net.ecoparadise.css.specification.ContactAddressSpecification;
import net.ecoparadise.entity.Contact;
import net.ecoparadise.entity.ContactAddress;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;


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
	public List<ContactAddress> getByContact(Contact contact) throws ObjectNotFoundException {
		return repository.findByOwner(contact);
	}

	@Override
	public Page<ContactAddress> getObjects(SearchParameter searchParameter) {
		Page<ContactAddress> fetchedObjects = this.repository.findAll(ContactAddressSpecification.buildSpecification(searchParameter), searchParameter.getPageable());
		//Perform additional operations here
		return fetchedObjects;
	}
}
