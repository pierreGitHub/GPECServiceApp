/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Classe métier "CENTRE"
 *
 * @author pierre chanussot
 */
@Entity(name = "Centre")
@Table(name = "CENTRE")
public class Centre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_centre")
    private Integer idCentre;
    @Column(name = "intitule_long_lb")
    private String intituleLongLb;
    @Column(name = "intitule_court_lb")
    private String intituleCourtLb;
    
    @ManyToOne()
    @JoinColumn(name = "id_centre",insertable = false,updatable = false)
    private Centre centrePere;
    
    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

    public Centre getCentrePere() {
        return centrePere;
    }

    public void setCentrePere(Centre centrePere) {
        this.centrePere = centrePere;
    }

    
    
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    
    
    public Integer getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(Integer idCentre) {
        this.idCentre = idCentre;
    }

   

    public String getIntituleLongLb() {
        return intituleLongLb;
    }

    public void setIntituleLongLb(String intituleLongLb) {
        this.intituleLongLb = intituleLongLb;
    }

    public String getIntituleCourtLb() {
        return intituleCourtLb;
    }

    public void setIntituleCourtLb(String intituleCourtLb) {
        this.intituleCourtLb = intituleCourtLb;
    }

   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentre != null ? idCentre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Centre)) {
            return false;
        }
        Centre other = (Centre) object;
        if ((this.idCentre == null && other.getIdCentre()!= null) || (this.idCentre != null && !this.idCentre.equals(other.getIdCentre()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Centre[ idCentre=" + idCentre + " ]";
    }
}
