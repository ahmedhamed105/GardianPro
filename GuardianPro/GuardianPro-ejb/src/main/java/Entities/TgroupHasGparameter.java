/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "tgroup_has_gparameter", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TgroupHasGparameter.findAll", query = "SELECT t FROM TgroupHasGparameter t"),
    @NamedQuery(name = "TgroupHasGparameter.findById", query = "SELECT t FROM TgroupHasGparameter t WHERE t.id = :id")})
public class TgroupHasGparameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tgrouphasGparameterID")
    private Collection<TgroupHasParameter> tgroupHasParameterCollection;
    @JoinColumn(name = "Parameter_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ParameterGroup parameterGroupID;
    @JoinColumn(name = "Terminal_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TerminalGroup terminalGroupID;

    public TgroupHasGparameter() {
    }

    public TgroupHasGparameter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<TgroupHasParameter> getTgroupHasParameterCollection() {
        return tgroupHasParameterCollection;
    }

    public void setTgroupHasParameterCollection(Collection<TgroupHasParameter> tgroupHasParameterCollection) {
        this.tgroupHasParameterCollection = tgroupHasParameterCollection;
    }

    public ParameterGroup getParameterGroupID() {
        return parameterGroupID;
    }

    public void setParameterGroupID(ParameterGroup parameterGroupID) {
        this.parameterGroupID = parameterGroupID;
    }

    public TerminalGroup getTerminalGroupID() {
        return terminalGroupID;
    }

    public void setTerminalGroupID(TerminalGroup terminalGroupID) {
        this.terminalGroupID = terminalGroupID;
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
        if (!(object instanceof TgroupHasGparameter)) {
            return false;
        }
        TgroupHasGparameter other = (TgroupHasGparameter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TgroupHasGparameter[ id=" + id + " ]";
    }
    
}
