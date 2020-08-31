package net.ecoparadise.entity.crx;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.ecoparadise.auth.entity.AuthenticateAccount;
import net.ecoparadise.entity.Currency;
import net.ecoparadise.entity.contact.Team;
import net.ecoparadise.framework.entity.RepoAuditable;
import net.ecoparadise.global.GlobalConstants;
import net.ecoparadise.model.GeneralStatus;

/**
 * A contract or CRX.
 */
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "contract")
@EqualsAndHashCode(callSuper=false)
public class Contract extends RepoAuditable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2185824208770219101L;

	@Column(name="code", length=GlobalConstants.SIZE_SERIAL, unique=true)
	private String code;

	@Column(name = "name", nullable = false, unique=true, length=200)
	private String name;

	@ManyToOne(targetEntity=AuthenticateAccount.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "assigned_user_id")
	private AuthenticateAccount assignedTo;

	@Column(name="status")
  @Enumerated(EnumType.ORDINAL)
	private GeneralStatus status;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private CustomerAccount account;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "type_id")
	private ContractType contractType;

	@Digits(integer=12, fraction=2)
	@Column(name = "contract_value")
	private BigDecimal contractValue;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "opportunity_id")
	private Opportunity opportunity;

	@ManyToOne(targetEntity=Team.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private Team team;

  @Column(name="company_signed_date")
	@DateTimeFormat(iso = ISO.DATE)
  private Date companySignedDate;

  @Column(name="customer_signed_date")
	@DateTimeFormat(iso = ISO.DATE)
  private Date customerSignedDate;

  @Column(name="expiration_notice_date")
	@DateTimeFormat(iso = ISO.DATE_TIME)
  private Date expirationNoticeDate;

  @Column(name="start_date")
	@DateTimeFormat(iso = ISO.DATE)
  private Date startDate;

  @Column(name="end_date")
	@DateTimeFormat(iso = ISO.DATE)
  private Date endDate;

	@ManyToOne(targetEntity=Currency.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private Currency currency;

	@Column(name = "info", columnDefinition="TEXT")
	private String info;

}
