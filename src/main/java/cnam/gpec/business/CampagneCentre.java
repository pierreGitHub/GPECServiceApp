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
 * Classe métier "CAMPAGNE_CENTRE"
 *
 * @author pierre chanussot
 */
@Entity(name = "CampagneCentre")
@Table(name = "Campagne_Centre")
public class CampagneCentre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_centre")
    private Centre centre;
    @Id
    @Column(name = "id_campagne")
    private Campagne campagne;

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Campagne getCampagne() {
        return campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    
   

   
    
  
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (centre.getIdCentre()!= null && campagne.getIdCampagne()!= null ? centre.hashCode() + campagne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampagneCentre)) {
            return false;
        }
        CampagneCentre other = (CampagneCentre) object;
        if ((this.centre.getIdCentre()== null && other.getCentre().getIdCentre()!= null) || (this.getCentre().getIdCentre()!= null && !this.getCentre().equals(other.getCentre()))) {
            return false;
        }
        if ((this.campagne.getIdCampagne()== null && other.getCampagne().getIdCampagne()!= null) || (this.getCampagne().getIdCampagne()!= null && !this.getCampagne().equals(other.getCampagne()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.CampagneCentre[ idCentre=" + centre.getIdCentre()+ ", idCampagne="+campagne.getIdCampagne()+" ]";
    }
}
