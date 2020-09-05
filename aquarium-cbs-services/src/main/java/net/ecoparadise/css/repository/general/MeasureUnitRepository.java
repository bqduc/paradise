package net.ecoparadise.css.repository.general;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.Unit;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface MeasureUnitRepository extends BaseRepository<Unit, Long>{
	Optional<Unit> findByName(String name);
	Optional<Unit> findByNameLocal(String nameLocal);
	Optional<Unit> findByCode(String code);
	Long countByCode(String code);
	Long countByName(String name);

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.codeEn) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.info) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<Unit> search(@Param("keyword") String keyword, Pageable pageable);
}
