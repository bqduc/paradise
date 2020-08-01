/**
 * 
 */
package net.aquarium.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.aquarium.entity.general.LocalizedItem;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.model.SearchSpec;
import net.aquarium.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class LocalizedItemSpecification extends CoreSpecifications<LocalizedItem, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 267373264038078704L;

	public static Specification<LocalizedItem> buildSpecification(final SearchParameter searchParameter) {
		return LocalizedItemSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
