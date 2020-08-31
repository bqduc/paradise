/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.domain.entity.general.CatalogueSubtype;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class CatalogueSubtypeSpecification extends CoreSpecifications<CatalogueSubtype, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021774340255996625L;

	public static Specification<CatalogueSubtype> buildSpecification(final SearchParameter searchParameter) {
		return CatalogueSubtypeSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
