/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * Classe métier "COMPETENCE_METIER"
 *
 * @author pierre chanussot
 */
@Entity(name = "competenceMetier")
@Table(name = "Competence_Metier")
public class CompetenceMetier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_metier")
    private Metier metier;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_competence")
    private Competence competence;

    @XmlTransient
    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
    
        
    
  
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metier.getIdMetier() != null && competence.getIdCompetence() != null ? metier.hashCode() + competence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenceMetier)) {
            return false;
        }
        CompetenceMetier other = (CompetenceMetier) object;
        if ((this.metier.getIdMetier() == null && other.getMetier().getIdMetier()!= null) || (this.getMetier().getIdMetier() != null && !this.getMetier().equals(other.getMetier()))) {
            return false;
        }
        if ((this.competence.getIdCompetence()== null && other.getCompetence().getIdCompetence()!= null) || (this.getCompetence().getIdCompetence()!= null && !this.getCompetence().equals(other.getCompetence()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.CompetenceMetier[ idMetier=" + metier.getIdMetier() + ", idCompetence="+competence.getIdCompetence()+" ]";
    }
}
