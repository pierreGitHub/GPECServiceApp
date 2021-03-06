/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * Classe métier "METHODE"
 *
 * @author pierre chanussot
 */
@Entity(name = "Methode")
@Table(name = "METHODE")
public class Methode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "methode_id_methode_seq")
    @SequenceGenerator(name = "methode_id_methode_seq",sequenceName = "methode_id_methode_seq",allocationSize=1) 
    @Column(name = "id_methode")
    private Integer idMethode;
    @Column(name = "intitule_methode_lb")
    private String intituleMethodeLb;
    @Column(name = "description_methode_lb")
    private String descriptionMethodeLb;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_competence")
    private Competence competence;
    
    
    public Integer getIdMethode() {
        return idMethode;
    }

    public void setIdMethode(Integer idMethode) {
        this.idMethode = idMethode;
    }

    public String getIntituleMethodeLb() {
        return intituleMethodeLb;
    }

    public void setIntituleMethodeLb(String intituleMethodeLb) {
        this.intituleMethodeLb = intituleMethodeLb;
    }

    @XmlTransient
    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
    
    

    public String getDescriptionMethodeLb() {
        return descriptionMethodeLb;
    }

    public void setDescriptionMethodeLb(String descriptionMethodeLb) {
        this.descriptionMethodeLb = descriptionMethodeLb;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMethode != null ? idMethode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Methode)) {
            return false;
        }
        Methode other = (Methode) object;
        if ((this.idMethode == null && other.getIdMethode() != null) || (this.idMethode != null && !this.idMethode.equals(other.getIdMethode()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Methode[ idMethode=" + idMethode + " ]";
    }
}
