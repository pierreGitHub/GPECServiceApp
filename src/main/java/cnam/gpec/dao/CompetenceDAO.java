/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Competence;
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
public class CompetenceDAO {

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
     * Récupère un objet Compétence à partir de son identifiant
     *
     *
     * @param id
     * @return competenceFind
     */
    public Competence getCompetence(Integer id) {

        Competence competenceFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select c from Competence as c");
         //  List<Competence> competencesList = query.getResultList();
           
            System.out.println("tet");
           //competenceFind = competencesList.get(1);
            competenceFind = em.find(Competence.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getCompetence with id=" + competenceFind.getIdCompetence());
            
            
            return (competenceFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
