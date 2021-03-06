/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam.gpec;

import cnam.gpec.business.Campagne;
import cnam.gpec.business.Competence;
import cnam.gpec.business.Evaluation;
import cnam.gpec.business.Methode;
import cnam.gpec.business.Metier;
import cnam.gpec.business.Personne;
import cnam.gpec.business.Savoir;
import cnam.gpec.business.auth.CompteAcces;
import cnam.gpec.dao.CampagneDAO;
import cnam.gpec.dao.CompetenceDAO;
import cnam.gpec.dao.EvaluationDAO;
import cnam.gpec.dao.MethodeDAO;
import cnam.gpec.dao.MetierDAO;
import cnam.gpec.dao.PersonneDAO;
import cnam.gpec.dao.SavoirDAO;
import cnam.gpec.dao.auth.CompteAccesDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * Web service GPEC
 *
 * @author pierre.chanussot
 */
@WebService(serviceName = "GpecService")
@Stateless()
public class GpecService {

    private CompetenceDAO competenceDAO;
    private MetierDAO metierDAO;
    private MethodeDAO methodeDAO;
    private SavoirDAO savoirDAO;
    private CampagneDAO campagneDAO;
    private CompteAccesDAO compteAccesDAO;
    private EvaluationDAO evaluationDAO;
    private PersonneDAO personneDAO;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Test récupération BDD
     */
    @WebMethod(operationName = "getCompetenceTest")
    public String getCompetenceTest(@WebParam(name = "idCompetence") String id) {

        initCompetenceDao();
        Competence competenceFind = competenceDAO.getCompetence(new Integer(id));
        closeCompetenceDao();

        if (competenceFind != null) {
            return competenceFind.getIntituleCompetenceLb();
        } else {
            return "Compétence non trouvée";
        }
    }

    /**
     * Récupérer un métier à partir de son identifiant
     */
    @WebMethod(operationName = "getMetier")
    public Metier getMetier(@WebParam(name = "idMetier") String id) {
        Metier metierFind = null;
        initMetierDao();
        metierFind = metierDAO.getMetier(new Integer(id));
        closeMetierDao();

        return metierFind;

    }

    /**
     * Récupérer un méthode à partir de son identifiant
     */
    @WebMethod(operationName = "getMethode")
    public Methode getMethode(@WebParam(name = "idMethode") String id) {
        Methode methodeFind = null;
        initMethodeDao();
        methodeFind = methodeDAO.getMethode(new Integer(id));
        closeMethodeDao();

        return methodeFind;

    }

    /**
     * Récupérer un savoir à partir de son identifiant
     */
    @WebMethod(operationName = "getSavoir")
    public Savoir getSavoir(@WebParam(name = "idSavoir") String id) {
        Savoir savoirFind = null;
        initSavoirDao();
        savoirFind = savoirDAO.getSavoir(new Integer(id));
        closeSavoirDao();

        return savoirFind;

    }

    /**
     * Récupérer une compétence à partir de son identifiant
     */
    @WebMethod(operationName = "getCompetence")
    public Competence getCompetence(@WebParam(name = "idCompetence") String id) {
        Competence competenceFind = null;
        initCompetenceDao();
        competenceFind = competenceDAO.getCompetence(new Integer(id));
        closeCompetenceDao();

        return competenceFind;

    }

    /**
     * Récupérer une personne à partir de son identifiant
     */
    @WebMethod(operationName = "getPersonne")
    public Personne getPersonne(@WebParam(name = "idPersonne") String id) {
        Personne personneFind = null;
        initPersonneDao();
        personneFind = personneDAO.getPersonne(new Integer(id));
        closePersonneDao();

        return personneFind;

    }

    /**
     * Récupérer une campagne à partir de son identifiant
     */
    @WebMethod(operationName = "getCampagne")
    public Campagne getCampagne(@WebParam(name = "idCampagne") String id) {
        Campagne campagneFind = null;

        initCampagneDao();
        campagneFind = campagneDAO.getCampagne(new Integer(id));
        closeCampagneDao();

        return campagneFind;
    }

    /**
     * Récupérer une evaluation à partir de son identifiant
     */
    @WebMethod(operationName = "getEvaluation")
    public Evaluation getEvaluation(@WebParam(name = "idEvaluation") String id) {
        Evaluation evaluationFind = null;

        initEvaluationDao();
        evaluationFind = evaluationDAO.getEvaluation(new Integer(id));
        closeEvaluationDao();

        return evaluationFind;
    }

