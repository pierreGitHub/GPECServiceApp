/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Methode;
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
public class MethodeDAO {

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
     * Récupère un objet Methode à partir de son identifiant
     *
     *
     * @param id
     * @return metierFind
     */
    public Methode getMethode(Integer id) {

        Methode methodeFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select m from Methode as m");
         //  List<Competence> competencesList = query.getResultList();
           
            System.out.println("tet");
           //competenceFind = competencesList.get(1);
            methodeFind = em.find(Methode.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getMethode with id=" + methodeFind.getIdMethode());
            
            
            return (methodeFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
