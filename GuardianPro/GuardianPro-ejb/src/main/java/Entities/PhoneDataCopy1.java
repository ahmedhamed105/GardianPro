/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmed.elemam
 */
@Entity
@Table(name = "phone_data_copy1", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneDataCopy1.findAll", query = "SELECT p FROM PhoneDataCopy1 p"),
    @NamedQuery(name = "PhoneDataCopy1.findById", query = "SELECT p FROM PhoneDataCopy1 p WHERE p.id = :id"),
    @NamedQuery(name = "PhoneDataCopy1.findByTelephone", query = "SELECT p FROM PhoneDataCopy1 p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "PhoneDataCopy1.findByCreateDate", query = "SELECT p FROM PhoneDataCopy1 p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "PhoneDataCopy1.findByUpdateDate", query = "SELECT p FROM PhoneDataCopy1 p WHERE p.updateDate = :updateDate")})
public class PhoneDataCopy1 implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "Phone_types_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PhoneTypes phonetypesID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;

    public PhoneDataCopy1() {
    }

    public PhoneDataCopy1(Integer id) {
        this.id = id;
    }

    public PhoneDataCopy1(Integer id, String telephone, Date createDate, Date updateDate) {
        this.id = id;
        this.telephone = telephone;
        this.createDate = createDate;
        this.updateDate = updateDate;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        if (!(object instanceof PhoneDataCopy1)) {
            return false;
        }
        PhoneDataCopy1 other = (PhoneDataCopy1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.PhoneDataCopy1[ id=" + id + " ]";
    }
    
}
