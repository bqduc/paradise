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
 *
 * @author haky
 */
@Entity
@Table(name="TRD_UT_SEQUENCE")
public class Sequence extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="SEQ_TYPE")
    private Integer type;
	
    @Column(name="SEQ_SERIAL", length=60)
    @Size(max=60)
    private String serial;
    
    @Column(name="SEQ_NUMBER", nullable=false)
    @NotNull
    private Long number = 0l;
            
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Sequence[id=" + getId() + "]";
    }
    
}
