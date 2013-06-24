/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao.auth;

import cnam.gpec.business.Campagne;
import cnam.gpec.business.Savoir;
import cnam.gpec.business.auth.CompteAcces;
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
public class CompteAccesDAO {

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
     * Récupère un objet Savoir à partir de son identifiant
     *
     *
     * @param idCompteAcces
     * @return savoirFind
     */
    public CompteAcces getCompteAcces(Integer id) {

        CompteAcces compteAccesFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select c from CompteAcces as c");
         //  List<Competence> competencesList = query.getResultList();
           
            System.out.println("tet");
           //competenceFind = competencesList.get(1);
            compteAccesFind = em.find(CompteAcces.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getCompteAcces with id=" + compteAccesFind.getIdCompteAcces());
            
            
            return (compteAccesFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     *
     * Récupère un objet Compte Acces à partir de son identifiant
     *
     *
     * @param id
     * @return savoirFind
     */
    public CompteAcces isRightsAndAuthentificated(CompteAcces compteAcces) {

        CompteAcces compteAccesFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select c from CompteAcces as c").setParameter("login", compteAcces.getLogin()).setParameter("password", compteAcces.getPassword());
         //  List<Competence> competencesList = query.getResultList();
          compteAccesFind = query.getSingleResult();
         
            em.getTransaction().commit();
            System.out.println("getCompteAcces with id=" + compteAccesFind.getIdCompteAcces());
            
            
            return (compteAccesFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public void persist(CompteAcces compteAcces) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(compteAcces);
            em.getTransaction().commit();
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void merge(CompteAcces compteAcces) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            em.merge(compteAcces);
            em.getTransaction().commit();
           
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
