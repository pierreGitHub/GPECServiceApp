/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Classe métier "PERSONNE_CENTRE"
 *
 * @author pierre chanussot
 */
@Entity(name = "PersonneCentre")
@Table(name = "Personne_Centre")
public class PersonneCentre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_centre")
    private Centre centre;
    @Id
    @Column(name = "id_personne")
    private Personne personne;
    
    @Column(name = "date_arrivee")
    @Temporal(TemporalType.DATE)
    private Date dateArrivee;
    
    @Column(name = "date_depart")
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    
    
    
    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    
    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

   
    
  
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (centre.getIdCentre()!= null && personne.getIdPersonne()!= null ? centre.hashCode() + personne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonneCentre)) {
            return false;
        }
        PersonneCentre other = (PersonneCentre) object;
        if ((this.centre.getIdCentre()== null && other.getCentre().getIdCentre()!= null) || (this.getCentre().getIdCentre()!= null && !this.getCentre().equals(other.getCentre()))) {
            return false;
        }
        if ((this.personne.getIdPersonne()== null && other.getPersonne().getIdPersonne()!= null) || (this.getPersonne().getIdPersonne()!= null && !this.getPersonne().equals(other.getPersonne()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.PersonneCentre[ idCentre=" + centre.getIdCentre()+ ", idPersonne="+personne.getIdPersonne()+" ]";
    }
}
