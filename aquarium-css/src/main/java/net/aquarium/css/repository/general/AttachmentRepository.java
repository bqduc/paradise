/**
 * 
 */
package net.aquarium.css.repository.general;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import net.aquarium.domain.entity.Attachment;
import net.aquarium.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AttachmentRepository extends BaseRepository<Attachment, Long> {
	Optional<Attachment> findByName(String name);
}
