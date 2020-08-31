package net.ecoparadise.entity.stock;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ecoparadise.domain.entity.general.Catalogue;
import net.ecoparadise.entity.Currency;
import net.ecoparadise.entity.Department;
import net.ecoparadise.entity.contact.CTAContact;
import net.ecoparadise.entity.general.MeasureUnit;
import net.ecoparadise.entity.general.TaxGroup;
import net.ecoparadise.framework.entity.RepoAuditable;
import net.ecoparadise.global.GlobalConstants;
import net.ecoparadise.model.BindingType;
import net.ecoparadise.model.DustJacketType;
import net.ecoparadise.model.InventoryCodeType;
import net.ecoparadise.model.InventoryConditionType;
import net.ecoparadise.model.InventoryType;

/**
 * A Book.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventory_item_profile")
public class InventoryItemProfile extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3211612246102766140L;

	@NotNull
	@Size(min = 3, max=GlobalConstants.SIZE_SERIAL)
	@Column(name="inventory_code")
	private String inventoryCode;
	
	@Version
	@Column(name = "version")
	private Short version;

	@Column(name = "author", length = 150)
	private String author;

	@Column(name = "publisher", length = 150)
	private String publisher;

	@Column(name = "date_of_publication")
	private Date dateOfPublication;

	@Column(name = "binding_type")
	@Enumerated(EnumType.ORDINAL)
	private BindingType bindingType;

	@Column(name = "inventory_type")
	@Enumerated(EnumType.ORDINAL)
	private InventoryType inventoryType;

	@Column(name = "illustrator", length = 50)
	private String illustrator;

	@Column(name = "edition", length = 50)
	private String edition;

	@Column(name = "code_type")
	@Enumerated(EnumType.ORDINAL)
	private InventoryCodeType inventoryCodeType;

	@Column(name = "condition_type")
	@Enumerated(EnumType.ORDINAL)
	private InventoryConditionType inventoryConditionType;

	@Column(name = "fulfillment_center_id", length = 40)
	private String fulfillmentCenterId;

	@Column(name = "sku", length = 40)
	private String sku;

	@Column(name = "dust_jacket_type")
	@Enumerated(EnumType.ORDINAL)
	private DustJacketType dustJacketType;

	@Column(name = "signed_by", length = 40)
	private String signedBy;

  /**
   * Select the option corresponding to your choice: "y" if you are offering expedited shipping to your customers; "n" otherwise.
   * 
   * "n" = Expedited shipping not available	
   * "y" = Expedited shipping available"
   */
	@Column(name = "expedited_shipping", length=2)
	private String expeditedShipping;

  /**
   * Select the code corresponding to your choice: "1" or "n": Will ship within US only; "2" or "y": Will ship to international locations
   * 
   * "1" or "n" = Will ship in US only
   * "2" or "y" = Will ship to international locations
   */
	@Column(name = "will_ship_internationally", length=2)
	private String willShipInternationally;
  
	@Column(name = "notes", columnDefinition="TEXT")
	private String notes;

	@Column(name = "condition", columnDefinition="TEXT")
	private String condition;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "photo", columnDefinition="TEXT")
	private String photo;

	@ManyToOne
	@JoinColumn(name = "main_category_id")
	private Catalogue category;

	@ManyToOne
	@JoinColumn(name = "sub_category_id")
	private Catalogue subCategory;

	@ManyToOne
	@JoinColumn(name = "supplementary_category_id")
	private Catalogue supplementaryCategory;

	@ManyToOne
	@JoinColumn(name = "extra_category_id")
	private Catalogue extraCategory;

	@ManyToOne
	@JoinColumn(name = "business_group_id")
	private Department businessGroup;

	@Column(name = "online_series", length=20)
	private String 	onlineSeries;

	@Column(name = "sales_model_subscription", length=20)
	private String salesModelSubscription;

	@Column(name = "sales_model_one_time", length=20)
	private String salesModelOneTime;

	@Column(name = "capacity")
	private Double capacity;

	@Column(name = "online_availability_date")
	private Date onlineAvailabilityDate;

	@Column(name = "production_publication_date")
	private Date productionPublicationDate;

	@Column(name = "url_online_library", length=100)
	private String urlOnlineLibrary;

	@Column(name = "oclc", length=20)
	private String oclc;

	@ManyToOne
	@JoinColumn(name = "specialized_subject_area_id")
	private Department specializedSubjectArea;

	@ManyToOne
	@JoinColumn(name = "main_subject_category_id")
	private Catalogue mainSubjectCategory;

	@Column(name = "isbn10", length=GlobalConstants.SIZE_ISBN_10)
	private String isbn10;

	@Column(name = "o_isbn10", length=GlobalConstants.SIZE_ISBN_10)
	private String oIsbn10;	

	@Column(name = "e_isbn10", length=GlobalConstants.SIZE_ISBN_10)
	private String eIsbn10;

	@Column(name = "isbn13", length=GlobalConstants.SIZE_ISBN_13)
	private String isbn13;

	@Column(name = "o_isbn13", length=GlobalConstants.SIZE_ISBN_13)
	private String oIsbn13;	

	@Column(name = "e_isbn13", length=GlobalConstants.SIZE_ISBN_13)
	private String eIsbn13;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private InventoryItemProfile parent;

	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "inventory_entry_vendor", 
			inverseJoinColumns = {@JoinColumn(name = "vendor_id")},
			joinColumns = {@JoinColumn(name = "inventory_entry_id")}
	)
	private Set<CTAContact> vendors;

	@ManyToOne
	@JoinColumn(name = "imprint_contact_id")
	private CTAContact imprint;

	@Column(name="concentration", length=150)
	private String concentration;

	@Column(name="active_principle", length=150)
	private String activePrinciple;	

	@Column(name="processing_type", length=50)
	private String processingType;

	@Column(name="packaging", length=50)
	private String packaging;

	@Column(name="standard", length=50)
	private String standard;

	@Column(name="expectation_of_life", length=50)
	private String expectationOfLife;

	@Column(name="production_company", length=150)
	private String productionCompany;

	@Column(name="production_country", length=50)
	private String productionCountry;

	@Column(name="production_address", length=250)
	private String productionAddress;

	@Column(name="registration_company", length=80)
	private String registrationCompany;

	@Column(name="registrationCountry", length=50)
	private String registrationCountry;

	@Column(name="registration_address", length=250)
	private String registrationAddress;

	@Column(name="circular_no")
	private String nationalCircularNo;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "manufacturing_date")
	private Date manufacturingDate;

	@Column(name="maintenance_level")
	private String maintenanceLevel;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name="reset_date")
	private Date resetDate;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "available_date")
	private Date availableDate;

	@Column(name="minimum_options")
	private Integer minimumOptions;

	@Column(name="maximum_options")
	private Integer maximumOptions;
	
	@ManyToOne(targetEntity=MeasureUnit.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "measure_unit_id")
	private MeasureUnit measureUnit;

	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currency currency;

	@Column(name="unit_name")
	private String unitName;

	@Column(name="translated_name")
	private String translatedName;

	@Column(name="buy_price")
	private Double buyPrice;

	@Column(name="stock_amount")
	private Double stockAmount;

	@Column(name="price")
	private Double price;

	@Column(name="discount_rate")
	private Double discountRate;

	@Column(name="disable_when_stock_amount_is_zero")
	private Boolean disableWhenStockAmountIsZero;

	@Column(name="sort_order")
	private Integer sortOrder;

	@Column(name="image_data")
	private byte[] imageData;

	@Column(name="fractional_unit")
	private Boolean fractionalUnit;

	@Column(name="default_sell_portion")
	private Integer defaultSellPortion;

	@ManyToOne(targetEntity=TaxGroup.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "tax_group_id")
	private TaxGroup taxGroup;

	@Column(name = "printer_group_code")
	private String printerGroupCode;
	
	@Column(name="root")
	private String root;
}
