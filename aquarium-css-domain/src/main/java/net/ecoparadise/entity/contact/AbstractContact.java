/*
* Copyright 2017, Bui Quy Duc
* by the @authors tag. See the LICENCE in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package net.ecoparadise.entity.contact;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.ecoparadise.framework.entity.RepoAuditable;
import net.ecoparadise.global.GlobalConstants;

/**
 * A contact.
 * 
 * @author ducbq
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
public abstract class AbstractContact extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2137091334602439851L;

	@Setter @Getter
	@Column(name="code", length=GlobalConstants.SIZE_SERIAL, unique=true)
	private String code;

	@Setter @Getter
	@Column(name="name", length=GlobalConstants.SIZE_NAME)
	private String name;

	@Setter @Getter
	@Column(name="display_name", length=GlobalConstants.SIZE_NAME_TINY)
	private String displayName;

	@Setter @Getter
	@Column(name="title", length=GlobalConstants.SIZE_NAME_SHORT)
	private String title;

	@Setter @Getter
	@Column(name = "owner_id")
	private Long ownerId;

	@Setter @Getter
  @Column(name="issue_date")
  private Date issueDate;

	@Setter @Getter
  @Column(name="commencement_date")
  private Date commencementDate;

	@Setter @Getter
  @Column(name="issue_user_id")
  private Long issueUserId;

}
