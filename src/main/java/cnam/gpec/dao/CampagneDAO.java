/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Campagne;
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
        factory = Persistence.createEntityManagerFactory("baseTest");
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
    public Campagne getCamapgne(Integer id) {

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
}
