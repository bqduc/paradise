package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Account;
import net.ecoparadise.framework.repository.CodeNameRepository;

@Repository
public interface AccountRepository extends CodeNameRepository<Account, Long>{
}
