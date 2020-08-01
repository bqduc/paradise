/**
 * 
 */
package net.aquarium.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.aquarium.entity.stock.InventoryItem;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.model.SearchSpec;
import net.aquarium.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class InventoryItemSpecification extends CoreSpecifications<InventoryItem, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4450845076335839837L;

	public static Specification<InventoryItem> buildSpecification(final SearchParameter searchParameter) {
		return InventoryItemSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
