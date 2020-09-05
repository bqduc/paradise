package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.ShipmentNote;
import net.ecoparadise.framework.repository.CodeSerialRepository;

@Repository
public interface ShipmentNoteRepository extends CodeSerialRepository<ShipmentNote, Long>{
}
