/**
 * 
 */
package net.aquarium.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.aquarium.entity.system.Sequence;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.model.SearchSpec;
import net.aquarium.framework.specification.CoreSpecifications;

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
