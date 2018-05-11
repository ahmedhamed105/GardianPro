/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "tgroup_has_accesory", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TgroupHasAccesory.findAll", query = "SELECT t FROM TgroupHasAccesory t"),
    @NamedQuery(name = "TgroupHasAccesory.findById", query = "SELECT t FROM TgroupHasAccesory t WHERE t.id = :id"),
    @NamedQuery(name = "TgroupHasAccesory.findByAaccessory", query = "SELECT t FROM TgroupHasAccesory t WHERE t.aaccessory = :aaccessory")})
public class TgroupHasAccesory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 500)
    @Column(name = "A_accessory", length = 500)
    private String aaccessory;
    @JoinColumn(name = "Terminal_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TerminalGroup terminalGroupID;
    @JoinColumn(name = "accessory_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private AccessoryGroup accessoryGroupID;

    public TgroupHasAccesory() {
    }

    public TgroupHasAccesory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAaccessory() {
        return aaccessory;
    }

    public void setAaccessory(String aaccessory) {
        this.aaccessory = aaccessory;
    }

    public TerminalGroup getTerminalGroupID() {
        return terminalGroupID;
    }

    public void setTerminalGroupID(TerminalGroup terminalGroupID) {
        this.terminalGroupID = terminalGroupID;
    }

    public AccessoryGroup getAccessoryGroupID() {
        return accessoryGroupID;
    }

    public void setAccessoryGroupID(AccessoryGroup accessoryGroupID) {
        this.accessoryGroupID = accessoryGroupID;
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
        if (!(object instanceof TgroupHasAccesory)) {
            return false;
        }
        TgroupHasAccesory other = (TgroupHasAccesory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TgroupHasAccesory[ id=" + id + " ]";
    }
    
}
