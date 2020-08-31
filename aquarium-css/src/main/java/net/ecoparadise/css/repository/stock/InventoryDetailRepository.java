package net.ecoparadise.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.stock.InventoryCore;
import net.ecoparadise.entity.stock.InventoryDetail;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface InventoryDetailRepository extends BaseRepository<InventoryDetail, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryDetail> findByOwner(InventoryCore inventoryCore);
}
