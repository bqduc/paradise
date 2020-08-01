package net.aquarium.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.stock.InventoryCore;
import net.aquarium.entity.stock.InventoryPrice;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface InventoryPriceRepository extends BaseRepository<InventoryPrice, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryPrice> findByOwner(InventoryCore inventoryCore);
}
