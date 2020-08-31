/**
 * 
 */
package net.ecoparadise.auth.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.auth.entity.Authority;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

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
