package net.ecoparadise.service.impl.trade;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.entity.ShipmentNote;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.trade.ShipmentNoteRepository;
import net.ecoparadise.service.trade.ShipmentNoteService;

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
