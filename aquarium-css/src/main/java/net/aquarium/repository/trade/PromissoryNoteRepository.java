package net.aquarium.repository.trade;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.trade.PromissoryNote;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface PromissoryNoteRepository extends BaseRepository<PromissoryNote, Long>{
}
