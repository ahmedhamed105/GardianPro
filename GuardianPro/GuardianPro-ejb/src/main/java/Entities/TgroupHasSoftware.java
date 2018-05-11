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
@Table(name = "tgroup_has_software", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TgroupHasSoftware.findAll", query = "SELECT t FROM TgroupHasSoftware t"),
    @NamedQuery(name = "TgroupHasSoftware.findById", query = "SELECT t FROM TgroupHasSoftware t WHERE t.id = :id"),
    @NamedQuery(name = "TgroupHasSoftware.findBySDesc", query = "SELECT t FROM TgroupHasSoftware t WHERE t.sDesc = :sDesc")})
public class TgroupHasSoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 500)
    @Column(name = "S_Desc", length = 500)
    private String sDesc;
    @JoinColumn(name = "Application_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ApplicationGroup applicationGroupID;
    @JoinColumn(name = "Terminal_Group_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TerminalGroup terminalGroupID;

    public TgroupHasSoftware() {
    }

    public TgroupHasSoftware(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSDesc() {
        return sDesc;
    }

    public void setSDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    public ApplicationGroup getApplicationGroupID() {
        return applicationGroupID;
    }

    public void setApplicationGroupID(ApplicationGroup applicationGroupID) {
        this.applicationGroupID = applicationGroupID;
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
        if (!(object instanceof TgroupHasSoftware)) {
            return false;
        }
        TgroupHasSoftware other = (TgroupHasSoftware) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TgroupHasSoftware[ id=" + id + " ]";
    }
    
}
