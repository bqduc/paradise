package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.Tax;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository
public interface TaxRepository extends CodeNameRepository<Tax, Long>{
}
