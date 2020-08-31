package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Portfolio;
import net.ecoparadise.framework.repository.CodeNameRepository;

@Repository
public interface PortfolioRepository extends CodeNameRepository<Portfolio, Long>{
}
