package net.ecoparadise.entity.stock;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ecoparadise.entity.ProductType;
import net.ecoparadise.entity.general.MeasureUnit;
import net.ecoparadise.framework.entity.RepoAuditable;
import net.ecoparadise.global.GlobalConstants;
import net.ecoparadise.model.InventoryType;

/**
 * Entity class Product
 * 
 * @author ducbq
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventory_core")
public class InventoryCore extends RepoAuditable {
	private static final long serialVersionUID = -2929178651788000055L;

	@Setter @Getter
	@Builder.Default
	@Column(name = "product_type")
	@Enumerated(EnumType.ORDINAL)
	private ProductType productType = ProductType.Product;

	@Setter @Getter
	@Column(name = "code", length = GlobalConstants.SIZE_CODE)
	private String code;

  @Size(max = 25, message = "{LongString}")
  @Column(name = "default_code")
  private String defaultCode;
	
	@Setter @Getter
	@Column(name = "barcode", length = GlobalConstants.SIZE_BARCODE)
	private String barcode;

	@Setter @Getter
	@Column(name = "NAME", length = GlobalConstants.SIZE_NAME)
	private String name;

	/**
	 * It keeps the writing information that will be printed on the label.
	 */
	@Setter @Getter
	@Column(name = "LABEL_NAME")
	private String labelName;

	@Setter @Getter
	@Size(max = GlobalConstants.SIZE_NAME)
	@Column(name = "translated_name")
	private String translatedName;
	
	@Setter @Getter
	@Builder.Default
	@Column(name = "open_date")
	@Temporal(TemporalType.DATE)
	private Date openDate = new Date();

	@Setter @Getter
	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Setter @Getter
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private InventoryCore parent;

	@Setter @Getter
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "issue_date")
	private Date issueDate;

	@Setter @Getter
	@Builder.Default
	@Column(name = "reset_date")
	private ZonedDateTime resetDate = null;

	@Setter @Getter
	@Builder.Default
	@Column(name = "weight")
	private Double weight = 0d;

	@Setter @Getter
	@Builder.Default
	@Column(name = "volume")
	private Double volume = 0d;

	@Setter @Getter
	@Builder.Default
	@Column(name = "lenght")
	private Double length = 0d;

	@Setter @Getter
	@Column(name = "sale_ok")
	private Boolean saleOk;

	@Setter @Getter
	@Column(name = "purchase_ok")
	private Boolean purchaseOk;

	@Setter @Getter
	@ManyToOne
	@JoinColumn(name = "measure_unit_id")
	private MeasureUnit measureUnit;

	@Setter @Getter
	@Column(name = "inventory_type")
	@Enumerated(EnumType.ORDINAL)
	private InventoryType inventoryType;

	@Setter @Getter
	@Column(name="stock_amount")
	private Double stockAmount;

	@Setter @Getter
	@Column(name="disable_when_stock_amount_is_zero")
	private Boolean disableWhenStockAmountIsZero;

	@Setter @Getter
	@Column(name="sort_order")
	private Integer sortOrder;

	@Setter @Getter
	@Column(name="fractional_unit")
	private Boolean fractionalUnit;

	@Setter @Getter
	@Column(name="default_sell_portion")
	private Integer defaultSellPortion;

	@Transient
	public String getCaption() {
		return "[" + getCode() + "] " + getName();
	}

	@Override
	public String toString() {
		return getName();
	}
}
