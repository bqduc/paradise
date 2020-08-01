/**
 * 
 */
package net.aquarium.auth.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.aquarium.auth.entity.Authority;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.model.SearchSpec;
import net.aquarium.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class AuthoritySpecification extends CoreSpecifications<Authority, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021774340255996625L;

	public static Specification<Authority> buildSpecification(final SearchParameter searchParameter) {
		return AuthoritySpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
