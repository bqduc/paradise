package net.ecoparadise.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ecoparadise.entity.stock.InventoryCore;
import net.ecoparadise.entity.stock.InventoryImage;
import net.ecoparadise.framework.repository.BaseRepository;

@Repository
public interface InventoryImageRepository extends BaseRepository<InventoryImage, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryImage> findByOwner(InventoryCore inventoryCore);
}
