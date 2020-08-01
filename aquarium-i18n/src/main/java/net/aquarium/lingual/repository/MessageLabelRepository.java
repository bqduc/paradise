/**
 * 
 */
package net.aquarium.lingual.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.framework.repository.BaseRepository;
import net.aquarium.lingual.entity.MessageLabel;

/**
 * @author ducbq
 *
 */
@Repository
public interface MessageLabelRepository extends BaseRepository<MessageLabel, Long> {
	List<MessageLabel> findByLanguage(String language);

	MessageLabel findByKeyAndLanguage(String key, String language);

	boolean existsByKey(String key);
}
