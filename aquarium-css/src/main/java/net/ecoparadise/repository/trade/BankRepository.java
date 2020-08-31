package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Bank;
import net.ecoparadise.framework.repository.CodeNameRepository;

@Repository
public interface BankRepository extends CodeNameRepository<Bank, Long>{
}
