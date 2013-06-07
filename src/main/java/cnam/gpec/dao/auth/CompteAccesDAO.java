/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao.auth;

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
     * @param id
     * @return savoirFind
     */
    public CompteAcces getCompteAcces(CompteAcces compteAcces) {

        CompteAcces compteAccesFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select c from CompteAcces as m");
         //  List<Competence> competencesList = query.getResultList();
           
            System.out.println("tet");
           //competenceFind = competencesList.get(1);
            compteAccesFind = em.find(CompteAcces.class,compteAcces.getIdCompteAcces());
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
}
