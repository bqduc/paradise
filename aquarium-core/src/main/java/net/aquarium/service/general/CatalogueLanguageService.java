package net.aquarium.service.general;

import java.util.List;

import net.aquarium.domain.entity.general.CatalogueItem;
import net.aquarium.domain.entity.general.CatalogueLanguage;
import net.aquarium.domain.entity.general.Language;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.service.GenericService;

public interface CatalogueLanguageService extends GenericService<CatalogueLanguage, Long> {
	List<CatalogueLanguage> getByLanguage(Language language) throws ObjectNotFoundException;
	CatalogueLanguage getByCatalogueAndLanguage(CatalogueItem catalogue, Language language) throws ObjectNotFoundException;
}
