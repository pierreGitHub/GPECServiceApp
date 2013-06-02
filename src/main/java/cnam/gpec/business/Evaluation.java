/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import cnam.gpec.business.auth.CompteAcces;
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
 * Classe métier "EVALUATION"
 *
 * @author pierre chanussot
 */
@Entity(name = "Evaluation")
@Table(name = "EVALUATION")
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_evaluation")
    private Integer idEvaluation;
    @Column(name = "date_derniere_modification_dt")
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModificationDt;
    @Column(name = "date_validation_dt")
    @Temporal(TemporalType.DATE)
    private Date dateValidationDt;
    
    @ManyToOne
    @JoinColumn(name = "id_campagne")
    private Campagne campagne;
    
    @ManyToOne
    @JoinColumn(name = "id_metier")
    private Metier metier;
    
    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Personne personne;

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    
    
    
    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    
    
    public Campagne getCampagne() {
        return campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }
    
    public Integer getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Date getDateDerniereModificationDt() {
        return dateDerniereModificationDt;
    }

    public void setDateDerniereModificationDt(Date dateDerniereModificationDt) {
        this.dateDerniereModificationDt = dateDerniereModificationDt;
    }

    public Date getDateValidationDt() {
        return dateValidationDt;
    }

    public void setDateValidationDt(Date dateValidationDt) {
        this.dateValidationDt = dateValidationDt;
    }
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluation != null ? idEvaluation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.idEvaluation == null && other.getIdEvaluation()!= null) || (this.idEvaluation != null && !this.idEvaluation.equals(other.getIdEvaluation()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Metier[ idEvaluation=" + idEvaluation + " ]";
    }
}
