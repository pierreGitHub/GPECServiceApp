/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Competence;
import cnam.gpec.business.Evaluation;
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
public class EvaluationDAO {

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
     * Récupère un objet Evaluation à partir de son identifiant
     *
     *
     * @param id
     * @return competenceFind
     */
    public Evaluation getEvaluation(Integer id) {

        Evaluation evaluationFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select e from Evaluation as e");
         //  List<Competence> competencesList = query.getResultList();
         
            evaluationFind = em.find(Evaluation.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getEvaluation with id=" + evaluationFind.getIdEvaluation());
            
            
            return (evaluationFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
