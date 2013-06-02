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
 * Classe métier "REGION"
 *
 * @author pierre chanussot
 */
@Entity(name = "Region")
@Table(name = "REGION")
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_region")
    private Integer idRegion;
    @Column(name = "intitule_region_lb")
    private String intituleLongLb;

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }



    public String getIntituleLongLb() {
        return intituleLongLb;
    }

    public void setIntituleLongLb(String intituleLongLb) {
        this.intituleLongLb = intituleLongLb;
    }
 

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegion != null ? idRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idRegion == null && other.getIdRegion()!= null) || (this.idRegion != null && !this.idRegion.equals(other.getIdRegion()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Region[ idRegion=" + idRegion + " ]";
    }
}
