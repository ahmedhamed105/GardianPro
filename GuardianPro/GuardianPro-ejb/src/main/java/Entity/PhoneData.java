/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "phone_data", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneData.findAll", query = "SELECT p FROM PhoneData p")
    , @NamedQuery(name = "PhoneData.findById", query = "SELECT p FROM PhoneData p WHERE p.id = :id")
    , @NamedQuery(name = "PhoneData.findByTelephone", query = "SELECT p FROM PhoneData p WHERE p.telephone = :telephone")})
public class PhoneData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telephone", nullable = false, length = 45)
    private String telephone;
    @JoinColumn(name = "Phone_types_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PhoneTypes phonetypesID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;

    public PhoneData() {
    }

    public PhoneData(Integer id) {
        this.id = id;
    }

    public PhoneData(Integer id, String telephone) {
        this.id = id;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public PhoneTypes getPhonetypesID() {
        return phonetypesID;
    }

    public void setPhonetypesID(PhoneTypes phonetypesID) {
        this.phonetypesID = phonetypesID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
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
        if (!(object instanceof PhoneData)) {
            return false;
        }
        PhoneData other = (PhoneData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PhoneData[ id=" + id + " ]";
    }
    
}
