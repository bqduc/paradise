package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Tax;
import net.ecoparadise.framework.repository.CodeNameRepository;

@Repository
public interface TaxRepository extends CodeNameRepository<Tax, Long>{
}
