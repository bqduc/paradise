package net.aquarium.css.service.general;

import java.util.Optional;

import net.aquarium.entity.general.ItemType;
import net.aquarium.exceptions.ObjectNotFoundException;
import net.aquarium.framework.service.GenericService;

public interface ItemTypeService extends GenericService<ItemType, Long>{

  /**
   * Get one item with the provided code.
   * 
   * @param code The item code
   * @return The item
   * @throws ObjectNotFoundException If no such account exists.
   */
	Optional<ItemType> getByCode(String code) throws ObjectNotFoundException;

  /**
   * Get one item with the provided code.
   * 
   * @param name The item type name
   * @return The item
   * @throws ObjectNotFoundException If no such account exists.
   */
	ItemType getByName(String name) throws ObjectNotFoundException;
}
