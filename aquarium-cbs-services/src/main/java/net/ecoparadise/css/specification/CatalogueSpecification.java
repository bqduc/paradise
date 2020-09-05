/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.domain.entity.general.Catalogue;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class CatalogueSpecification extends CoreSpecifications<Catalogue, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021774340255996625L;

	public static Specification<Catalogue> buildSpecification(final SearchParameter searchParameter) {
		return CatalogueSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
