package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.TaxRate;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface TaxRateRepository extends BaseRepository<TaxRate, Long>{
}
