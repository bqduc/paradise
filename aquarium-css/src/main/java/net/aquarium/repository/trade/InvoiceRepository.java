package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.Invoice;
import net.aquarium.framework.repository.CodeSerialRepository;

@Repository
public interface InvoiceRepository extends CodeSerialRepository<Invoice, Long>{
}
