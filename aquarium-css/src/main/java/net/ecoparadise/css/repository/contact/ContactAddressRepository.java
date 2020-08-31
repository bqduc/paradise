package net.ecoparadise.css.repository.contact;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.ContactAddress;
import net.ecoparadise.entity.contact.CTAContact;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface ContactAddressRepository extends BaseRepository<ContactAddress, Long> {
	List<ContactAddress> findByOwner(CTAContact contact);
}
