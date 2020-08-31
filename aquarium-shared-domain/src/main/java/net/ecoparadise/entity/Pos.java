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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ForeignKey;

import net.ecoparadise.framework.entity.RepoEntity;

/**
 * Kredi kartı ile yapılan alışverişler için
 * pos bilgilerini tutar.
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="TRD_POS")
public class Pos extends RepoEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * posun bağlı olduğu banka bilgisidir.
	 */
	@ManyToOne
	@JoinColumn(name="BANK_ID")
	private Bank bank;

	@ManyToOne
	@JoinColumn(name="BANK_BRANCH_ID")
	private BankBranch bankBranch;

	@ManyToOne
	@JoinColumn(name="BANK_ACCOUNT_ID")
	private BankAccount bankAccount;

	@Column(name="CODE",unique=true)
	private String code;
	
	@Column(name="NAME")
	private String name;
	
    @Column(name="INFO")
	private String info;
	
    @Column(name="IS_ACTIVE")
    private Boolean active = Boolean.TRUE;

	@OneToMany(mappedBy="pos", cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PosCardList> posCardList = new ArrayList<PosCardList>();

	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private List<PosBankList> posBankList = new ArrayList<PosBankList>();

	/**
	 * Posun çalışabileceği max. taksit sayısını tutar.
	 */
    @Column(name="MAX_PERIOD")
	private Integer maxPeriod = 12;
	
    /**
     * Organizasyon seviye bilgisini tutar.
     */
    @ManyToOne
    @JoinColumn(name="ORGANIZATION_ID")
    @ForeignKey(name="FK_POS_ORGANIZATIONID")
    private Organization organization;
    
    public int[] getPeriods() {
    	int[] result = new int[maxPeriod];
    	
    	for (int i=0;i<result.length;i++) {
    		result[i] = 1 + i;
    	}
    	return result;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pos)) {
            return false;
        }
        Pos other = (Pos)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pos[id=" + getId() + "]";
    }

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public BankBranch getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<PosCardList> getPosCardList() {
		return posCardList;
	}

	public void setPosCardList(List<PosCardList> posCardList) {
		this.posCardList = posCardList;
	}

	public List<PosBankList> getPosBankList() {
		return posBankList;
	}

	public void setPosBankList(List<PosBankList> posBankList) {
		this.posBankList = posBankList;
	}

	public Integer getMaxPeriod() {
		return maxPeriod;
	}

	public void setMaxPeriod(Integer maxPeriod) {
		this.maxPeriod = maxPeriod;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
