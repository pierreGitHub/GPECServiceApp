/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * Classe métier "DOMAINE"
 *
 * @author pierre chanussot
 */
@Entity(name = "Savoir")
@Table(name = "SAVOIR")
public class Savoir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "savoir_id_savoir_seq")
    @SequenceGenerator(name = "savoir_id_savoir_seq",sequenceName = "savoir_id_savoir_seq",allocationSize=1) 
    @Column(name = "id_savoir")
    private Integer idSavoir;
    @Column(name = "intitule_savoir_lb")
    private String intituleSavoirLb;
    @Column(name = "description_savoir_lb")
    private String descriptionSavoirLb;
    
        @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_competence")
    private Competence competence;

    public Integer getIdSavoir() {
        return idSavoir;
    }

    public void setIdSavoir(Integer idSavoir) {
        this.idSavoir = idSavoir;
    }

    public String getIntituleSavoirLb() {
        return intituleSavoirLb;
    }

    public void setIntituleSavoirLb(String intituleSavoirLb) {
        this.intituleSavoirLb = intituleSavoirLb;
    }

    public String getDescriptionSavoirLb() {
        return descriptionSavoirLb;
    }

    public void setDescriptionSavoirLb(String descriptionSavoirLb) {
        this.descriptionSavoirLb = descriptionSavoirLb;
    }

    @XmlTransient
    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
    
    

   
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSavoir != null ? idSavoir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Savoir)) {
            return false;
        }
        Savoir other = (Savoir) object;
        if ((this.idSavoir == null && other.getIdSavoir() != null) || (this.idSavoir != null && !this.idSavoir.equals(other.getIdSavoir()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Savoir[ idSavoir=" + idSavoir + " ]";
    }
}
