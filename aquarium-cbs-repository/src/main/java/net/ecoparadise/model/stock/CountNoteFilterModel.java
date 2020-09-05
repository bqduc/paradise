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

import net.ecoparadise.entity.CountStatus;

/**
 *
 * @author sinan.yumak
 */
public class CountNoteFilterModel extends DefaultDocumentFilterModel {
    private CountStatus[] statusList;

	public CountStatus[] getStatusList() {
		return statusList;
	}

	public void setStatusList(CountStatus[] statusList) {
		this.statusList = statusList;
	}

	public void clear() {
		super.clear();
		this.statusList = null;
	}
}
