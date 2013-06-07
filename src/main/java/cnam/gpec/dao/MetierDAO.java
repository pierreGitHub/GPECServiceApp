/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Metier;
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
public class MetierDAO {

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
     * Récupère un objet Metier à partir de son identifiant
     *
     *
     * @param id
     * @return competenceFind
     */
    public Metier getMetier(Integer id) {

        Metier metierFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select m from Metier as m");
         //  List<Competence> competencesList = query.getResultList();
           
            System.out.println("tet");
           //competenceFind = competencesList.get(1);
            metierFind = em.find(Metier.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getMetier with id=" + metierFind.getIdMetier());
            
            
            return (metierFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
