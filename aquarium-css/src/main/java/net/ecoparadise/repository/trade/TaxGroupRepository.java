package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.general.TaxGroup;
import net.ecoparadise.framework.repository.NameRepository;

@Repository
public interface TaxGroupRepository extends NameRepository<TaxGroup, Long>{
}
