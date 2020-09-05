package net.ecoparadise.repository.trade;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.PromissoryNote;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface PromissoryNoteRepository extends BaseRepository<PromissoryNote, Long>{
}
