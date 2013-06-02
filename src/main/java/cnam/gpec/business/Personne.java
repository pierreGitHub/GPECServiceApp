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
 * Classe métier "PERSONNE"
 *
 * @author pierre chanussot
 */
@Entity(name = "Personne")
@Table(name = "PERSONNE")
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_personne")
    private Integer idPersonne;
    @Column(name = "nom_lb")
    private String nomLb;
    @Column(name = "nom_naissance_lb")
    private String nomNaissanceLb;
    @Column(name = "prenom_lb")
    private String prenomLb;
    @Column(name = "id_epicea")
    private String idEpicea;
    @Column(name = "estAdmin")
    private boolean estAdmin;
    
    @ManyToOne
    @JoinColumn(name = "id_compte_acces")
    private CompteAcces compteAcces;

    public CompteAcces getCompteAcces() {
        return compteAcces;
    }

    public void setCompteAcces(CompteAcces compteAcces) {
        this.compteAcces = compteAcces;
    }

    
    
    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomLb() {
        return nomLb;
    }

    public void setNomLb(String nomLb) {
        this.nomLb = nomLb;
    }

    public String getNomNaissanceLb() {
        return nomNaissanceLb;
    }

    public void setNomNaissanceLb(String nomNaissanceLb) {
        this.nomNaissanceLb = nomNaissanceLb;
    }

    public String getPrenomLb() {
        return prenomLb;
    }

    public void setPrenomLb(String prenomLb) {
        this.prenomLb = prenomLb;
    }

    public String getIdEpicea() {
        return idEpicea;
    }

    public void setIdEpicea(String idEpicea) {
        this.idEpicea = idEpicea;
    }

    public boolean isEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(boolean estAdmin) {
        this.estAdmin = estAdmin;
    }
    
       
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.getIdPersonne()!= null) || (this.idPersonne != null && !this.idPersonne.equals(other.getIdPersonne()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Personne[ idPersonne=" + idPersonne + " ]";
    }
}
