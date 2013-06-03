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
 * Classe métier "EVAL_COMP_NIV"
 *
 * @author pierre chanussot
 */
@Entity(name = "EvalCompNiv")
@Table(name = "Eval_Comp_Niv")
public class EvalCompNiv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_evaluation")
    private Evaluation evaluation;
    @Id
    @Column(name = "id_competence")
    private Competence competence;
    
    @Column(name = "id_niveau")
    private Niveau niveau;

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    
     
   
  
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluation.getIdEvaluation()!= null && competence.getIdCompetence()!= null ? evaluation.hashCode() + competence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvalCompNiv)) {
            return false;
        }
        EvalCompNiv other = (EvalCompNiv) object;
        if ((this.evaluation.getIdEvaluation()== null && other.getEvaluation().getIdEvaluation()!= null) || (this.getEvaluation().getIdEvaluation()!= null && !this.getEvaluation().equals(other.getEvaluation()))) {
            return false;
        }
        if ((this.competence.getIdCompetence()== null && other.getCompetence().getIdCompetence()!= null) || (this.getCompetence().getIdCompetence()!= null && !this.getCompetence().equals(other.getCompetence()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.EvalCompNiv[ idEvaluation=" + evaluation.getIdEvaluation()+ ", idCompetence="+competence.getIdCompetence()+" ]";
    }
}
