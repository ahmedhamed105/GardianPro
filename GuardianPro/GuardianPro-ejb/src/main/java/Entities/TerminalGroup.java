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
@Table(name = "terminal_group", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerminalGroup.findAll", query = "SELECT t FROM TerminalGroup t"),
    @NamedQuery(name = "TerminalGroup.findById", query = "SELECT t FROM TerminalGroup t WHERE t.id = :id"),
    @NamedQuery(name = "TerminalGroup.findByGroupname", query = "SELECT t FROM TerminalGroup t WHERE t.groupname = :groupname"),
    @NamedQuery(name = "TerminalGroup.findByGroupdesc", query = "SELECT t FROM TerminalGroup t WHERE t.groupdesc = :groupdesc")})
public class TerminalGroup implements Serializable {



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalGroupID")
    private Collection<TgroupHasTerminal> tgroupHasTerminalCollection;

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
    @Column(name = "Group_name", nullable = false, length = 45)
    private String groupname;
    @Size(max = 45)
    @Column(name = "Group_desc", length = 45)
    private String groupdesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalGroupID")
    private Collection<TgroupHasAccesory> tgroupHasAccesoryCollection;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalGroupID")
    private Collection<TgroupHasSoftware> tgroupHasSoftwareCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalGroupID")
    private Collection<TgroupHasGparameter> tgroupHasGparameterCollection;

    public TerminalGroup() {
    }

    public TerminalGroup(Integer id) {
        this.id = id;
    }

    public TerminalGroup(Integer id, String groupname) {
        this.id = id;
        this.groupname = groupname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupdesc() {
        return groupdesc;
    }

    public void setGroupdesc(String groupdesc) {
        this.groupdesc = groupdesc;
    }

    @XmlTransient
    public Collection<TgroupHasAccesory> getTgroupHasAccesoryCollection() {
        return tgroupHasAccesoryCollection;
    }

    public void setTgroupHasAccesoryCollection(Collection<TgroupHasAccesory> tgroupHasAccesoryCollection) {
        this.tgroupHasAccesoryCollection = tgroupHasAccesoryCollection;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }



    @XmlTransient
    public Collection<TgroupHasSoftware> getTgroupHasSoftwareCollection() {
        return tgroupHasSoftwareCollection;
    }

    public void setTgroupHasSoftwareCollection(Collection<TgroupHasSoftware> tgroupHasSoftwareCollection) {
        this.tgroupHasSoftwareCollection = tgroupHasSoftwareCollection;
    }

    @XmlTransient
    public Collection<TgroupHasGparameter> getTgroupHasGparameterCollection() {
        return tgroupHasGparameterCollection;
    }

    public void setTgroupHasGparameterCollection(Collection<TgroupHasGparameter> tgroupHasGparameterCollection) {
        this.tgroupHasGparameterCollection = tgroupHasGparameterCollection;
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
        if (!(object instanceof TerminalGroup)) {
            return false;
        }
        TerminalGroup other = (TerminalGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TerminalGroup[ id=" + id + " ]";
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
    public Collection<TgroupHasTerminal> getTgroupHasTerminalCollection() {
        return tgroupHasTerminalCollection;
    }

    public void setTgroupHasTerminalCollection(Collection<TgroupHasTerminal> tgroupHasTerminalCollection) {
        this.tgroupHasTerminalCollection = tgroupHasTerminalCollection;
    }

   
    
}
