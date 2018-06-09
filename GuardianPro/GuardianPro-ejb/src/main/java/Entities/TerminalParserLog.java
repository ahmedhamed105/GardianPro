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
 * @author mohammed.ayad
 */
@Entity
@Table(name = "terminal_parser_log",catalog = "guardianpro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerminalParserLog.findAll", query = "SELECT t FROM TerminalParserLog t")
    , @NamedQuery(name = "TerminalParserLog.findById", query = "SELECT t FROM TerminalParserLog t WHERE t.id = :id")
    , @NamedQuery(name = "TerminalParserLog.findByTid", query = "SELECT t FROM TerminalParserLog t WHERE t.tid = :tid")
    , @NamedQuery(name = "TerminalParserLog.findByDt", query = "SELECT t FROM TerminalParserLog t WHERE t.dt = :dt")
    , @NamedQuery(name = "TerminalParserLog.findByVer", query = "SELECT t FROM TerminalParserLog t WHERE t.ver = :ver")
    , @NamedQuery(name = "TerminalParserLog.findByMode", query = "SELECT t FROM TerminalParserLog t WHERE t.mode = :mode")
    , @NamedQuery(name = "TerminalParserLog.findByErr", query = "SELECT t FROM TerminalParserLog t WHERE t.err = :err")})
public class TerminalParserLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TID")
    private String tid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DT")
    private String dt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "VER")
    private String ver;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MODE")
    private String mode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ERR")
    private String err;
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userId;

    public TerminalParserLog() {
    }

    public TerminalParserLog(Integer id) {
        this.id = id;
    }

    public TerminalParserLog(Integer id, String tid, String dt, String ver, String mode, String err) {
        this.id = id;
        this.tid = tid;
        this.dt = dt;
        this.ver = ver;
        this.mode = mode;
        this.err = err;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof TerminalParserLog)) {
            return false;
        }
        TerminalParserLog other = (TerminalParserLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.TerminalParserLog[ id=" + id + " ]";
    }
    
}
