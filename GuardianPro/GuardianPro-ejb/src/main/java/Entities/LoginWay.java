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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "login_way", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginWay.findAll", query = "SELECT l FROM LoginWay l"),
    @NamedQuery(name = "LoginWay.findById", query = "SELECT l FROM LoginWay l WHERE l.id = :id"),
    @NamedQuery(name = "LoginWay.findByLgway", query = "SELECT l FROM LoginWay l WHERE l.lgway = :lgway"),
    @NamedQuery(name = "LoginWay.findByCreateDate", query = "SELECT l FROM LoginWay l WHERE l.createDate = :createDate"),
    @NamedQuery(name = "LoginWay.findByUpdateDate", query = "SELECT l FROM LoginWay l WHERE l.updateDate = :updateDate")})
public class LoginWay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 45)
    @Column(name = "Lg_way", length = 45)
    private String lgway;
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
    @JoinColumn(name = "Login_type_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private LoginType logintypeID;
    @JoinColumn(name = "User_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userID;

    public LoginWay() {
    }

    public LoginWay(Integer id) {
        this.id = id;
    }

    public LoginWay(Integer id, Date createDate, Date updateDate) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLgway() {
        return lgway;
    }

    public void setLgway(String lgway) {
        this.lgway = lgway;
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

    public LoginType getLogintypeID() {
        return logintypeID;
    }

    public void setLogintypeID(LoginType logintypeID) {
        this.logintypeID = logintypeID;
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
        if (!(object instanceof LoginWay)) {
            return false;
        }
        LoginWay other = (LoginWay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.LoginWay[ id=" + id + " ]";
    }
    
}
