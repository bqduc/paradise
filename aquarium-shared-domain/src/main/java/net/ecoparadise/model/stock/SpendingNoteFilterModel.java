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

import net.ecoparadise.entity.Employee;
import net.ecoparadise.entity.Warehouse;

/**
 *
 * @author selman
 */
public class SpendingNoteFilterModel extends DefaultDocumentFilterModel{
    
    private Employee employee;
    private Warehouse warehouse;
    
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
    
}
