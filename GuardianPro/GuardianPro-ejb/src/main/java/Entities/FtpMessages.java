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
@Table(name = "ftp_messages", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FtpMessages.findAll", query = "SELECT f FROM FtpMessages f"),
    @NamedQuery(name = "FtpMessages.findById", query = "SELECT f FROM FtpMessages f WHERE f.id = :id"),
    @NamedQuery(name = "FtpMessages.findByFmessages", query = "SELECT f FROM FtpMessages f WHERE f.fmessages = :fmessages"),
    @NamedQuery(name = "FtpMessages.findByCreateDate", query = "SELECT f FROM FtpMessages f WHERE f.createDate = :createDate"),
    @NamedQuery(name = "FtpMessages.findByFTPLogID", query = "SELECT f FROM FtpMessages f WHERE f.fTPLogID = :fTPLogID")})
public class FtpMessages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "F_messages", nullable = false, length = 500)
    private String fmessages;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FTP_Log_ID", nullable = false)
    private int fTPLogID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;

    public FtpMessages() {
    }

    public FtpMessages(Integer id) {
        this.id = id;
    }

    public FtpMessages(Integer id, String fmessages, Date createDate, int fTPLogID) {
        this.id = id;
        this.fmessages = fmessages;
        this.createDate = createDate;
        this.fTPLogID = fTPLogID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFmessages() {
        return fmessages;
    }

    public void setFmessages(String fmessages) {
        this.fmessages = fmessages;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getFTPLogID() {
        return fTPLogID;
    }

    public void setFTPLogID(int fTPLogID) {
        this.fTPLogID = fTPLogID;
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
        if (!(object instanceof FtpMessages)) {
            return false;
        }
        FtpMessages other = (FtpMessages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.FtpMessages[ id=" + id + " ]";
    }
    
}
