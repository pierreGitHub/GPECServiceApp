/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Campagne;
import cnam.gpec.business.Evaluation;
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
    
    /**
     *
     * Récupère la liste des evalautions en COURS à id du compte d'accès
     *
     *
     * @param id
     * @return evaluationFind
     */
    public List<Evaluation> getEvaluationListENCOURS(Integer id) {
        List<Evaluation> evaluationListFind = null;
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select e from Evaluation as e where e.personne.idPersonne = :id and e.dateValidationDt is null").setParameter("id", id);
           evaluationListFind = query.getResultList();
          
            em.getTransaction().commit();
          
            return evaluationListFind;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
        
        
        
        
        
        
        
    }
    
    /**
     *
     * Récupère la liste des evalautions TERMINEE à id du compte d'accès
     *
     *
     * @param id
     * @return evaluationFind
     */
    public List<Evaluation> getEvaluationListTERMINEE(Integer id) {
        List<Evaluation> evaluationListFind = null;
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select e from Evaluation as e where e.personne.idPersonne = :id and e.dateValidationDt is not null").setParameter("id", id);
           evaluationListFind = query.getResultList();
          
            em.getTransaction().commit();
          
            return evaluationListFind;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
        
        
        
        
        
        
        
    }
    
     public void persist(Evaluation evaluation) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(evaluation);
            em.getTransaction().commit();
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void merge(Evaluation evaluation) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            em.merge(evaluation);
            em.getTransaction().commit();
           
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
