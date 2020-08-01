/**
 * 
 */
package net.aquarium.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.aquarium.entity.contact.ContactAddress;
import net.aquarium.framework.model.SearchParameter;
import net.aquarium.framework.model.SearchSpec;
import net.aquarium.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class ContactAddressSpecification extends CoreSpecifications <ContactAddress, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4984760941753997036L;

	public static Specification<ContactAddress> buildSpecification(final SearchParameter searchParameter) {
		return ContactAddressSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
