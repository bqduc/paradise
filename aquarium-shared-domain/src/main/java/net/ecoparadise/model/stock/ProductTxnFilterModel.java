/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.ecoparadise.model.stock;

import net.ecoparadise.common.CommonUtility;
import net.ecoparadise.entity.Contact;
import net.ecoparadise.entity.DocumentType;
import net.ecoparadise.entity.Product;
import net.ecoparadise.entity.ProductCategory;
import net.ecoparadise.entity.ProductGroup;
import net.ecoparadise.entity.Warehouse;
import net.ecoparadise.entity.WorkBunch;

/**
 *
 * @author haky
 */
public class ProductTxnFilterModel extends DefaultDocumentFilterModel{
    
    private Warehouse warehouse;
    private Product product;
    private Contact contact;
    private DocumentType documentType;
    private ProductCategory category;
    private String productCode;
    private String productName;
    private Integer productType;
    private ProductGroup group;
    private String barcode;
    private String adverseCode;
    private String adverseName;
    private WorkBunch workBunch;

    public boolean isEmpty(){
    	return CommonUtility.isEmpty(barcode) & product == null;
    }
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public ProductGroup getGroup() {
        return group;
    }

    public void setGroup(ProductGroup group) {
        this.group = group;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public String getAdverseCode() {
        return adverseCode;
    }

    public void setAdverseCode(String adverseCode) {
        this.adverseCode = adverseCode;
    }

    public String getAdverseName() {
        return adverseName;
    }

    public void setAdverseName(String adverseName) {
        this.adverseName = adverseName;
    }

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public WorkBunch getWorkBunch() {
		return workBunch;
	}

	public void setWorkBunch(WorkBunch workBunch) {
		this.workBunch = workBunch;
	}
    
    
}
