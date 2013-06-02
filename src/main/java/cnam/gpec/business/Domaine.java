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
@Entity(name = "Domaine")
@Table(name = "DOMAINE")
public class Domaine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_domaine")
    private Integer idDomaine;
    @Column(name = "intitule_domaine_lb")
    private String intituleDomaineLb;

    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    

    public String getIntituleDomaineLb() {
        return intituleDomaineLb;
    }

    public void setIntituleDomaineLb(String intituleDomaineLb) {
        this.intituleDomaineLb = intituleDomaineLb;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomaine != null ? idDomaine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domaine)) {
            return false;
        }
        Domaine other = (Domaine) object;
        if ((this.idDomaine == null && other.getIdDomaine() != null) || (this.idDomaine != null && !this.idDomaine.equals(other.getIdDomaine()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Domaine[ idDomaine=" + idDomaine + " ]";
    }
}
