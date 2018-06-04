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
@Table(name = "ftp_log", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FtpLog.findAll", query = "SELECT f FROM FtpLog f"),
    @NamedQuery(name = "FtpLog.findById", query = "SELECT f FROM FtpLog f WHERE f.id = :id"),
    @NamedQuery(name = "FtpLog.findByFtpDir", query = "SELECT f FROM FtpLog f WHERE f.ftpDir = :ftpDir"),
    @NamedQuery(name = "FtpLog.findByLocalDIR", query = "SELECT f FROM FtpLog f WHERE f.localDIR = :localDIR"),
    @NamedQuery(name = "FtpLog.findByFilename", query = "SELECT f FROM FtpLog f WHERE f.filename = :filename"),
    @NamedQuery(name = "FtpLog.findByFUsername", query = "SELECT f FROM FtpLog f WHERE f.fUsername = :fUsername"),
    @NamedQuery(name = "FtpLog.findByFpassword", query = "SELECT f FROM FtpLog f WHERE f.fpassword = :fpassword"),
    @NamedQuery(name = "FtpLog.findByFPort", query = "SELECT f FROM FtpLog f WHERE f.fPort = :fPort"),
    @NamedQuery(name = "FtpLog.findByCreateDate", query = "SELECT f FROM FtpLog f WHERE f.createDate = :createDate"),
    @NamedQuery(name = "FtpLog.findByUpdateDate", query = "SELECT f FROM FtpLog f WHERE f.updateDate = :updateDate")})
public class FtpLog implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fTPLogID")
    private Collection<FtpMessages> ftpMessagesCollection;



    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Server_ip", nullable = false, length = 45)
    private String serverip;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "FTP_DIR", nullable = false, length = 500)
    private String ftpDir;
    @Size(max = 500)
    @Column(name = "Local_DIR", length = 500)
    private String localDIR;
    @Size(max = 500)
    @Column(name = "File_name", length = 500)
    private String filename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "F_Username", nullable = false, length = 45)
    private String fUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "F_password", nullable = false, length = 45)
    private String fpassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "F_Port", nullable = false, length = 45)
    private String fPort;
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

    public FtpLog() {
    }

    public FtpLog(Integer id) {
        this.id = id;
    }

    public FtpLog(Integer id, String ftpDir, String fUsername, String fpassword, String fPort, Date createDate, Date updateDate) {
        this.id = id;
        this.ftpDir = ftpDir;
        this.fUsername = fUsername;
        this.fpassword = fpassword;
        this.fPort = fPort;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFtpDir() {
        return ftpDir;
    }

    public void setFtpDir(String ftpDir) {
        this.ftpDir = ftpDir;
    }

    public String getLocalDIR() {
        return localDIR;
    }

    public void setLocalDIR(String localDIR) {
        this.localDIR = localDIR;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFUsername() {
        return fUsername;
    }

    public void setFUsername(String fUsername) {
        this.fUsername = fUsername;
    }

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword;
    }

    public String getFPort() {
        return fPort;
    }

    public void setFPort(String fPort) {
        this.fPort = fPort;
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
        if (!(object instanceof FtpLog)) {
            return false;
        }
        FtpLog other = (FtpLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.FtpLog[ id=" + id + " ]";
    }

    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }


    @XmlTransient
    public Collection<FtpMessages> getFtpMessagesCollection() {
        return ftpMessagesCollection;
    }

    public void setFtpMessagesCollection(Collection<FtpMessages> ftpMessagesCollection) {
        this.ftpMessagesCollection = ftpMessagesCollection;
    }
    
}
