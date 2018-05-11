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
@Table(name = "terminal_template", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerminalTemplate.findAll", query = "SELECT t FROM TerminalTemplate t"),
    @NamedQuery(name = "TerminalTemplate.findById", query = "SELECT t FROM TerminalTemplate t WHERE t.id = :id"),
    @NamedQuery(name = "TerminalTemplate.findByTName", query = "SELECT t FROM TerminalTemplate t WHERE t.tName = :tName"),
    @NamedQuery(name = "TerminalTemplate.findByTdesc", query = "SELECT t FROM TerminalTemplate t WHERE t.tdesc = :tdesc")})
public class TerminalTemplate implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminaltemplateID")
    private Collection<Terminal> terminalCollection;

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
    @Size(min = 1, max = 150)
    @Column(name = "TName", nullable = false, length = 150)
    private String tName;
    @Size(max = 150)
    @Column(name = "Tdesc", length = 150)
    private String tdesc;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminaltemplateID")
    private Collection<TerminalHasParts> terminalHasPartsCollection;

    public TerminalTemplate() {
    }

    public TerminalTemplate(Integer id) {
        this.id = id;
    }

    public TerminalTemplate(Integer id, String tName) {
        this.id = id;
        this.tName = tName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getTdesc() {
        return tdesc;
    }

    public void setTdesc(String tdesc) {
        this.tdesc = tdesc;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Collection<TerminalHasParts> getTerminalHasPartsCollection() {
        return terminalHasPartsCollection;
    }

    public void setTerminalHasPartsCollection(Collection<TerminalHasParts> terminalHasPartsCollection) {
        this.terminalHasPartsCollection = terminalHasPartsCollection;
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
        if (!(object instanceof TerminalTemplate)) {
            return false;
        }
        TerminalTemplate other = (TerminalTemplate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TerminalTemplate[ id=" + id + " ]";
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
    
}
