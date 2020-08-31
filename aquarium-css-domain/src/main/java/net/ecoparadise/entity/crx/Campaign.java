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
import net.ecoparadise.model.GeneralStatus;

/**
 * A Campaign or CRX.
 */
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "campaign")
@EqualsAndHashCode(callSuper=false)
public class Campaign extends RepoAuditable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2519286162124918877L;

	@Column(name = "name", nullable = false, unique=true, length=200)
	private String name;

	@ManyToOne(targetEntity=AuthenticateAccount.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private AuthenticateAccount assignedTo;

	@Column(name="status")
  @Enumerated(EnumType.ORDINAL)
	private GeneralStatus status;

	@ManyToOne(targetEntity=Team.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "team_id", insertable=false, updatable=false)
	private Team team;

  @Column(name="start_date")
	@DateTimeFormat(iso = ISO.DATE)
  private Date startDate;

  @Column(name="end_date")
	@DateTimeFormat(iso = ISO.DATE)
  private Date endDate;

	@Column(name="campaign_type_id")
  @Enumerated(EnumType.ORDINAL)
	private CRXGeneralType campaignType;

	@ManyToOne(targetEntity=Currency.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "currency_id", insertable=false, updatable=false)
	private Currency currency;

	@Column(name = "impressions")
	private Integer impressions;

	@Digits(integer=12, fraction=2)
	@Column(name = "budget")
	private BigDecimal budget;

	@Digits(integer=12, fraction=2)
	@Column(name = "actual_cost")
	private BigDecimal actualCost;

	@Digits(integer=12, fraction=2)
	@Column(name = "expected_revenue")
	private BigDecimal expectedRevenue;

	@Digits(integer=12, fraction=2)
	@Column(name = "expected_cost")
	private BigDecimal expectedCost;

	@Column(name = "objective", columnDefinition="TEXT")
	private String objective;

	@Column(name = "tracker_text", columnDefinition="TEXT")
	private String trackerText;

	@Column(name = "refer_url", length=200)
	private String referUrl;

	@Column(name = "content", columnDefinition="TEXT")
	private String content;


}
