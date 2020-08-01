package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.OrderNote;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository
public interface OrderNoteRepository extends CodeNameRepository<OrderNote, Long>{
}
