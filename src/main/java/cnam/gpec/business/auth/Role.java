/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business.auth;

import cnam.gpec.business.*;
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
 * Classe métier "ROLE"
 *
 * @author pierre chanussot
 */
@Entity(name = "Role")
@Table(name = "ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_role")
    private Integer idRole;
    @Column(name = "intitule_role_lb")
    private String intituleRoleLb;

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }


    public String getIntituleRoleLb() {
        return intituleRoleLb;
    }

    public void setIntituleRoleLb(String intituleRoleLb) {
        this.intituleRoleLb = intituleRoleLb;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idRole == null && other.getIdRole()!= null) || (this.idRole != null && !this.idRole.equals(other.getIdRole()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Role[ idRole=" + idRole + " ]";
    }
}
