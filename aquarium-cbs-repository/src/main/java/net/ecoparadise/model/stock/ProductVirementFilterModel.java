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

import net.ecoparadise.entity.Product;
import net.ecoparadise.entity.Warehouse;

/**
 *
 * @author nexus
 */
public class ProductVirementFilterModel extends DefaultDocumentFilterModel{

    private Product fromProduct;
    private Product toProduct;
    private Warehouse warehouse;
    
    
	public Product getFromProduct() {
		return fromProduct;
	}
	public void setFromProduct(Product fromProduct) {
		this.fromProduct = fromProduct;
	}
	public Product getToProduct() {
		return toProduct;
	}
	public void setToProduct(Product toProduct) {
		this.toProduct = toProduct;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


}
