package net.ecoparadise.css.repository.contact;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Contact;
import net.ecoparadise.entity.ContactAddress;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface ContactAddressRepository extends BaseRepository<ContactAddress, Long> {
	List<ContactAddress> findByOwner(Contact contact);
}
