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
@Table(name = "pchildparent", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pchildparent.findAll", query = "SELECT p FROM Pchildparent p"),
    @NamedQuery(name = "Pchildparent.findById", query = "SELECT p FROM Pchildparent p WHERE p.id = :id"),
    @NamedQuery(name = "Pchildparent.findBypara", query = "SELECT p FROM Pchildparent p WHERE p.parametertypeID = :id"),
    @NamedQuery(name = "Pchildparent.findByRoot", query = "SELECT p FROM Pchildparent p WHERE p.root = :root"),
    @NamedQuery(name = "Pchildparent.findByChildNo", query = "SELECT p FROM Pchildparent p WHERE p.childNo = :childNo")})
public class Pchildparent implements Serializable {

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
    @JoinColumn(name = "Parameter_type_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ParameterType parametertypeID;
    @JoinColumn(name = "Parameter_type_ID1", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ParameterType parametertypeID1;

    public Pchildparent() {
    }

    public Pchildparent(Integer id) {
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

    public ParameterType getParametertypeID() {
        return parametertypeID;
    }

    public void setParametertypeID(ParameterType parametertypeID) {
        this.parametertypeID = parametertypeID;
    }

    public ParameterType getParametertypeID1() {
        return parametertypeID1;
    }

    public void setParametertypeID1(ParameterType parametertypeID1) {
        this.parametertypeID1 = parametertypeID1;
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
        if (!(object instanceof Pchildparent)) {
            return false;
        }
        Pchildparent other = (Pchildparent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Pchildparent[ id=" + id + " ]";
    }
    
}