    /**
     * Récupérer la liste des campagnes EN COURS pour un compte d'accès donné
     */
    @WebMethod(operationName = "getCampagneListENCOURS")
    public List<Campagne> getCampagneListENCOURS(@WebParam(name = "idCompteAcces") String id) {
        List<Campagne> campagneList = null;

        // Regarde le profil
       
        if (getCompteAcces(id).getRole().getIdRole().equals(3)) {
            initCampagneDao();
            campagneList = campagneDAO.getCampagneListENCOURSProfilReferent(new Integer(id));
            closeCampagneDao();
        } else if (getCompteAcces(id).getRole().getIdRole().equals(4)) {
            initCampagneDao();
            campagneList = campagneDAO.getCampagneListENCOURSProfilAutre(new Integer(id));
            closeCampagneDao();

        } else {
            initCampagneDao();
            campagneList = campagneDAO.getCampagneListENCOURSProfilAutre(new Integer(id));
            closeCampagneDao();

        }
    
        return campagneList;
    }

    /**
     * Récupérer la liste des campagnes TERMINEE pour un compte d'accès donné
     */
    @WebMethod(operationName = "getCampagneListTERMINEE")
    public List<Campagne> getCampagneListTERMINEE(@WebParam(name = "idCompteAcces") String id) {
        List<Campagne> campagneList = null;

        // Regarde le profil
        // Si FORMATEUR
        if (getCompteAcces(id).getRole().getIdRole().equals(4)) {
            initCampagneDao();
            campagneList = campagneDAO.getCampagneListTERMINEEProfilReferent(new Integer(id));
            closeCampagneDao();
        } else {
            initCampagneDao();
            campagneList = campagneDAO.getCampagneListTERMINEEProfilAutre(getCompteAcces(id).getPersonne().getAffectationCentre().getIdCentre());
            closeCampagneDao();

        }



        return campagneList;
    }

    /**
     * Créer/modifier une campagne
     */
    @WebMethod(operationName = "persistCampagne")
    public String persistCampagne(@WebParam(name = "campagne") Campagne campagne) {
        String messageCreate = null;
        String action = null;

        initCampagneDao();
        if (campagne.getIdCampagne() == null) {
            action = "créée.";
            campagneDAO.persist(campagne);
        } else {
            action = "modifiée.";
            campagneDAO.merge(campagne);
        }
        closeCampagneDao();
        messageCreate = "La campagne : " + campagne.getIntituleCampagneLb() + " a été " + action;

        return messageCreate;
    }

    /**
     * Verrouiller une campagne
     */
    @WebMethod(operationName = "verrouillerCampagne")
    public String verrouillerCampagne(@WebParam(name = "campagne") Campagne campagne) {
        String messageCreate = null;
        String action = null;

        // Verrouille la campagne donné en paramètre        
        campagne.setVerrouillerCampagne(true);
        action = "verrouillée.";

        initCampagneDao();
        if (campagne.getIdCampagne() == null) {

            campagneDAO.persist(campagne);
        } else {

            campagneDAO.merge(campagne);
        }
        closeCampagneDao();
        messageCreate = "La campagne : " + campagne.getIntituleCampagneLb() + " a été " + action;

        return messageCreate;
    }

    /**
     * Créer/modifier un métier
     */
    @WebMethod(operationName = "persistMetier")
    public String persistMetier(@WebParam(name = "metier") Metier metier) {
        String messageCreate = null;
        String action = null;

        //TEST 
        metier = new Metier();
        //metier.setIdMetier(6);
        metier.setIntituleMetierLb("Chef de projet");


        initMetierDao();
        if (metier.getIdMetier() == null) {
            action = "créé.";
            metierDAO.persist(metier);
        } else {
            action = "modifié.";
            metierDAO.merge(metier);
        }


        closeMetierDao();
        messageCreate = "Le métier : " + metier.getIntituleMetierLb() + " a été " + action;

        return messageCreate;
    }

    /**
     * Créer/modifier un évaluation
     */
    @WebMethod(operationName = "persistEvaluation")
    public String persistEvaluation(@WebParam(name = "evaluation") Evaluation evaluation) {
        String messageCreate = null;
        String action = null;



        initCampagneDao();
        if (evaluation.getIdEvaluation() == null) {
            action = "créée.";
            evaluationDAO.persist(evaluation);
        } else {
            action = "modifiée.";
            evaluationDAO.merge(evaluation);
        }
        closeCampagneDao();
        messageCreate = "L'évaluation a été " + action;

        return messageCreate;
    }

    /**
     * Créer/modifier une competence
     */
    @WebMethod(operationName = "persistCompetence")
    public String persistCompetence(@WebParam(name = "competence") Competence competence) {
        String messageCreate = null;
        String action = null;



        initCampagneDao();
        if (competence.getIdCompetence() == null) {
            action = "créée.";
            competenceDAO.persist(competence);
        } else {
            action = "modifiée.";
            competenceDAO.merge(competence);
        }
        closeCampagneDao();
        messageCreate = "La compétence a été " + action;

        return messageCreate;
    }

