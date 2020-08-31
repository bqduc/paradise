/**
 * 
 */
package net.ecoparadise.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.ecoparadise.entity.config.Configuration;
import net.ecoparadise.framework.model.SearchParameter;
import net.ecoparadise.framework.model.SearchSpec;
import net.ecoparadise.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class ConfigurationRepoSpecification extends CoreSpecifications<Configuration, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4115991455691287486L;

	public static Specification<Configuration> buildSpecification(final SearchParameter searchParameter) {
		return ConfigurationRepoSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
