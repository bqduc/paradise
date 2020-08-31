package net.ecoparadise.entity.crx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.ecoparadise.framework.entity.RepoAuditable;

/**
 * An region or CRX.
 */
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "contract_type")
@EqualsAndHashCode(callSuper=false)
public class ContractType extends RepoAuditable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7781834379003474683L;

	@Size(min = 5, max = 200)
	@Column(name = "name", nullable = false, unique=true)
	private String name;

	@Column(name = "info", columnDefinition="TEXT")
	private String info;

}
