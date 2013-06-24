/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * Classe métier "CAMPAGNE" test
 *
 * @author pierre chanussot
 */
@Entity(name = "Campagne")
@Table(name = "CAMPAGNE")
public class Campagne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "campagne_id_campagne_seq")
    @SequenceGenerator(name = "campagne_id_campagne_seq",sequenceName = "campagne_id_campagne_seq",allocationSize=1) 
    @Column(name = "id_campagne")
    private Integer idCampagne;
    @Column(name = "intitule_campagne_lb")
    private String intituleCampagneLb;
    @Column(name = "description_campagne_lb")
    private String descriptionCampagneLb;
    @Column(name = "date_debut_campagne_dt")
    @Temporal(TemporalType.DATE)
    private Date dateDebutCampagneDt;
    @Column(name = "date_fin_campagne_dt")
    @Temporal(TemporalType.DATE)
    private Date dateFinCampagneDt;
    @Column(name = "verrouiller_campagne")
    private boolean verrouillerCampagne;
    
    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Personne estReferent;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name="id_campagne"),@JoinColumn(name="id_centre")})
    private List<CampagneCentre> campagneCentre ;
    

    public Personne getEstReferent() {
        return estReferent;
    }

    public void setEstReferent(Personne estReferent) {
        this.estReferent = estReferent;
    }

    
    
    public Integer getIdCampagne() {
        return idCampagne;
    }

    public void setIdCampagne(Integer idCampagne) {
        this.idCampagne = idCampagne;
    }

    public String getIntituleCampagneLb() {
        return intituleCampagneLb;
    }

    public void setIntituleCampagneLb(String intituleCampagneLb) {
        this.intituleCampagneLb = intituleCampagneLb;
    }

    public String getDescriptionCampagneLb() {
        return descriptionCampagneLb;
    }

    public void setDescriptionCampagneLb(String descriptionCampagneLb) {
        this.descriptionCampagneLb = descriptionCampagneLb;
    }

    public Date getDateDebutCampagneDt() {
        return dateDebutCampagneDt;
    }

    public void setDateDebutCampagneDt(Date dateDebutCampagneDt) {
        this.dateDebutCampagneDt = dateDebutCampagneDt;
    }

    public Date getDateFinCampagneDt() {
        return dateFinCampagneDt;
    }

    public void setDateFinCampagneDt(Date dateFinCampagneDt) {
        this.dateFinCampagneDt = dateFinCampagneDt;
    }

    public boolean isVerrouillerCampagne() {
        return verrouillerCampagne;
    }

    public void setVerrouillerCampagne(boolean verrouillerCampagne) {
        this.verrouillerCampagne = verrouillerCampagne;
    }

    public List<CampagneCentre> getCampagneCentre() {
        return campagneCentre;
    }

    public void setCampagneCentre(List<CampagneCentre> campagneCentre) {
        this.campagneCentre = campagneCentre;
    }

    
    
    
   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampagne != null ? idCampagne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campagne)) {
            return false;
        }
        Campagne other = (Campagne) object;
        if ((this.idCampagne == null && other.getIdCampagne()!= null) || (this.idCampagne != null && !this.idCampagne.equals(other.getIdCampagne()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cnam.gpec.business.Campagne[ idCampagne=" + idCampagne + " ]";
    }
}
