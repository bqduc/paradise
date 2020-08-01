/**
 * 
 */
package net.aquarium.framework.predicator;

import org.springframework.data.jpa.domain.Specification;

import net.aquarium.framework.model.SearchParameter;

/**
 * @author bqduc
 *
 */
public abstract class BrilliancePredicator<T> extends RepositoryPredicator<T>{
	public Specification<T> buildSpecification(final SearchParameter searchParameter){
		return predicateSpecification(searchParameter);
	}
}
