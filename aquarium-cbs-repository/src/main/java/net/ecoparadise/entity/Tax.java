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

package net.ecoparadise.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import net.ecoparadise.framework.entity.RepoEntity;

/**
 * Entity class Tax
 * 
 * @author haky
 */
@Entity
@Table(name="TRD_TAX")
public class Tax extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="CODE", nullable=false, length=10)
    @NotNull
    @Size(max=10, min=1)
    private String code;

    @Column(name="NAME", length=50)
    @Size(max=50)
    private String name;
    
    @Column(name="INFO")
    private String info;

    @Column(name="TYPE")
	@Enumerated(EnumType.ORDINAL)
	private TaxType type;
    
    @Column(name="SYSTEM")
    private Boolean system;

    @Column(name="ISACTIVE")
    private Boolean active = Boolean.TRUE;

    @Column(name="IS_TRANSPORT_TAX")
    private Boolean isTransportTax = Boolean.FALSE;
    
    @OneToMany(mappedBy="tax", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<TaxRate> rates = new ArrayList<TaxRate>();
    
	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<TaxRate> getRates() {
        return rates;
    }

    public void setRates(List<TaxRate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Tax[id=" + getId() + "]";
    }

	public Boolean getIsTransportTax() {
		return isTransportTax;
	}

	public void setIsTransportTax(Boolean isTransportTax) {
		this.isTransportTax = isTransportTax;
	}

    /**
     * @return the type
     */
    public TaxType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TaxType type) {
        this.type = type;
    }
    
}
