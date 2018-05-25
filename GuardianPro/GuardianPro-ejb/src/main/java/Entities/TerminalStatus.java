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
@Table(name = "terminal_status", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerminalStatus.findAll", query = "SELECT t FROM TerminalStatus t"),
    @NamedQuery(name = "TerminalStatus.findById", query = "SELECT t FROM TerminalStatus t WHERE t.id = :id"),
    @NamedQuery(name = "TerminalStatus.findByTstatus", query = "SELECT t FROM TerminalStatus t WHERE t.tstatus = :tstatus"),
    @NamedQuery(name = "TerminalStatus.findByTdescrip", query = "SELECT t FROM TerminalStatus t WHERE t.tdescrip = :tdescrip"),
    @NamedQuery(name = "TerminalStatus.findByCreateDate", query = "SELECT t FROM TerminalStatus t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TerminalStatus.findByUpdateDate", query = "SELECT t FROM TerminalStatus t WHERE t.updateDate = :updateDate")})
public class TerminalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Tstatus", nullable = false, length = 45)
    private String tstatus;
    @Size(max = 45)
    @Column(name = "Tdescrip", length = 45)
    private String tdescrip;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalstatusID")
    private Collection<Terminal> terminalCollection;

    public TerminalStatus() {
    }

    public TerminalStatus(Integer id) {
        this.id = id;
    }

    public TerminalStatus(Integer id, String tstatus, Date createDate, Date updateDate) {
        this.id = id;
        this.tstatus = tstatus;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTstatus() {
        return tstatus;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus;
    }

    public String getTdescrip() {
        return tdescrip;
    }

    public void setTdescrip(String tdescrip) {
        this.tdescrip = tdescrip;
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

    @XmlTransient
    public Collection<Terminal> getTerminalCollection() {
        return terminalCollection;
    }

    public void setTerminalCollection(Collection<Terminal> terminalCollection) {
        this.terminalCollection = terminalCollection;
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
        if (!(object instanceof TerminalStatus)) {
            return false;
        }
        TerminalStatus other = (TerminalStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TerminalStatus[ id=" + id + " ]";
    }
    
}
