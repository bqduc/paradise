package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.emx.CustomerInvoice;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface CustomerInvoiceRepository extends BaseRepository<CustomerInvoice, Long>{
}
