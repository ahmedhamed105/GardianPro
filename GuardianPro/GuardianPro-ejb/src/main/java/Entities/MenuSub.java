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
@Table(name = "menu_sub", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuSub.findAll", query = "SELECT m FROM MenuSub m"),
    @NamedQuery(name = "MenuSub.findById", query = "SELECT m FROM MenuSub m WHERE m.id = :id"),
    @NamedQuery(name = "MenuSub.findByMenu", query = "SELECT m FROM MenuSub m WHERE m.menuID = :id"),
    @NamedQuery(name = "MenuSub.findByName", query = "SELECT m FROM MenuSub m WHERE m.name = :name"),
    @NamedQuery(name = "MenuSub.findByLink", query = "SELECT m FROM MenuSub m WHERE m.link = :link")})
public class MenuSub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Link", nullable = false, length = 45)
    private String link;
    @JoinColumn(name = "Menu_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Menu menuID;

    public MenuSub() {
    }

    public MenuSub(Integer id) {
        this.id = id;
    }

    public MenuSub(Integer id, String name, String link) {
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Menu getMenuID() {
        return menuID;
    }

    public void setMenuID(Menu menuID) {
        this.menuID = menuID;
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
        if (!(object instanceof MenuSub)) {
            return false;
        }
        MenuSub other = (MenuSub) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MenuSub[ id=" + id + " ]";
    }
    
}
