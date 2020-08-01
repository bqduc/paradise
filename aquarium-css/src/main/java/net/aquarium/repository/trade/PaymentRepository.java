package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.Payment;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface PaymentRepository extends BaseRepository<Payment, Long>{
}
