package net.ecoparadise.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.stock.InventoryCore;
import net.ecoparadise.entity.stock.InventoryPrice;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface InventoryPriceRepository extends BaseRepository<InventoryPrice, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryPrice> findByOwner(InventoryCore inventoryCore);
}
