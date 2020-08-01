package net.aquarium.css.repository.config;

import org.springframework.stereotype.Repository;

import net.aquarium.domain.entity.general.Language;
import net.aquarium.framework.repository.CodeNameRepository;

@Repository("languageRepository")
public interface LanguageRepository extends CodeNameRepository<Language, Long>{
}
