package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.Account;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository
public interface AccountRepository extends CodeNameRepository<Account, Long>{
}
