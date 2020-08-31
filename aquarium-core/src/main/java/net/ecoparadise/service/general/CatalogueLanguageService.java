package net.ecoparadise.service.general;

import java.util.List;

import net.ecoparadise.domain.entity.general.CatalogueItem;
import net.ecoparadise.domain.entity.general.CatalogueLanguage;
import net.ecoparadise.domain.entity.general.Language;
import net.ecoparadise.exceptions.ObjectNotFoundException;
import net.ecoparadise.framework.service.GenericService;

public interface CatalogueLanguageService extends GenericService<CatalogueLanguage, Long> {
	List<CatalogueLanguage> getByLanguage(Language language) throws ObjectNotFoundException;
	CatalogueLanguage getByCatalogueAndLanguage(CatalogueItem catalogue, Language language) throws ObjectNotFoundException;
}
