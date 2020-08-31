package net.ecoparadise.css.service.stock;

import java.util.List;

import net.ecoparadise.entity.stock.InventoryCore;
import net.ecoparadise.entity.stock.InventoryDetail;
import net.ecoparadise.entity.stock.InventoryImage;
import net.ecoparadise.framework.service.GenericService;
import net.nep.facade.ProductProfile;

public interface InventoryService extends GenericService<InventoryCore, Long> {
	ProductProfile getProfile(Long objectId);

	InventoryImage saveInventoryImage(InventoryImage inventoryImage);
	List<InventoryImage> getInventoryImages(Long inventoryId);

	InventoryImage getInventoryImage(Long inventoryImageId);
	
	InventoryDetail saveInventoryImage(InventoryDetail inventoryDetail);

	ProductProfile saveProfile(ProductProfile productProfile);
}
