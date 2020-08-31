
package net.ecoparadise.entity.emx;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import net.ecoparadise.framework.validation.InDateRange;
import net.ecoparadise.framework.validation.StrictlyPositiveNumber;

/**
 * 
 * @author MOHAMMED BOUNAGA
 * 
 * github.com/medbounaga
 */
@Data
@Entity
@Table(name = "enterprise_payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findByPartner", query = "SELECT p FROM EnterprisePayment p WHERE p.partner.id = :partnerId AND p.partnerType = :partnerType "),
    @NamedQuery(name = "Payment.countByPartner", query = "SELECT COUNT(p) FROM EnterprisePayment p WHERE p.partner.id = :partnerId AND p.partnerType = :partnerType"),
    @NamedQuery(name = "Payment.findOutstandingByPartner", query = "SELECT p FROM EnterprisePayment p WHERE p.partner.id = :partnerId AND p.type = :type AND p.state = :status AND p.partnerType = :partnerType AND p.overpayment > 0"),
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM EnterprisePayment p"),
    @NamedQuery(name = "Payment.findByPartnerType", query = "SELECT p FROM EnterprisePayment p WHERE p.partnerType = :partnerType"),
    @NamedQuery(name = "Payment.findById", query = "SELECT p FROM EnterprisePayment p WHERE p.id = :id"),
    @NamedQuery(name = "Payment.findByDate", query = "SELECT p FROM EnterprisePayment p WHERE p.date = :date"),
    @NamedQuery(name = "Payment.findByAmount", query = "SELECT p FROM EnterprisePayment p WHERE p.amount = :amount"),
    @NamedQuery(name = "Payment.findByActive", query = "SELECT p FROM EnterprisePayment p WHERE p.active = :active")})
public class EnterprisePayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Basic(optional = false)
    @NotNull
    @InDateRange
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();
    @Basic(optional = false)
    @NotNull
    @StrictlyPositiveNumber(message = "{PositivePayment}")
    @Column(name = "amount")
    private Double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overpayment")
    private double overpayment;
    @Size(max = 64, message = "{LongString}")
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(max = 64, message = "{LongString}")
    @Column(name = "partner_type")
    private String partnerType;
    @Size(max = 64, message = "{LongString}")
    @Column(name = "name")
    private String name;
    @Size(max = 64, message = "{LongString}")
    @Column(name = "reference")
    private String reference;
    @Size(max = 64, message = "{LongString}")
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne
    private EnterpriseAccount account;
    @JoinColumn(name = "entry_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.PERSIST)
    private JournalEntry journalEntry;
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne
    private CustomerInvoice invoice;
    @JoinColumn(name = "journal_id", referencedColumnName = "id")
    @ManyToOne
    private Journal journal;
    @JoinColumn(name = "partner_id", referencedColumnName = "id")
    @ManyToOne
    private Partner partner;
    

    public EnterprisePayment() {
    }

    public EnterprisePayment(double amount, Date date, Partner partner, Journal journal, String type, Boolean active, EnterpriseAccount account, JournalEntry journalEntry, CustomerInvoice invoice, String state, double overpayment, String partnerType) {
        this.type = type;
        this.active = active;
        this.account = account;
        this.journalEntry = journalEntry;
        this.invoice = invoice;
        this.amount = amount;
        this.date = date;
        this.partner = partner;
        this.journal = journal;
        this.state = state;
        this.overpayment = overpayment;
        this.partnerType = partnerType;
    }

    public EnterprisePayment(double amount, Date date, Partner partner, Journal journal, String type, Boolean active, EnterpriseAccount account, JournalEntry journalEntry, CustomerInvoice invoice, String state, String reference, double overpayment, String partnerType) {
        this.type = type;
        this.active = active;
        this.account = account;
        this.journalEntry = journalEntry;
        this.invoice = invoice;
        this.amount = amount;
        this.date = date;
        this.partner = partner;
        this.journal = journal;
        this.state = state;
        this.reference = reference;
        this.overpayment = overpayment;
        this.partnerType = partnerType;
    }

    @Override
    public String toString() {
        return "Payment[ id=" + id + " ]";
    }

}
