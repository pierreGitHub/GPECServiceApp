/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business.auth;

import cnam.gpec.business.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Classe métier "COMPTE_ACCES"
 *
 * @author pierre chanussot
 */
@Entity(name = "CompteAcces")
@Table(name = "COMPTE_ACCES")
public class CompteAcces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "compte_acces_id_compte_acces_seq")
    @SequenceGenerator(name = "compte_acces_id_compte_acces_seq",sequenceName = "compte_acces_id_compte_acces_seq",allocationSize=1) 
    @Column(name = "id_compte_acces")
    private Integer idCompteAcces;
    @Column(name = "date_creation_dt")
    @Temporal(TemporalType.DATE)
    private Date dateCreationDt;
    @Column(name = "date_modification_dt")
    @Temporal(TemporalType.DATE)
    private Date dateModificationDt;
    @Column(name = "date_expiration_dt")
    @Temporal(TemporalType.DATE)
    private Date dateExpirationDt;
    @Column(name = "password")
    private String password;
    @Column(name = "login")
    private String login;
    
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
    
    @OneToOne
    @JoinColumn(name = "id_compte_acces",insertable = false,updatable = false)
    private Personne personne;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    
    

    public Integer getIdCompteAcces() {
        return idCompteAcces;
    }

    public void setIdCompteAcces(Integer idCompteAcces) {
        this.idCompteAcces = idCompteAcces;
    }

    public Date getDateCreationDt() {
        return dateCreationDt;
    }

    public void setDateCreationDt(Date dateCreationDt) {
        this.dateCreationDt = dateCreationDt;
    }

    public Date getDateModificationDt() {
        return dateModificationDt;
    }

    public void setDateModificationDt(Date dateModificationDt) {
        this.dateModificationDt = dateModificationDt;
    }

    public Date getDateExpirationDt() {
        return dateExpirationDt;
    }

    public void setDateExpirationDt(Date dateExpirationDt) {
        this.dateExpirationDt = dateExpirationDt;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompteAcces != null ? idCompteAcces.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteAcces)) {
            return false;
        }
        CompteAcces other = (CompteAcces) object;
        if ((this.idCompteAcces == null && other.getIdCompteAcces()!= null) || (this.idCompteAcces != null && !this.idCompteAcces.equals(other.getIdCompteAcces()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.CompteAcces[ idCompteAcces=" + idCompteAcces + " ]";
    }
}
