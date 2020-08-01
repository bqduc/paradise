package net.aquarium.css.service.config;

import java.util.Optional;

import net.aquarium.domain.entity.general.Language;
import net.aquarium.framework.service.GenericService;

public interface LanguageService extends GenericService<Language, Long>{
	Optional<Language> getByCode(String code);
	Language getByName(String name);
}
