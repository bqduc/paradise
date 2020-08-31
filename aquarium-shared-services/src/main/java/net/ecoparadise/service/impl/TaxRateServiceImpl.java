package net.ecoparadise.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.entity.TaxRate;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.trade.TaxRateRepository;
import net.ecoparadise.service.trade.TaxRateService;

@Service
public class TaxRateServiceImpl extends GenericServiceImpl<TaxRate, Long> implements TaxRateService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5003151117371926438L;

	@Inject 
	private TaxRateRepository repository;
	
	protected BaseRepository<TaxRate, Long> getRepository() {
		return this.repository;
	}
}
