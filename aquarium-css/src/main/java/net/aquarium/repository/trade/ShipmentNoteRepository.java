package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.ShipmentNote;
import net.aquarium.framework.repository.CodeSerialRepository;

@Repository
public interface ShipmentNoteRepository extends CodeSerialRepository<ShipmentNote, Long>{
}
