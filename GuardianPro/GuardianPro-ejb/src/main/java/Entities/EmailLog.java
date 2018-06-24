/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "email_log", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailLog.findAll", query = "SELECT e FROM EmailLog e"),
    @NamedQuery(name = "EmailLog.findById", query = "SELECT e FROM EmailLog e WHERE e.id = :id"),
    @NamedQuery(name = "EmailLog.findByEsubject", query = "SELECT e FROM EmailLog e WHERE e.esubject = :esubject"),
    @NamedQuery(name = "EmailLog.findByEtext", query = "SELECT e FROM EmailLog e WHERE e.etext = :etext"),
    @NamedQuery(name = "EmailLog.findByCreateDate", query = "SELECT e FROM EmailLog e WHERE e.createDate = :createDate"),
    @NamedQuery(name = "EmailLog.findByUpdateDate", query = "SELECT e FROM EmailLog e WHERE e.updateDate = :updateDate")})
public class EmailLog implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Pending", nullable = false)
    private int pending;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_subject", nullable = false, length = 45)
    private String esubject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_text", nullable = false, length = 45)
    private String etext;
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
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emaillogID")
    private Collection<EmailHistory> emailHistoryCollection;

    public EmailLog() {
    }

    public EmailLog(Integer id) {
        this.id = id;
    }

    public EmailLog(Integer id, String esubject, String etext, Date createDate, Date updateDate) {
        this.id = id;
        this.esubject = esubject;
        this.etext = etext;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEsubject() {
        return esubject;
    }

    public void setEsubject(String esubject) {
        this.esubject = esubject;
    }

    public String getEtext() {
        return etext;
    }

    public void setEtext(String etext) {
        this.etext = etext;
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

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Collection<EmailHistory> getEmailHistoryCollection() {
        return emailHistoryCollection;
    }

    public void setEmailHistoryCollection(Collection<EmailHistory> emailHistoryCollection) {
        this.emailHistoryCollection = emailHistoryCollection;
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
        if (!(object instanceof EmailLog)) {
            return false;
        }
        EmailLog other = (EmailLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.EmailLog[ id=" + id + " ]";
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }
    
}
