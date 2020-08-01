package net.aquarium.service.impl.trade;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.entity.trade.ShipmentNote;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;
import net.aquarium.repository.trade.ShipmentNoteRepository;
import net.aquarium.service.trade.ShipmentNoteService;

@Service
public class ShipmentNoteServiceImpl extends GenericServiceImpl<ShipmentNote, Long> implements ShipmentNoteService{
	private static final long serialVersionUID = -4524060954777123091L;

	@Inject 
	private ShipmentNoteRepository repository;
	
	protected BaseRepository<ShipmentNote, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<ShipmentNote> getBySerial(String serial) throws ObjectNotFoundException {
		return repository.findBySerial(serial);
	}

	@Override
	public Optional<ShipmentNote> getByCode(String code) throws ObjectNotFoundException {
		return repository.findByCode(code);
	}
}
