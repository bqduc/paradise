/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.entity.Unit;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class MeasureUnitSpecification extends CoreSpecifications<Unit, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7455339506976096038L;

	public static Specification<Unit> buildSpecification(final SearchParameter searchParameter) {
		return MeasureUnitSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
