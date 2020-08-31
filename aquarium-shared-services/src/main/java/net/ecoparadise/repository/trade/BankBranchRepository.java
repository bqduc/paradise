package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.BankBranch;
import net.ecoparadise.framework.repository.CodeNameRepository;

@Repository
public interface BankBranchRepository extends CodeNameRepository<BankBranch, Long>{
}
