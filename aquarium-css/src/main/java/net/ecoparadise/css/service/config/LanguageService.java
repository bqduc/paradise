package net.ecoparadise.css.service.config;

import java.util.Optional;

import net.ecoparadise.domain.entity.general.Language;
import net.ecoparadise.framework.service.GenericService;

public interface LanguageService extends GenericService<Language, Long>{
	Optional<Language> getByCode(String code);
	Language getByName(String name);
}
