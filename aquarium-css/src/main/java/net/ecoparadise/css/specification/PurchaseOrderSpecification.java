/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.entity.emx.PurchaseOrder;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class PurchaseOrderSpecification extends CoreSpecifications<PurchaseOrder, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4608364667950258805L;

	public static Specification<PurchaseOrder> buildSpecification(final SearchParameter searchParameter) {
		return PurchaseOrderSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
