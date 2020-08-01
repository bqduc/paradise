/**
 * 
 */
package net.aquarium.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.aquarium.entity.general.MeasureUnit;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.model.SearchSpec;
import net.aquarium.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class MeasureUnitSpecification extends CoreSpecifications<MeasureUnit, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7455339506976096038L;

	public static Specification<MeasureUnit> buildSpecification(final SearchParameter searchParameter) {
		return MeasureUnitSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
