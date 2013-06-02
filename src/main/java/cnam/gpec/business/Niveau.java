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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Classe métier "Niveau"
 *
 * @author pierre chanussot
 */
@Entity(name = "Niveau")
@Table(name = "NIVEAU")
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_niveau")
    private Integer idNiveau;
    @Column(name = "intitule_niveau_lb")
    private String intituleNiveauLb;
    @Column(name = "description_savoir_lb")
    private String descriptionSavoirLb;

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getIntituleNiveauLb() {
        return intituleNiveauLb;
    }

    public void setIntituleNiveauLb(String intituleNiveauLb) {
        this.intituleNiveauLb = intituleNiveauLb;
    }

    public String getDescriptionSavoirLb() {
        return descriptionSavoirLb;
    }

    public void setDescriptionSavoirLb(String descriptionSavoirLb) {
        this.descriptionSavoirLb = descriptionSavoirLb;
    }

    

   
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNiveau != null ? idNiveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.idNiveau == null && other.getIdNiveau()!= null) || (this.idNiveau != null && !this.idNiveau.equals(other.getIdNiveau()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Niveau[ idNiveau=" + idNiveau + " ]";
    }
}
