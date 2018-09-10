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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "paramter_default", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParamterDefault.findAll", query = "SELECT p FROM ParamterDefault p")
    , @NamedQuery(name = "ParamterDefault.findById", query = "SELECT p FROM ParamterDefault p WHERE p.id = :id")
         , @NamedQuery(name = "ParamterDefault.findBypara", query = "SELECT p FROM ParamterDefault p WHERE p.parameterID = :id")
    , @NamedQuery(name = "ParamterDefault.findByPvalues", query = "SELECT p FROM ParamterDefault p WHERE p.pvalues = :pvalues")})
public class ParamterDefault implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "P_values", nullable = false, length = 500)
    private String pvalues;
    @JoinColumn(name = "Parameter_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Parameter parameterID;

    public ParamterDefault() {
    }

    public ParamterDefault(Integer id) {
        this.id = id;
    }

    public ParamterDefault(Integer id, String pvalues) {
        this.id = id;
        this.pvalues = pvalues;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPvalues() {
        return pvalues;
    }

    public void setPvalues(String pvalues) {
        this.pvalues = pvalues;
    }

    public Parameter getParameterID() {
        return parameterID;
    }

    public void setParameterID(Parameter parameterID) {
        this.parameterID = parameterID;
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
        if (!(object instanceof ParamterDefault)) {
            return false;
        }
        ParamterDefault other = (ParamterDefault) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ParamterDefault[ id=" + id + " ]";
    }
    
}
