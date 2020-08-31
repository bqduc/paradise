
package net.ecoparadise.entity.emx;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;
import net.ecoparadise.framework.entity.RepoEntity;

/**
 * 
 * @author MOHAMMED BOUNAGA
 * 
 * github.com/medbounaga
 */
@Data
@Entity
@Table(name = "account")
@NamedQueries({
    @NamedQuery(name = "Account.findByType", query = "SELECT a FROM EnterpriseAccount a WHERE a.type = :type"),         
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM EnterpriseAccount a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM EnterpriseAccount a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByName", query = "SELECT a FROM EnterpriseAccount a WHERE a.title = :name"),
    @NamedQuery(name = "Account.findByActive", query = "SELECT a FROM EnterpriseAccount a WHERE a.active = :active")})
public class EnterpriseAccount extends RepoEntity {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256, message = "{LongString}")
    @Column(name = "name")
    private String name; 

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100, message = "{LongString}")
    @Column(name = "title")
    private String title;    

    @NotNull
    @Basic(optional = false)
    @Size(max = 64, message = "{LongString}")
    @Column(name = "type")
    private String type;

    @NotNull
    @Basic(optional = false)
    @Size(max = 64, message = "{LongString}")
    @Column(name = "code")
    private String code;    

    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<JournalItem> journalItems;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<InvoiceLine> invoiceLines;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<InvoiceTax> invoiceTaxes;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EnterprisePayment> payments;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CustomerInvoice> invoices;

    public EnterpriseAccount() {
    }

    public EnterpriseAccount(String code, String name, String title, String type, Boolean active) {
        this.code = code;
        this.type = type;
        this.title = title;
        this.name = name;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Account[ id=" + getId() + " ]";
    }
    
}
