package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.Bank;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository
public interface BankRepository extends CodeNameRepository<Bank, Long>{
}
