/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * Classe métier "PERSONNE_METIER"
 *
 * @author pierre chanussot
 */
@Entity(name = "PersonneMetier")
@Table(name = "Personne_Metier")
public class PersonneMetier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_metier")
    private Metier metier;
    @Id
    @Column(name = "id_personne")
    private Personne personne;

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
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
        hash += (metier.getIdMetier() != null && personne.getIdPersonne()!= null ? metier.hashCode() + personne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonneMetier)) {
            return false;
        }
        PersonneMetier other = (PersonneMetier) object;
        if ((this.metier.getIdMetier() == null && other.getMetier().getIdMetier()!= null) || (this.getMetier().getIdMetier() != null && !this.getMetier().equals(other.getMetier()))) {
            return false;
        }
        if ((this.personne.getIdPersonne()== null && other.getPersonne().getIdPersonne()!= null) || (this.getPersonne().getIdPersonne()!= null && !this.getPersonne().equals(other.getPersonne()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.PersonneMetier[ idMetier=" + metier.getIdMetier() + ", idPersonne="+personne.getIdPersonne()+" ]";
    }
}
