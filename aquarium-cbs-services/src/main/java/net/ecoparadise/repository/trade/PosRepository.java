package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Pos;
import net.ecoparadise.framework.repository.CodeNameRepository;

@Repository
public interface PosRepository extends CodeNameRepository<Pos, Long>{
}
