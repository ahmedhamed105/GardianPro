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
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "login_way", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginWay.findAll", query = "SELECT l FROM LoginWay l")
    , @NamedQuery(name = "LoginWay.findById", query = "SELECT l FROM LoginWay l WHERE l.id = :id")
    , @NamedQuery(name = "LoginWay.findByLgway", query = "SELECT l FROM LoginWay l WHERE l.lgway = :lgway")})
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
        return "Entity.LoginWay[ id=" + id + " ]";
    }
    
}
