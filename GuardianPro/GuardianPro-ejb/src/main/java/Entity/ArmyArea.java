/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "army_area", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArmyArea.findAll", query = "SELECT a FROM ArmyArea a")
    , @NamedQuery(name = "ArmyArea.findById", query = "SELECT a FROM ArmyArea a WHERE a.id = :id")
    , @NamedQuery(name = "ArmyArea.findByAreaname", query = "SELECT a FROM ArmyArea a WHERE a.areaname = :areaname")})
public class ArmyArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Area_name", nullable = false, length = 500)
    private String areaname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armyAreaID")
    private Collection<NationalId> nationalIdCollection;

    public ArmyArea() {
    }

    public ArmyArea(Integer id) {
        this.id = id;
    }

    public ArmyArea(Integer id, String areaname) {
        this.id = id;
        this.areaname = areaname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    @XmlTransient
    public Collection<NationalId> getNationalIdCollection() {
        return nationalIdCollection;
    }

    public void setNationalIdCollection(Collection<NationalId> nationalIdCollection) {
        this.nationalIdCollection = nationalIdCollection;
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
        if (!(object instanceof ArmyArea)) {
            return false;
        }
        ArmyArea other = (ArmyArea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ArmyArea[ id=" + id + " ]";
    }
    
}
