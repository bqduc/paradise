package net.ecoparadise.service.general;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.ecoparadise.domain.entity.general.CatalogueItem;
import net.ecoparadise.domain.entity.general.CatalogueLanguage;
import net.ecoparadise.domain.entity.general.Language;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.repository.BaseRepository;
import net.ecoparadise.framework.service.GenericServiceImpl;
import net.ecoparadise.repository.CatalogueLanguageRepository;


@Service
public class CatalogueLanguageServiceImpl extends GenericServiceImpl<CatalogueLanguage, Long> implements CatalogueLanguageService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6204618256045562145L;

	@Inject 
	private CatalogueLanguageRepository repository;
	
	protected BaseRepository<CatalogueLanguage, Long> getRepository() {
		return this.repository;
	}

	@Override
	public List<CatalogueLanguage> getByLanguage(Language language) throws ObjectNotFoundException {
		return this.repository.findByLanguage(language);
	}

	@Override
	public CatalogueLanguage getByCatalogueAndLanguage(CatalogueItem catalogue, Language language) throws ObjectNotFoundException {
		return this.repository.findByCatalogueAndLanguage(catalogue, language);
	}
}