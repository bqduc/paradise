package net.aquarium.css.service.stock;

import java.util.List;

import net.aquarium.entity.stock.InventoryCore;
import net.aquarium.entity.stock.InventoryDetail;
import net.aquarium.entity.stock.InventoryImage;
import net.aquarium.framework.service.GenericService;
import net.nep.facade.ProductProfile;

public interface InventoryService extends GenericService<InventoryCore, Long> {
	ProductProfile getProfile(Long objectId);

	InventoryImage saveInventoryImage(InventoryImage inventoryImage);
	List<InventoryImage> getInventoryImages(Long inventoryId);

	InventoryImage getInventoryImage(Long inventoryImageId);
	
	InventoryDetail saveInventoryImage(InventoryDetail inventoryDetail);

	ProductProfile saveProfile(ProductProfile productProfile);
}
