package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.emx.CustomerInvoice;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface CustomerInvoiceRepository extends BaseRepository<CustomerInvoice, Long>{
}
