package net.aquarium.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.aquarium.entity.trade.TaxRate;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;
import net.aquarium.repository.trade.TaxRateRepository;
import net.aquarium.service.trade.TaxRateService;

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
