package net.aquarium.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.stock.InventoryCore;
import net.aquarium.entity.stock.InventoryDetail;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface InventoryDetailRepository extends BaseRepository<InventoryDetail, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryDetail> findByOwner(InventoryCore inventoryCore);
}
