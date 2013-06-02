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
 * Classe métier "DOMAINE"
 *
 * @author pierre chanussot
 */
@Entity(name = "Savoir")
@Table(name = "SAVOIR")
public class Savoir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_savoir")
    private Integer idSavoir;
    @Column(name = "intitule_savoir_lb")
    private String intituleSavoirLb;
    @Column(name = "description_savoir_lb")
    private String descriptionSavoirLb;

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
