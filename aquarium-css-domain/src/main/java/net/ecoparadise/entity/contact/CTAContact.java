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

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ecoparadise.auth.entity.AuthenticateAccount;
import net.ecoparadise.common.CommonUtility;
import net.ecoparadise.common.ListUtility;
import net.ecoparadise.embeddable.Phone;
import net.ecoparadise.entity.ContactAddress;
import net.ecoparadise.entity.general.BusinessUnit;
import net.ecoparadise.entity.general.GeneralCatalogue;
import net.ecoparadise.model.GenderType;
import net.ecoparadise.model.PartnerType;

/**
 * A contact.
 * 
 * @author Bui Quy Duc
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cta_contact")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contact_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
public class CTAContact extends AbstractContact {
	private static final long serialVersionUID = -5019226095410649159L;

	@Setter @Getter
	@Column(name="saluation", length=5)
	private String saluation;

	@Setter @Getter
	@Column(name="first_name", length=50)
	private String firstName;

	@Setter @Getter
	@Column(name="last_name", length=150)
	private String lastName;

	@Setter @Getter
	@Column(name="account_name", length=150)
	private String accountName;

	@Setter @Getter
	@Column(name="department", length=50)
	private String department;

  @Embedded
  @AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "PHONE_COUNTRYCODE")),
		@AttributeOverride(name = "areaCode", column = @Column(name = "PHONE_AREACODE")),
		@AttributeOverride(name = "number", column = @Column(name = "PHONE_NUMBER")),
		@AttributeOverride(name = "extention", column = @Column(name = "PHONE_EXTENTION"))
  })
  private Phone phone; // office - working phone

  @Embedded
  @AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "HOME_PHONE_COUNTRYCODE")),
		@AttributeOverride(name = "areaCode", column = @Column(name = "HOME_PHONE_AREACODE")),
		@AttributeOverride(name = "number", column = @Column(name = "HOME_PHONE_NUMBER")),
		@AttributeOverride(name = "extention", column = @Column(name = "HOME_PHONE_EXTENTION"))
  })
  private Phone homePhone;

  @Embedded
  @AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "MOBILE_PHONE_COUNTRYCODE")),
		@AttributeOverride(name = "areaCode", column = @Column(name = "MOBILE_PHONE_AREACODE")),
		@AttributeOverride(name = "number", column = @Column(name = "MOBILE_PHONE_NUMBER")),
		@AttributeOverride(name = "extention", column = @Column(name = "MOBILE_PHONE_EXTENTION"))
  })
  private Phone mobilePhone;

  @Column(name="portal_name", length=50)
	private String portalName;

	@JsonIgnore
	@Column(name="portal_secret_key", length=50)
	private String portalSecretKey;

	@Builder.Default
	@Column(name = "portal_active")
	private java.lang.Boolean portalActive = false;

	@Column(name="email", /*nullable=false, unique = true, */length=120)
	private String email;

	@Column(name="email_others", length=120)
	private String emailOthers;

	@Builder.Default
	@Column(name = "email_opt_out")
	private java.lang.Boolean emailOptOut = false;

	@Builder.Default
	@Column(name = "email_invalid")
	private java.lang.Boolean emailInvalid = false;

	@ManyToOne
	@JoinColumn(name = "sms_opt_in_id")
	private GeneralCatalogue smsOptIn;

	@ManyToOne
	@JoinColumn(name = "lead_source_id")
	private GeneralCatalogue leadSource;

	@Column(name="fax", length=20)
	private String fax;

  @Column(name="birthdate")
	@DateTimeFormat(iso = ISO.DATE)
  private Date birthdate;

	@Column(name="birthplace", length=50)
	private String birthplace;

	@Column(name="gender")
  @Enumerated(EnumType.ORDINAL)
  private GenderType gender;

	@Column(name="type")
  @Enumerated(EnumType.ORDINAL)
  private PartnerType type;

	@Column(name="activation_key", length=20)
	@JsonIgnore
	private String activationKey;

	@Column(name="reset_key", length=20)
	@JsonIgnore
	private String resetKey;

	@Column(name="reset_date")
	private ZonedDateTime resetDate;

	@Lob
	@Column(name = "info", columnDefinition = "TEXT")
	@Type(type = "org.hibernate.type.TextType")
	private String info;

	@ManyToOne
	@JoinColumn(name = "referal_contact_id")
	private CTAContact referal;

	@ManyToOne
	@JoinColumn(name = "reports_contact_id")
	private CTAContact reportsTo;

	@ManyToOne
	@JoinColumn(name = "assistant_contact_id")
	private CTAContact assistant;

	@ManyToOne
	@JoinColumn(name = "business_unit_id")
	private BusinessUnit businessUnit;

	@ManyToOne
	@JoinColumn(name = "job_info_id")
	private GeneralCatalogue jobInfo;

	@Builder.Default
	@Column(name = "sync_contact")
	private java.lang.Boolean syncContact = false;

	@Builder.Default
	@Column(name = "do_not_call")
	private java.lang.Boolean doNotCall = false;

	@Transient
	@Builder.Default
	private Set<ContactAddress> contactAddresses = ListUtility.newHashSet();

	@Builder.Default
	@Transient
	private Set<ContactTeam> contactTeams = ListUtility.newHashSet();

	/*@Builder.Default
	@ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(name = "contact_document",
      joinColumns = @JoinColumn(name = "contact_id"),
      inverseJoinColumns = @JoinColumn(name = "document_id")
  )
  private List<Document> documents = ListUtility.createArrayList();*/
	
	@ManyToOne
	@JoinColumn(name = "owner_user_id")
	private AuthenticateAccount ownerAuthAccount;

  @Column(name="issue_date")
  private Date issueDate;
	
	@ManyToOne
  @JoinColumn(name="issue_user_id",  insertable=false, updatable=false)
  private AuthenticateAccount issueAuthAccount;

	public void setContactAddresses(List<ContactAddress> contactAddresses) {
		if (null==this.contactAddresses)
			this.contactAddresses = ListUtility.newHashSet();

		if (CommonUtility.isNotEmpty(contactAddresses)){
			this.contactAddresses.addAll(contactAddresses);
		}
	}

	public void setContactAddresses(Set<ContactAddress> contactAddresses) {
		this.contactAddresses = contactAddresses;
	}

	public Set<ContactTeam> getContactTeams() {
		return contactTeams;
	}

	public void setContactTeams(List<ContactTeam> contactTeams) {
		if (null==this.contactTeams)
			this.contactTeams = ListUtility.newHashSet();

		if (CommonUtility.isNotEmpty(contactTeams)){
			this.contactTeams.addAll(contactTeams);
		}
	}
}
