/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.entity.Sequence;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class SequenceSpecification extends CoreSpecifications <Sequence, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9124997437694609911L;

	public static Specification<Sequence> buildSpecification(final SearchParameter searchParameter) {
		return SequenceSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
