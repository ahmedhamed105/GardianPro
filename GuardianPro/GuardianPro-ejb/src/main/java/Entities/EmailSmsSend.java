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
@Table(name = "email_sms_send", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailSmsSend.findAll", query = "SELECT e FROM EmailSmsSend e"),
    @NamedQuery(name = "EmailSmsSend.findById", query = "SELECT e FROM EmailSmsSend e WHERE e.id = :id"),
    @NamedQuery(name = "EmailSmsSend.findByEmailDate", query = "SELECT e FROM EmailSmsSend e WHERE e.emailDate = :emailDate"),
    @NamedQuery(name = "EmailSmsSend.findByEmailactivationcode", query = "SELECT e FROM EmailSmsSend e WHERE e.emailactivationcode = :emailactivationcode"),
    @NamedQuery(name = "EmailSmsSend.findByCreateDate", query = "SELECT e FROM EmailSmsSend e WHERE e.createDate = :createDate"),
    @NamedQuery(name = "EmailSmsSend.findByUpdateDate", query = "SELECT e FROM EmailSmsSend e WHERE e.updateDate = :updateDate")})
public class EmailSmsSend implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Email_Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date emailDate;
    @Size(max = 45)
    @Column(name = "Email_activationcode", length = 45)
    private String emailactivationcode;
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

    public EmailSmsSend() {
    }

    public EmailSmsSend(Integer id) {
        this.id = id;
    }

    public EmailSmsSend(Integer id, Date emailDate, Date createDate, Date updateDate) {
        this.id = id;
        this.emailDate = emailDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(Date emailDate) {
        this.emailDate = emailDate;
    }

    public String getEmailactivationcode() {
        return emailactivationcode;
    }

    public void setEmailactivationcode(String emailactivationcode) {
        this.emailactivationcode = emailactivationcode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailSmsSend)) {
            return false;
        }
        EmailSmsSend other = (EmailSmsSend) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.EmailSmsSend[ id=" + id + " ]";
    }
    
}
