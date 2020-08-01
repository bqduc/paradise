/**
 * 
 */
package net.aquarium.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.aquarium.entity.system.Option;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.model.SearchSpec;
import net.aquarium.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class OptionSpecification extends CoreSpecifications<Option, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3900233288875704002L;

	public static Specification<Option> buildSpecification(final SearchParameter searchParameter) {
		return OptionSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
