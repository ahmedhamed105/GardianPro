/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ahmed.ibraheem
 */
@Entity
@Table(name = "national_id", catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NationalId.findAll", query = "SELECT n FROM NationalId n")
    , @NamedQuery(name = "NationalId.findById", query = "SELECT n FROM NationalId n WHERE n.id = :id")
    , @NamedQuery(name = "NationalId.findByNamtionalID", query = "SELECT n FROM NationalId n WHERE n.namtionalID = :namtionalID")
    , @NamedQuery(name = "NationalId.findByFrontimage", query = "SELECT n FROM NationalId n WHERE n.frontimage = :frontimage")
    , @NamedQuery(name = "NationalId.findByBackImage", query = "SELECT n FROM NationalId n WHERE n.backImage = :backImage")
    , @NamedQuery(name = "NationalId.findByDateIssue", query = "SELECT n FROM NationalId n WHERE n.dateIssue = :dateIssue")
    , @NamedQuery(name = "NationalId.findByPlaceIssue", query = "SELECT n FROM NationalId n WHERE n.placeIssue = :placeIssue")})
public class NationalId implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Namtional_ID", nullable = false, length = 45)
    private String namtionalID;
    @Size(max = 45)
    @Column(name = "Front_image", length = 45)
    private String frontimage;
    @Size(max = 45)
    @Column(name = "back_image", length = 45)
    private String backImage;
    @Column(name = "date_issue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIssue;
    @Size(max = 45)
    @Column(name = "place_Issue", length = 45)
    private String placeIssue;
    @JoinColumn(name = "Army_Area_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private ArmyArea armyAreaID;
    @JoinColumn(name = "Military_status_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private MilitaryStatus militarystatusID;
    @JoinColumn(name = "religion_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Religion religionID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nationalId")
    private Collection<NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nationalIDID")
    private Collection<User> userCollection;

    public NationalId() {
    }

    public NationalId(Integer id) {
        this.id = id;
    }

    public NationalId(Integer id, String namtionalID) {
        this.id = id;
        this.namtionalID = namtionalID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamtionalID() {
        return namtionalID;
    }

    public void setNamtionalID(String namtionalID) {
        this.namtionalID = namtionalID;
    }

    public String getFrontimage() {
        return frontimage;
    }

    public void setFrontimage(String frontimage) {
        this.frontimage = frontimage;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getPlaceIssue() {
        return placeIssue;
    }

    public void setPlaceIssue(String placeIssue) {
        this.placeIssue = placeIssue;
    }

    public ArmyArea getArmyAreaID() {
        return armyAreaID;
    }

    public void setArmyAreaID(ArmyArea armyAreaID) {
        this.armyAreaID = armyAreaID;
    }

    public MilitaryStatus getMilitarystatusID() {
        return militarystatusID;
    }

    public void setMilitarystatusID(MilitaryStatus militarystatusID) {
        this.militarystatusID = militarystatusID;
    }

    public Religion getReligionID() {
        return religionID;
    }

    public void setReligionID(Religion religionID) {
        this.religionID = religionID;
    }

    @XmlTransient
    public Collection<NationalIdHasMaritalStatus> getNationalIdHasMaritalStatusCollection() {
        return nationalIdHasMaritalStatusCollection;
    }

    public void setNationalIdHasMaritalStatusCollection(Collection<NationalIdHasMaritalStatus> nationalIdHasMaritalStatusCollection) {
        this.nationalIdHasMaritalStatusCollection = nationalIdHasMaritalStatusCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
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
        if (!(object instanceof NationalId)) {
            return false;
        }
        NationalId other = (NationalId) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.NationalId[ id=" + id + " ]";
    }
    
}
