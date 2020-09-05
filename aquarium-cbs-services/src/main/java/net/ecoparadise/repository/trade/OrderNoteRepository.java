package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.OrderNote;
import net.ecoparadise.framework.repository.CodeRepository;

@Repository
public interface OrderNoteRepository extends CodeRepository<OrderNote, Long>{
}
