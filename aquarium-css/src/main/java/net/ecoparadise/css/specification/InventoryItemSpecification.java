/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.entity.stock.InventoryItem;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

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
