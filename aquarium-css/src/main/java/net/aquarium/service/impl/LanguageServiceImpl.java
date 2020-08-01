package net.aquarium.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.aquarium.css.repository.config.LanguageRepository;
import net.aquarium.css.service.config.LanguageService;
import net.aquarium.domain.entity.general.Language;
import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.framework.service.GenericServiceImpl;

@Service
public class LanguageServiceImpl extends GenericServiceImpl<Language, Long> implements LanguageService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7579757413128840936L;

	@Inject
	private LanguageRepository repository;

	@Override
	protected BaseRepository<Language, Long> getRepository() {
		return this.repository;
	}

	@Override
	protected Page<Language> performSearch(String keyword, Pageable pageable) {
		return this.repository.find(keyword, pageable);
	}

	@Override
	public Language getByName(String name) {
		return super.getOptional(this.repository.findByName(name));
	}
}
