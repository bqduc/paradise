package net.ecoparadise.css.repository.config;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.ecoparadise.domain.entity.general.Language;
import net.ecoparadise.entity.general.GeneralCatalogue;
import net.ecoparadise.entity.general.LocalizedItem;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface LocalizedItemRepository extends BaseRepository<LocalizedItem, Long>{

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " entity.item = :item and entity.language = :language"
			+ ")"
	)
	public LocalizedItem findByLocalizedItem(Language language, GeneralCatalogue item);
}
