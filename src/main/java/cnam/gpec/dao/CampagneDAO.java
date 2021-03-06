/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Campagne;
import cnam.gpec.business.Evaluation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Classe DAO interagissant avec la BDD
 *
 * @author pierre Chanussot
 */
public class CampagneDAO {

    private EntityManagerFactory factory = null;

    public void init() {
        factory = Persistence.createEntityManagerFactory("gpec");
    }

    public void close() {
        if (factory != null) {
            factory.close();
        }
    }

    /**
     *
     * Récupère un objet Campagne à partir de son identifiant
     *
     *
     * @param id
     * @return campagneFind
     */
    public Campagne getCampagne(Integer id) {

        Campagne campagneFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select c from Campagne as c");
         //  List<Competence> competencesList = query.getResultList();
           
            System.out.println("tet");
           //competenceFind = competencesList.get(1);
            campagneFind = em.find(Campagne.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getCampagne with id=" + campagneFind.getIdCampagne());
            
            
            return campagneFind;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * Récupère la liste des campagnes en COURS pour un référent
     *
     *
     * @param id
     * @return campagneFind
     */
    public List<Campagne> getCampagneListENCOURSProfilReferent(Integer id) {
        List<Campagne> campagneListFind = null;
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select c from Campagne as c where c.estReferent.idPersonne = :id and c.verrouillerCampagne=FALSE").setParameter("id", id);
           campagneListFind = query.getResultList();
          
            em.getTransaction().commit();
          
            return campagneListFind;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
        
        
    }
    
    /**
     *
     * Récupère la liste des campagnes en COURS pour un référent
     *
     *
     * @param id
     * @return campagneFind
     */
    public List<Campagne> getCampagneListENCOURSProfilAutre(Integer id) {
        List<Campagne> campagneListFind = null;
         List<Evaluation> evaluationListFind = null;
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select e from Evaluation as e where e.personne.idPersonne = :id").setParameter("id", id);
           evaluationListFind = query.getResultList();
           List<Integer> inValues = new ArrayList<Integer>();
           
            for (Evaluation evaluation : evaluationListFind) {
                
                inValues.add(evaluation.getCampagne().getIdCampagne()); 
                
            }
           
           
            Query queryCampagne = em.createQuery("select c from Campagne as c where c.idCampagne IN :id and c.verrouillerCampagne=FALSE").setParameter("id", inValues);
           campagneListFind = queryCampagne.getResultList();
           
           
          
            em.getTransaction().commit();
          
            return campagneListFind;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
                     
        
    }
    
    
     /**
     *
     * Récupère la liste des campagnes TERMINEE à id du compte d'accès
     *
     *
     * @param id
     * @return campagneFind
     */
    public List<Campagne> getCampagneListTERMINEEProfilReferent(Integer id) {
        List<Campagne> campagneListFind = null;
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select c from Campagne as c where c.estReferent.idPersonne = :id and c.verrouillerCampagne=TRUE").setParameter("id", id);
           campagneListFind = query.getResultList();
          
            em.getTransaction().commit();
          
            return campagneListFind;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
        
        
    }
    
    /**
     *
     * Récupère la liste des campagnes en COURS pour un référent
     *
     *
     * @param id
     * @return campagneFind
     */
    public List<Campagne> getCampagneListTERMINEEProfilAutre(Integer id) {
        List<Campagne> campagneListFind = null;
         List<Evaluation> evaluationListFind = null;
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select e from Evaluation as e where e.personne.idPersonne = :id").setParameter("id", id);
           evaluationListFind = query.getResultList();
           List<Integer> inValues = new ArrayList<Integer>();
           
            for (Evaluation evaluation : evaluationListFind) {
                
                inValues.add(evaluation.getCampagne().getIdCampagne()); 
                
            }
           
           
            Query queryCampagne = em.createQuery("select c from Campagne as c where c.idCampagne IN :id and c.verrouillerCampagne=TRUE").setParameter("id", inValues);
           campagneListFind = queryCampagne.getResultList();
           
           
          
            em.getTransaction().commit();
          
            return campagneListFind;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
                     
        
    }
    
    public void persist(Campagne campagne) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(campagne);
            em.getTransaction().commit();
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void merge(Campagne campagne) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            em.merge(campagne);
            em.getTransaction().commit();
           
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
