/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Classe métier "COMPETENCES
 *
 * @author pierre chanussot
 */

@Entity(name = "Competence")
@Table(name = "competences")
public class Competence implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_competence")
    private Integer idCompetence;
    
    @Column(name = "intitule_competence")
    private String intituleCompetence;

    public Integer getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getIntituleCompetence() {
        return intituleCompetence;
    }

    public void setIntituleCompetence(String intituleCompetence) {
        this.intituleCompetence = intituleCompetence;
    }

    
    
    
     
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetence != null ? idCompetence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.idCompetence == null && other.getIdCompetence() != null) || (this.idCompetence != null && !this.idCompetence.equals(other.getIdCompetence()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Competences[ idCompetence=" + idCompetence + " ]";
    }
    
}
