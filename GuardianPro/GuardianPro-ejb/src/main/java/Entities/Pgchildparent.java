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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "pgchildparent", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pgchildparent.findAll", query = "SELECT p FROM Pgchildparent p"),
    @NamedQuery(name = "Pgchildparent.findById", query = "SELECT p FROM Pgchildparent p WHERE p.id = :id"),
    @NamedQuery(name = "Pgchildparent.findByRoot", query = "SELECT p FROM Pgchildparent p WHERE p.root = :root"),
    @NamedQuery(name = "Pgchildparent.findByChildNo", query = "SELECT p FROM Pgchildparent p WHERE p.childNo = :childNo")})
public class Pgchildparent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "root")
    private Integer root;
    @Column(name = "child_no")
    private Integer childNo;
    @JoinColumn(name = "Tgroup_has_parameter_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TgroupHasParameter tgrouphasparameterID;
    @JoinColumn(name = "Tgroup_has_parameter_ID1", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TgroupHasParameter tgrouphasparameterID1;

    public Pgchildparent() {
    }

    public Pgchildparent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Integer getChildNo() {
        return childNo;
    }

    public void setChildNo(Integer childNo) {
        this.childNo = childNo;
    }

    public TgroupHasParameter getTgrouphasparameterID() {
        return tgrouphasparameterID;
    }

    public void setTgrouphasparameterID(TgroupHasParameter tgrouphasparameterID) {
        this.tgrouphasparameterID = tgrouphasparameterID;
    }

    public TgroupHasParameter getTgrouphasparameterID1() {
        return tgrouphasparameterID1;
    }

    public void setTgrouphasparameterID1(TgroupHasParameter tgrouphasparameterID1) {
        this.tgrouphasparameterID1 = tgrouphasparameterID1;
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
        if (!(object instanceof Pgchildparent)) {
            return false;
        }
        Pgchildparent other = (Pgchildparent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Pgchildparent[ id=" + id + " ]";
    }
    
}
