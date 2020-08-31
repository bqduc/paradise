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
package net.ecoparadise.entity.stock;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.ecoparadise.common.ListUtility;
import net.ecoparadise.domain.entity.general.Catalogue;
import net.ecoparadise.entity.Tax;
import net.ecoparadise.entity.general.GeneralCatalogue;
import net.ecoparadise.entity.general.MeasureUnit;
import net.ecoparadise.framework.entity.RepoAuditable;
import net.ecoparadise.global.GlobalConstants;

/**
 * A product.
 * 
 * @author bqduc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inventory_item")
@EqualsAndHashCode(callSuper = true)
public class InventoryItem extends RepoAuditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8397420404962585057L;

	@NotNull
	@Size(min = 3, max=GlobalConstants.SIZE_SERIAL)
	@Column(unique = true)
	private String code;

	@Column(name = "barcode", length=GlobalConstants.SIZE_BARCODE)
	private String barcode;

	@Size(max = GlobalConstants.SIZE_NAME)
	@Column(name="name")
	private String name;

	@Size(max = GlobalConstants.SIZE_NAME)
	@Column(name="translated_name")
	private String translatedName;

	@Column(name="composition", length=150)
	private String composition; //Content also

	@Column(name="active_principle", length=150)
	private String activePrinciple;	

	@Column(name="processing_type", length=50)
	private String processingType;

	@Column(name="packaging", length=50)
	private String packaging;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "master_photo", columnDefinition="TEXT")
	private String masterPhoto;

	@Lob
	@Column(name = "info", columnDefinition="TEXT")
	private String info;

	@Column(name = "manufacturing_date")
	private Date manufacturingDate;

	@Column(name = "available_date")
	private Date availableDate;

	@Column(name = "master_vendor_id")
	private Long masterVendorId;

	@Column(name="vendor_part_number", length=GlobalConstants.SIZE_CODE)
	private String vendorPartNumber;

	@Column(name = "manufacturer_id")
	private Long manufacturerId;

	@Column(name="manufacturer_part_number", length=GlobalConstants.SIZE_CODE)
	private String manufacturerPartNumber;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private InventoryItem parent;

	@Column(name="minimum_options")
	private Integer minimumOptions;

	@Column(name="maximum_options")
	private Integer maximumOptions;

	@ManyToOne
	@JoinColumn(name = "master_measure_unit_id", referencedColumnName = "id")
	private MeasureUnit masterMeasureUnit;

	@ManyToOne
	@JoinColumn(name = "master_category_id", referencedColumnName = "id")
	private Catalogue masterCategory;

	@ManyToOne
	@JoinColumn(name = "master_sale_tax_id", referencedColumnName = "id")
	private Tax masterSaleTax;

	@ManyToOne
	@JoinColumn(name = "master_buy_tax_id", referencedColumnName = "id")
	private Tax masterBuyTax;

	@Builder.Default
	@JsonIgnore
	@OneToMany(mappedBy = "inventoryItem", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<InventoryItemCatalog> productCatalogues = ListUtility.createArrayList();

	@Transient
	@Builder.Default
	private List<Catalogue> catalogues = ListUtility.createArrayList();

	@Transient
	@Builder.Default
	private List<InventoryItemProfile> profiles = ListUtility.createArrayList();

	@ManyToOne
	@JoinColumn(name = "master_usage_direction_id")
	private GeneralCatalogue masterUsageDirection; // Đường dùng

	@ManyToOne
	@JoinColumn(name = "master_generic_drug_id")
	private GeneralCatalogue masterGenericDrug; //Generic drug/Chemical Name//Hoạt chất

	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@formatter:off
	@JoinTable(
			name = "inventory_item_catagory", 
			inverseJoinColumns = {@JoinColumn(name = "catalogue_id")},
			joinColumns = {@JoinColumn(name = "inventory_item_id")}
	)
	//@formatter:on
	private Set<Catalogue> categories = ListUtility.createHashSet();

	@Column(name = "servicing_code", length=GlobalConstants.SIZE_SERIAL)
	private String servicingCode;

	@Column(name = "cross_servicing_code", length=GlobalConstants.SIZE_SERIAL)
	private String crossServicingCode;

	@Column(name = "govenment_decision_no", length=GlobalConstants.SIZE_SERIAL)
	private String govenmentDecisionNo;

	@Column(name = "published_code", length=GlobalConstants.SIZE_SERIAL)
	private String publishedCode;
}
