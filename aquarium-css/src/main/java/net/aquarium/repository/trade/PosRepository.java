package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.Pos;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository
public interface PosRepository extends CodeNameRepository<Pos, Long>{
}
