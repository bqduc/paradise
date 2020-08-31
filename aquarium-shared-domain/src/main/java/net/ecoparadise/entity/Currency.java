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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.ecoparadise.framework.entity.RepoEntity;

/**
 * Entity class Currency
 * 
 * @author haky
 */
@Entity
@Table(name="TRD_CURRENCY")
public class Currency extends RepoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="CODE", nullable=false, unique=true, length=3)
    @NotNull
    @Size(max=3, min=1)
    private String code;
    
    @Column(name="NAME", length=20)
    @Size(max=20)
    private String name;
    
    @Column(name="COUNTRY", length=30)
    @Size(max=30)
    private String country;
    
    @Column(name="PIP")
    private Integer pip = 0;
    
    @Column(name="SYSTEM")
    private Boolean system;
    
    @Column(name="ISACTIVE")
    private Boolean active = Boolean.TRUE;

    @Column(name="DECIMAL_CODE", length=4)
    @Size(max=4)
    private String decimalCode;
    
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getPip() {
        return pip;
    }

    public void setPip(Integer pip) {
        this.pip = pip;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return getCode();
    }

	public String getDecimalCode() {
		return decimalCode;
	}

	public void setDecimalCode(String decimalCode) {
		this.decimalCode = decimalCode;
	}

}
