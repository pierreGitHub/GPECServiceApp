/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * Classe métier "COMPETENCE"
 *
 * @author pierre chanussot
 */
@Entity(name = "Competence")
@Table(name = "COMPETENCE")
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "competence_id_competence_seq")
    @SequenceGenerator(name = "competence_id_competence_seq",sequenceName = "competence_id_competence_seq",allocationSize=1) 
    @Column(name = "id_competence")
    private Integer idCompetence;
    @Column(name = "intitule_competence_lb")
    private String intituleCompetenceLb;
    @Column(name = "description_competence_lb")
    private String descriptionCompetenceLb;
    @Column(name = "date_suppression_competence_lb")
    @Temporal(TemporalType.DATE)
    private Date dateSuppressionCompetenceDt;
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<CompetenceMetier> competencemetier ;
    
   
    @ManyToOne
    @JoinColumn(name = "id_domaine")
    private Domaine domaine;
    

    @OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL, mappedBy="competence")
    private List<Methode> methode ;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "competence")
    private List<Savoir> savoir ;
    
    public Domaine getDomaine() {
       return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public List<Methode> getMethode() {
        return methode;
    }

    public void setMethode(List<Methode> methode) {
        this.methode = methode;
    }

   
    
    
    public List<Savoir> getSavoir() {
        return savoir;
    }

    public void setSavoir(List<Savoir> savoir) {
        this.savoir = savoir;
    }

  


    

    public Integer getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getIntituleCompetenceLb() {
        return intituleCompetenceLb;
    }

    public void setIntituleCompetenceLb(String intituleCompetenceLb) {
        this.intituleCompetenceLb = intituleCompetenceLb;
    }

    public String getDescriptionCompetenceLb() {
        return descriptionCompetenceLb;
    }

    public void setDescriptionCompetenceLb(String descriptionCompetenceLb) {
        this.descriptionCompetenceLb = descriptionCompetenceLb;
    }

    public Date getDateSuppressionCompetenceDt() {
        return dateSuppressionCompetenceDt;
    }

    public void setDateSuppressionCompetenceDt(Date dateSuppressionCompetenceDt) {
        this.dateSuppressionCompetenceDt = dateSuppressionCompetenceDt;
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
