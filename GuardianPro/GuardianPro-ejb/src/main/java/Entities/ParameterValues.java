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
@Table(name = "parameter_values", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParameterValues.findAll", query = "SELECT p FROM ParameterValues p"),
    @NamedQuery(name = "ParameterValues.findById", query = "SELECT p FROM ParameterValues p WHERE p.id = :id"),
    @NamedQuery(name = "ParameterValues.findByValue", query = "SELECT p FROM ParameterValues p WHERE p.value = :value")})
public class ParameterValues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 500)
    @Column(name = "Value", length = 500)
    private String value;
    @JoinColumn(name = "Parameter_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Parameter parameterID;
    @JoinColumn(name = "Tgroup_has_Gparameter_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TgroupHasGparameter tgrouphasGparameterID;

    public ParameterValues() {
    }

    public ParameterValues(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Parameter getParameterID() {
        return parameterID;
    }

    public void setParameterID(Parameter parameterID) {
        this.parameterID = parameterID;
    }

    public TgroupHasGparameter getTgrouphasGparameterID() {
        return tgrouphasGparameterID;
    }

    public void setTgrouphasGparameterID(TgroupHasGparameter tgrouphasGparameterID) {
        this.tgrouphasGparameterID = tgrouphasGparameterID;
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
        if (!(object instanceof ParameterValues)) {
            return false;
        }
        ParameterValues other = (ParameterValues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.ParameterValues[ id=" + id + " ]";
    }
    
}
