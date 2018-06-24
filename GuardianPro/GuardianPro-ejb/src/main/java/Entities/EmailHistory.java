/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "email_history", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailHistory.findAll", query = "SELECT e FROM EmailHistory e"),
    @NamedQuery(name = "EmailHistory.findById", query = "SELECT e FROM EmailHistory e WHERE e.id = :id"),
    @NamedQuery(name = "EmailHistory.findByEmail", query = "SELECT e FROM EmailHistory e WHERE e.email = :email"),
    @NamedQuery(name = "EmailHistory.findByCreateDate", query = "SELECT e FROM EmailHistory e WHERE e.createDate = :createDate"),
    @NamedQuery(name = "EmailHistory.findByUpdateDate", query = "SELECT e FROM EmailHistory e WHERE e.updateDate = :updateDate"),
    @NamedQuery(name = "EmailHistory.findByEsendnot", query = "SELECT e FROM EmailHistory e WHERE e.esendnot = :esendnot")})
public class EmailHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "Email", length = 45)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "E_send_not", nullable = false)
    private int esendnot;
    @JoinColumn(name = "Config_email_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ConfigEmail configemailID;
    @JoinColumn(name = "Email_log_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private EmailLog emaillogID;

    public EmailHistory() {
    }

    public EmailHistory(Integer id) {
        this.id = id;
    }

    public EmailHistory(Integer id, Date createDate, Date updateDate, int esendnot) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.esendnot = esendnot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getEsendnot() {
        return esendnot;
    }

    public void setEsendnot(int esendnot) {
        this.esendnot = esendnot;
    }

    public ConfigEmail getConfigemailID() {
        return configemailID;
    }

    public void setConfigemailID(ConfigEmail configemailID) {
        this.configemailID = configemailID;
    }

    public EmailLog getEmaillogID() {
        return emaillogID;
    }

    public void setEmaillogID(EmailLog emaillogID) {
        this.emaillogID = emaillogID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailHistory)) {
            return false;
        }
        EmailHistory other = (EmailHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.EmailHistory[ id=" + id + " ]";
    }
    
}
