package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Payment;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface PaymentRepository extends BaseRepository<Payment, Long>{
}