    /**
     * Récupérer la liste des autoévalations EN COURS pour un compte d'accès
     * donné
     */
    @WebMethod(operationName = "getEvaluationListENCOURS")
    public List<Evaluation> getEvaluationListENCOURS(@WebParam(name = "idCompteAcces") String id) {
        List<Evaluation> evaluationList = null;
        initEvaluationDao();
        evaluationList = evaluationDAO.getEvaluationListENCOURS(new Integer(id));
        closeEvaluationDao();

        return evaluationList;
    }

    /**
     * Récupérer la liste des autoévalations TERMINES pour un compte d'accès
     * donné
     */
    @WebMethod(operationName = "getEvaluationListTERMINEE")
    public List<Evaluation> getEvaluationListTERMINEE(@WebParam(name = "idCompteAcces") String id) {
        List<Evaluation> evaluationList = null;
        initEvaluationDao();
        evaluationList = evaluationDAO.getEvaluationListTERMINEE(new Integer(id));
        closeEvaluationDao();

        return evaluationList;
    }

    /**
     * Récupérer une evaluation à partir de son identifiant
     */
    @WebMethod(operationName = "getCompteAcces")
    public CompteAcces getCompteAcces(@WebParam(name = "idCompteAcces") String id) {
        CompteAcces compteAccesFind = null;

        initCompteAccesDao();
        compteAccesFind = compteAccesDAO.getCompteAcces(new Integer(id));
        closeCompteAccesDao();

        return compteAccesFind;
    }

    /**
     *
     */
    @WebMethod(operationName = "isRightsAndAuthentificated")
    public CompteAcces isRightsAndAuthentificated(@WebParam(name = "compteAcces") CompteAcces compteAcces) {
        CompteAcces compteAccesFind = null;
        initCompteAccesDao();
        compteAccesFind = compteAccesDAO.isRightsAndAuthentificated(compteAcces);
        closeCompteAccesDao();


        return compteAccesFind;
    }

    /**
     * Créer/modifier un compte d'accès
     */
    @WebMethod(operationName = "persistCompteAcces")
    public String persistCompteAcces(@WebParam(name = "compteAcces") CompteAcces compteAcces) {
        String messageCreate = null;
        String action = null;



        initCompteAccesDao();
        if (compteAcces.getIdCompteAcces() == null) {
            action = "créé.";
            compteAccesDAO.persist(compteAcces);
        } else {
            action = "modifié.";
            compteAccesDAO.merge(compteAcces);
        }


        closeCompteAccesDao();
        messageCreate = "Le compte d'accès : " + compteAcces.getIdCompteAcces() + " a été " + action;

        return messageCreate;
    }

    /**
     * Créer/modifier une personne
     */
    @WebMethod(operationName = "persistPersonne")
    public String persistPersonne(@WebParam(name = "personne") Personne personne) {
        String messageCreate = null;
        String action = null;




        initPersonneDao();
        if (personne.getIdPersonne() == null) {
            action = "créé.";
            personneDAO.persist(personne);
        } else {
            action = "modifié.";
            personneDAO.merge(personne);
        }


        closePersonneDao();
        messageCreate = "La personne : " + personne.getNomLb() + " " + personne.getPrenomLb() + " a été " + action;

        return messageCreate;
    }

    private void initCompetenceDao() {
        competenceDAO = new CompetenceDAO();
        competenceDAO.init();
    }

    private void closeCompetenceDao() {
        competenceDAO.close();
    }

    private void initMetierDao() {
        metierDAO = new MetierDAO();
        metierDAO.init();
    }

    private void closeMetierDao() {
        metierDAO.close();
    }

    private void initMethodeDao() {
        methodeDAO = new MethodeDAO();
        methodeDAO.init();
    }

    private void closeMethodeDao() {
        methodeDAO.close();
    }

    private void initSavoirDao() {
        savoirDAO = new SavoirDAO();
        savoirDAO.init();
    }

    private void closeSavoirDao() {
        savoirDAO.close();
    }

    private void initCompteAccesDao() {
        compteAccesDAO = new CompteAccesDAO();
        compteAccesDAO.init();
    }

    private void closeCompteAccesDao() {
        compteAccesDAO.close();
    }

    private void initEvaluationDao() {
        evaluationDAO = new EvaluationDAO();
        evaluationDAO.init();
    }

    private void closeEvaluationDao() {
        evaluationDAO.close();
    }

    private void initCampagneDao() {
        campagneDAO = new CampagneDAO();
        campagneDAO.init();
    }

    private void closeCampagneDao() {
        campagneDAO.close();
    }

    private void initPersonneDao() {
        personneDAO = new PersonneDAO();
        personneDAO.init();
    }

    private void closePersonneDao() {
        personneDAO.close();
    }
}
