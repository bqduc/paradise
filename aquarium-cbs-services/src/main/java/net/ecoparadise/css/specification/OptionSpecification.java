/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.entity.Option;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

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
