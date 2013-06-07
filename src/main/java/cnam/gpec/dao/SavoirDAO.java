/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Methode;
import cnam.gpec.business.Savoir;
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
public class SavoirDAO {

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
    public Savoir getSavoir(Integer id) {

        Savoir savoirFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select s from Savoir as s");
         //  List<Competence> competencesList = query.getResultList();
           
            System.out.println("tet");
           //competenceFind = competencesList.get(1);
            savoirFind = em.find(Savoir.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getSavoir with id=" + savoirFind.getIdSavoir());
            
            
            return (savoirFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
