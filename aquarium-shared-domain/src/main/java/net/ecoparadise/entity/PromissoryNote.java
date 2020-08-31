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
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import net.ecoparadise.framework.entity.RepoEntity;

/**
 * PromissoryNote
 * 
 * @author dumlupinar
 */
@Entity
@Table(name="TRD_PROMISSORYNOTE")
public class PromissoryNote extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="REFERENCE_NO", length=20, nullable=false, unique=true)
    @NotNull
    @Size(max=20, min=1)
    private String referenceNo;

    /**
     * Firma/Müşteri senedi
     */
    @Column(name="IS_CLIENT_PROMISSORYNOTE")
    private Boolean clientPromissoryNote = Boolean.TRUE;

    /**
     * Senedin asıl sahibi
     */
    @Column(name="PROMISSORYNOTE_OWNER", length=255)
    @Size(max=255)
    private String promissorynoteOwner;

    /**
     * Ödeyecek/Keşideci
     */
    @ManyToOne
    @JoinColumn(name="CONTACT_ID")
    private Contact contact;

    /**
     * Ödeme/Keşide yeri
     */
    @Column(name="PAYMENT_PLACE", length=30)
    @Size(max=30)
    private String paymentPlace;

    @Column(name="SERIAL_NO", length=30)
    @Size(max=30)
    private String serialNo;

    /**
     * Ciro Tarihi / sisteme alındığı tarih
     */
    @Column(name="ENTRY_DATE")
    @Temporal(TemporalType.DATE)
    private Date entryDate = new Date();
	
    /**
     * Düzenleme tarihi
     */
    @Column(name="ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate = new Date();

    /**
     * Vadesi
     */
    @Column(name="MATURITY_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date maturityDate;

    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="CCY")),
        @AttributeOverride(name="value",    column=@Column(name="CCYVAL")),
        @AttributeOverride(name="localAmount", column=@Column(name="LCYVAL"))
    })
    private MoneySet money = new MoneySet();

    /**
     * Cirolu olup olmadığı
     */
    @Column(name="ISENDORSEMENT")
    private Boolean endorsement = Boolean.FALSE;

    @Column(name="INFO")
    private String info;

    @Column(name="PREVIOUS_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private ChequeStatus previousStatus;

    @Column(name="LAST_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private ChequeStatus lastStatus;
    
    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PromissoryNoteHistory> history = new ArrayList<PromissoryNoteHistory>();
    
    @Transient
    private Boolean checked = Boolean.FALSE;

    /**
     * siparis de alinan kaparo tutarlarinin takibi icin
     */
    @Column(name="TRADEIN")
    private Boolean tradein = Boolean.FALSE;

    public String getReferenceNo() {
            return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
            this.referenceNo = referenceNo;
    }

    public String getPromissorynoteOwner() {
            return promissorynoteOwner;
    }

    public void setPromissorynoteOwner(String promissorynoteOwner) {
            this.promissorynoteOwner = promissorynoteOwner;
    }

    public String getPaymentPlace() {
            return paymentPlace;
    }

    public void setPaymentPlace(String paymentPlace) {
            this.paymentPlace = paymentPlace;
    }

    public String getSerialNo() {
            return serialNo;
    }

    public void setSerialNo(String serialNo) {
            this.serialNo = serialNo;
    }

    public Date getEntryDate() {
            return entryDate;
    }

    public void setEntryDate(Date entryDate) {
            this.entryDate = entryDate;
    }

    public Date getMaturityDate() {
            return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
            this.maturityDate = maturityDate;
    }

    public Date getIssueDate() {
            return issueDate;
    }

    public void setIssueDate(Date issueDate) {
            this.issueDate = issueDate;
    }



    public Boolean getEndorsement() {
            return endorsement;
    }

    public void setEndorsement(Boolean endorsement) {
            this.endorsement = endorsement;
    }

    public Boolean getClientPromissoryNote() {
            return clientPromissoryNote;
    }

    public void setClientPromissoryNote(Boolean clientPromissoryNote) {
            this.clientPromissoryNote = clientPromissoryNote;
    }

    public Contact getContact() {
            return contact;
    }

    public void setContact(Contact contact) {
            this.contact = contact;
    }

    public String getInfo() {
            return info;
    }

    public void setInfo(String info) {
            this.info = info;
    }

    public ChequeStatus getPreviousStatus() {
            return previousStatus;
    }

    public void setPreviousStatus(ChequeStatus previousStatus) {
            this.previousStatus = previousStatus;
    }

    public ChequeStatus getLastStatus() {
            return lastStatus;
    }

    public void setLastStatus(ChequeStatus lastStatus) {
            this.lastStatus = lastStatus;
    }

    public List<PromissoryNoteHistory> getHistory() {
            return history;
    }

    public void setHistory(List<PromissoryNoteHistory> history) {
            this.history = history;
    }

    public Boolean getChecked() {
            return checked;
    }

    public void setChecked(Boolean checked) {
            this.checked = checked;
    }
	
    @Transient
    public String getCaption(){
        return "[" + getSerialNo() + "] " + getPromissorynoteOwner();
    }

    @Override
    public String toString() {
        return "PromissoryNote[id=" + getId() + "]";
    }

    public MoneySet getMoney() {
        return money;
    }

    public void setMoney(MoneySet money) {
        this.money = money;
    }

	public Boolean getTradein() {
		return tradein;
	}

	public void setTradein(Boolean tradein) {
		this.tradein = tradein;
	}

}
