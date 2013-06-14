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
import cnam.gpec.business.Savoir;
import cnam.gpec.business.auth.CompteAcces;
import cnam.gpec.dao.CampagneDAO;
import cnam.gpec.dao.CompetenceDAO;
import cnam.gpec.dao.EvaluationDAO;
import cnam.gpec.dao.MethodeDAO;
import cnam.gpec.dao.MetierDAO;
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
     * Récupérer la liste des campagnes EN COURS pour un compte d'accès donné
     */
    @WebMethod(operationName = "getCampagneListENCOURS")
    public List<Campagne> getCampagneListENCOURS(@WebParam(name = "idCompteAcces") String id) {
        List<Campagne> campagneList = null;
        initCompetenceDao();
        //TODO Partie dao
        closeCompetenceDao();

        return campagneList;
    }

    /**
     * Récupérer la liste des campagnes TERMINEE pour un compte d'accès donné
     */
    @WebMethod(operationName = "getCampagneListTERMINEE")
    public List<Campagne> getCampagneListTERMINEE(@WebParam(name = "idCompteAcces") String id) {
        List<Campagne> campagneList = null;
        initCompetenceDao();
        //TODO Partie dao
        closeCompetenceDao();

        return campagneList;
    }

    /**
     * Créer/modifier une campagne
     */
    @WebMethod(operationName = "persistCampagne")
    public String persistCampagne(@WebParam(name = "campagne") Campagne campagne) {
        String messageCreate = null;
        initCompetenceDao();
        //TODO Partie dao
        closeCompetenceDao();


        return messageCreate;
    }

    /**
     * Créer/modifier un métier
     */
    @WebMethod(operationName = "persistMetier")
    public String persistMetier(@WebParam(name = "metier") Metier metier) {
        String messageCreate = null;
        initCompetenceDao();
        //TODO Partie dao
        closeCompetenceDao();


        return messageCreate;
    }
    
     /**
     * Créer/modifier un évaluation
     */
    @WebMethod(operationName = "persistEvaluation")
    public String persistEvaluation(@WebParam(name = "evaluation") Evaluation evaluation) {
        String messageCreate = null;
        initEvaluationDao();
        //TODO Partie dao
        closeEvaluationDao();


        return messageCreate;
    }
    
    
    /**
     * Créer/modifier une competence
     */
    @WebMethod(operationName = "persistCompetence")
    public String persistCompetence(@WebParam(name = "competence") Competence competence) {
        String messageCreate = null;
        initCompetenceDao();
        //TODO Partie dao
        closeCompetenceDao();


        return messageCreate;
    }
    
    /**
     * Récupérer la liste des autoévalations EN COURS pour un compte d'accès donné
     */
    @WebMethod(operationName = "getEvaluationListENCOURS")
    public List<Evaluation> getEvaluationListENCOURS(@WebParam(name = "idCompteAcces") String id) {
        List<Evaluation> evaluationList = null;
        initCompetenceDao();
        //TODO Partie dao
        closeCompetenceDao();

        return evaluationList;
    }
    
    /**
     * Récupérer la liste des autoévalations TERMINES pour un compte d'accès donné
     */
    @WebMethod(operationName = "getEvaluationListTERMINEE")
    public List<Evaluation> getEvaluationListTERMINEE(@WebParam(name = "idCompteAcces") String id) {
        List<Evaluation> evaluationList = null;
        initCompetenceDao();
        //TODO Partie dao
        closeCompetenceDao();

        return evaluationList;
    }
    
    /**
     * 
     */
    @WebMethod(operationName = "isRightsAndAuthentificated")
    public CompteAcces isRightsAndAuthentificated(@WebParam(name = "compteAcces") CompteAcces compteAcces) {
        CompteAcces compteAccesFind = null;
        initCompteAccesDao();
        compteAccesFind = compteAccesDAO.getCompteAcces(compteAcces);
        closeCompteAccesDao();


        return compteAccesFind;
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
}
