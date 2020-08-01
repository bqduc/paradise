package net.aquarium.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.aquarium.entity.stock.InventoryCore;
import net.aquarium.entity.stock.InventoryImage;
import net.aquarium.framework.repository.BaseRepository;

@Repository
public interface InventoryImageRepository extends BaseRepository<InventoryImage, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryImage> findByOwner(InventoryCore inventoryCore);
}
