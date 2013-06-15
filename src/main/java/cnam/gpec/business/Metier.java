/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * Classe métier "METIER"
 *
 * @author pierre chanussot
 */
@Entity(name = "Metier")
@Table(name = "METIER")
public class Metier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "metier_id_metier_seq")
    @SequenceGenerator(name = "metier_id_metier_seq",sequenceName = "metier_id_metier_seq",allocationSize=1)  
    @Column(name = "id_metier")
    private Integer idMetier;
    @Column(name = "intitule_metier_lb")
    private String intituleMetierLb;
    @Column(name = "description_metier_lb")
    private String descriptionMetierLb;
    @Column(name = "verrouiller_metier")
    private boolean verrouillerMetier;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "metier")
    @JoinColumns({@JoinColumn(name="id_competence"),@JoinColumn(name="id_metier")})
    private List<CompetenceMetier> competenceMetier ;
    
    
    public Integer getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(Integer idMetier) {
        this.idMetier = idMetier;
    }

    public String getIntituleMetierLb() {
        return intituleMetierLb;
    }

    public void setIntituleMetierLb(String intituleMetierLb) {
        this.intituleMetierLb = intituleMetierLb;
    }

    public String getDescriptionMetierLb() {
        return descriptionMetierLb;
    }

    public void setDescriptionMetierLb(String descriptionMetierLb) {
        this.descriptionMetierLb = descriptionMetierLb;
    }

    public boolean isVerrouillerMetier() {
        return verrouillerMetier;
    }

    public void setVerrouillerMetier(boolean verrouillerMetier) {
        this.verrouillerMetier = verrouillerMetier;
    }

    public List<CompetenceMetier> getCompetenceMetier() {
        return competenceMetier;
    }

    public void setCompetenceMetier(List<CompetenceMetier> competenceMetier) {
        this.competenceMetier = competenceMetier;
    }

   

  
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetier != null ? idMetier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metier)) {
            return false;
        }
        Metier other = (Metier) object;
        if ((this.idMetier == null && other.getIdMetier()!= null) || (this.idMetier != null && !this.idMetier.equals(other.getIdMetier()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Metier[ idMetier=" + idMetier + " ]";
    }
}
