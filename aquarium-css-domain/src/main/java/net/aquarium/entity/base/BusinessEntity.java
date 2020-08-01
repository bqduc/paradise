package net.aquarium.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import net.aquarium.framework.entity.RepoAuditable;
import net.aquarium.global.GlobalConstants;

@MappedSuperclass
public abstract class BusinessEntity extends RepoAuditable {
	private static final long serialVersionUID = -448982043584817942L;

	@Setter
	@Getter
	@Size(min = 5, max = GlobalConstants.SIZE_SERIAL)
	@Column(name = "certifcate")
	private String certifcate;
}
