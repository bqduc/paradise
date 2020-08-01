package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.general.TaxGroup;
import net.aquarium.framework.repository.NameRepository;

@Repository
public interface TaxGroupRepository extends NameRepository<TaxGroup, Long>{
}
