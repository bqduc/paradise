package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.TaxRate;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface TaxRateRepository extends BaseRepository<TaxRate, Long>{
}
