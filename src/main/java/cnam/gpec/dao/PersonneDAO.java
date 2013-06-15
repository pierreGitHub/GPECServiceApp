/*
 * Gpec Cnam - Projet NFE114
 * Partie web Service
 */
package cnam.gpec.dao;

import cnam.gpec.business.Personne;
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
public class PersonneDAO {

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
     * Récupère un objet Personne à partir de son identifiant
     *
     *
     * @param id
     * @return personneFind
     */
    public Personne getPersonne(Integer id) {

        Personne personneFind = null;
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            
           Query query = em.createQuery("select p from Personne as p");
         //  List<Competence> competencesList = query.getResultList();
           
           //competenceFind = competencesList.get(1);
            personneFind = em.find(Personne.class,id.intValue());
            em.getTransaction().commit();
            System.out.println("getPersonne with id=" + personneFind.getIdPersonne());
            
            
            return (personneFind);
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void persist(Personne personne) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            //em.merge(metier);
            em.persist(personne);
            em.getTransaction().commit();
            System.out.println("getPersonne with id=" + personne.getIdPersonne());
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void merge(Personne personne) {
        
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            // utilisation de l'EntityManager
            em.merge(personne);
            //em.persist(metier);
            em.getTransaction().commit();
            System.out.println("getPersonne with id=" + personne.getIdPersonne());
            
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
