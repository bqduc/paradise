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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.ecoparadise.framework.entity.RepoEntity;

/**
 * Entity class Unit
 * 
 * Unit of masurements
 *
 * @author haky
 */
@Entity
@Table(name="TRD_UNIT")
public class Unit extends RepoEntity{

    private static final long serialVersionUID = 1L;

    @Column(name="CODE", nullable=false, length=10)
    @NotNull
    @Size(max=10, min=1)
    private String code;
    
    @Column(name="CODE_EN", length=10)
    @Size(max=10)
    private String codeEn;

    @Column(name="INFO")
    private String info;
    
    @Column(name="SYSTEM")
    private Boolean system;

    @Column(name="ISACTIVE")
    private Boolean active = Boolean.TRUE;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public String toString() {
        return getCode();
    }

	public String getCodeEn() {
		return codeEn;
	}

	public void setCodeEn(String codeEn) {
		this.codeEn = codeEn;
	}
    
}
