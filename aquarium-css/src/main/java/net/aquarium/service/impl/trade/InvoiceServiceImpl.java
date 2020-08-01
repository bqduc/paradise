package net.aquarium.service.impl.trade;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.entity.trade.Invoice;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;
import net.aquarium.repository.trade.InvoiceRepository;
import net.aquarium.service.trade.InvoiceService;

@Service
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice, Long> implements InvoiceService{
	private static final long serialVersionUID = -3091073932588099354L;
	
	@Inject 
	private InvoiceRepository repository;
	
	protected BaseRepository<Invoice, Long> getRepository() {
		return this.repository;
	}
}
