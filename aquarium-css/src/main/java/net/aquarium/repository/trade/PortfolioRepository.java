package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.Portfolio;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository
public interface PortfolioRepository extends CodeNameRepository<Portfolio, Long>{
}
