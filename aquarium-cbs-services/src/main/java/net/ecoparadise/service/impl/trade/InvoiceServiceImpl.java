package net.ecoparadise.service.impl.trade;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.entity.Invoice;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.trade.InvoiceRepository;
import net.ecoparadise.service.trade.InvoiceService;

@Service
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice, Long> implements InvoiceService{
	private static final long serialVersionUID = -3091073932588099354L;
	
	@Inject 
	private InvoiceRepository repository;
	
	protected BaseRepository<Invoice, Long> getRepository() {
		return this.repository;
	}
}
