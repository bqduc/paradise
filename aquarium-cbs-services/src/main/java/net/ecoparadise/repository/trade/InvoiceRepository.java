package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Invoice;
import net.ecoparadise.framework.repository.CodeSerialRepository;

@Repository
public interface InvoiceRepository extends CodeSerialRepository<Invoice, Long>{
}
