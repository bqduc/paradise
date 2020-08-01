package net.aquarium.css.repository.contact;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.contact.CTAContact;
import net.aquarium.entity.contact.ContactAddress;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface ContactAddressRepository extends BaseRepository<ContactAddress, Long> {
	List<ContactAddress> findByOwner(CTAContact contact);
}
