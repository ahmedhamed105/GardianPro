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
@Table(name = "pgchild", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pgchild.findAll", query = "SELECT p FROM Pgchild p"),
    @NamedQuery(name = "Pgchild.findById", query = "SELECT p FROM Pgchild p WHERE p.id = :id"),
    @NamedQuery(name = "Pgchild.findByparent", query = "SELECT p FROM Pgchild p WHERE p.tgrouphasGparameterID1 = :id"),
    @NamedQuery(name = "Pgchild.findByRoot", query = "SELECT p FROM Pgchild p WHERE p.root = :root"),
    @NamedQuery(name = "Pgchild.findByChild", query = "SELECT p FROM Pgchild p WHERE p.child = :child")})
public class Pgchild implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "root")
    private Integer root;
    @Column(name = "child")
    private Integer child;
    @JoinColumn(name = "Tgroup_has_Gparameter_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TgroupHasGparameter tgrouphasGparameterID;
    @JoinColumn(name = "Tgroup_has_Gparameter_ID1", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TgroupHasGparameter tgrouphasGparameterID1;

    public Pgchild() {
    }

    public Pgchild(Integer id) {
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

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }

    public TgroupHasGparameter getTgrouphasGparameterID() {
        return tgrouphasGparameterID;
    }

    public void setTgrouphasGparameterID(TgroupHasGparameter tgrouphasGparameterID) {
        this.tgrouphasGparameterID = tgrouphasGparameterID;
    }

    public TgroupHasGparameter getTgrouphasGparameterID1() {
        return tgrouphasGparameterID1;
    }

    public void setTgrouphasGparameterID1(TgroupHasGparameter tgrouphasGparameterID1) {
        this.tgrouphasGparameterID1 = tgrouphasGparameterID1;
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
        if (!(object instanceof Pgchild)) {
            return false;
        }
        Pgchild other = (Pgchild) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Pgchild[ id=" + id + " ]";
    }
    
}
