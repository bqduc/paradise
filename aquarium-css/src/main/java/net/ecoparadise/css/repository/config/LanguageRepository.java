package net.ecoparadise.css.repository.config;

import org.springframework.stereotype.Repository;

import net.ecoparadise.domain.entity.general.Language;
import net.ecoparadise.framework.repository.CodeNameRepository;

@Repository("languageRepository")
public interface LanguageRepository extends CodeNameRepository<Language, Long>{
}
