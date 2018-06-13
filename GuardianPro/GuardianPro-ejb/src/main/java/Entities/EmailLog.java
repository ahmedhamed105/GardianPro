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
@Table(name = "email_log", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailLog.findAll", query = "SELECT e FROM EmailLog e"),
    @NamedQuery(name = "EmailLog.findAllN", query = "SELECT e FROM EmailLog e WHERE e.esendnot = 0"),
    @NamedQuery(name = "EmailLog.findById", query = "SELECT e FROM EmailLog e WHERE e.id = :id"),
    
    @NamedQuery(name = "EmailLog.findByEhost", query = "SELECT e FROM EmailLog e WHERE e.ehost = :ehost"),
    @NamedQuery(name = "EmailLog.findByEfrom", query = "SELECT e FROM EmailLog e WHERE e.efrom = :efrom"),
    @NamedQuery(name = "EmailLog.findByEpassword", query = "SELECT e FROM EmailLog e WHERE e.epassword = :epassword"),
    @NamedQuery(name = "EmailLog.findByEto", query = "SELECT e FROM EmailLog e WHERE e.eto = :eto"),
    @NamedQuery(name = "EmailLog.findByEsubject", query = "SELECT e FROM EmailLog e WHERE e.esubject = :esubject"),
    @NamedQuery(name = "EmailLog.findByEtext", query = "SELECT e FROM EmailLog e WHERE e.etext = :etext"),
    @NamedQuery(name = "EmailLog.findByEsendnot", query = "SELECT e FROM EmailLog e WHERE e.esendnot = :esendnot"),
    @NamedQuery(name = "EmailLog.findByEPort", query = "SELECT e FROM EmailLog e WHERE e.ePort = :ePort"),
    @NamedQuery(name = "EmailLog.findByETls", query = "SELECT e FROM EmailLog e WHERE e.eTls = :eTls")})
public class EmailLog implements Serializable {

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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_host", nullable = false, length = 45)
    private String ehost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_from", nullable = false, length = 45)
    private String efrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_password", nullable = false, length = 45)
    private String epassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_to", nullable = false, length = 45)
    private String eto;
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
    @Column(name = "E_send_not", nullable = false)
    private int esendnot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "E_Port", nullable = false, length = 45)
    private String ePort;
    @Basic(optional = false)
    @NotNull
    @Column(name = "E_TLS", nullable = false)
    private int eTls;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;

    public EmailLog() {
    }

    public EmailLog(Integer id) {
        this.id = id;
    }

    public EmailLog(Integer id, String ehost, String efrom, String epassword, String eto, String esubject, String etext, int esendnot, String ePort, int eTls) {
        this.id = id;
        this.ehost = ehost;
        this.efrom = efrom;
        this.epassword = epassword;
        this.eto = eto;
        this.esubject = esubject;
        this.etext = etext;
        this.esendnot = esendnot;
        this.ePort = ePort;
        this.eTls = eTls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEhost() {
        return ehost;
    }

    public void setEhost(String ehost) {
        this.ehost = ehost;
    }

    public String getEfrom() {
        return efrom;
    }

    public void setEfrom(String efrom) {
        this.efrom = efrom;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public String getEto() {
        return eto;
    }

    public void setEto(String eto) {
        this.eto = eto;
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

    public int getEsendnot() {
        return esendnot;
    }

    public void setEsendnot(int esendnot) {
        this.esendnot = esendnot;
    }

    public String getEPort() {
        return ePort;
    }

    public void setEPort(String ePort) {
        this.ePort = ePort;
    }

    public int getETls() {
        return eTls;
    }

    public void setETls(int eTls) {
        this.eTls = eTls;
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
    
}
