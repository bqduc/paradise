package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.BankBranch;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository
public interface BankBranchRepository extends CodeNameRepository<BankBranch, Long>{
}
