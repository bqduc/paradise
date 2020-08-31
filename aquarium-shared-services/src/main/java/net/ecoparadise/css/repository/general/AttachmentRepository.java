/**
 * 
 */
package net.ecoparadise.css.repository.general;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import net.ecoparadise.domain.entity.Attachment;
import net.ecoparadise.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AttachmentRepository extends BaseRepository<Attachment, Long> {
	Optional<Attachment> findByName(String name);
}
