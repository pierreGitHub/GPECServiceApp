/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam.gpec;

import cnam.gpec.business.Campagne;
import cnam.gpec.business.Competence;
import cnam.gpec.business.Evaluation;
import cnam.gpec.business.Metier;
import cnam.gpec.business.auth.CompteAcces;
import cnam.gpec.dao.CompetenceDAO;
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

        initDao();
        Competence competenceFind = competenceDAO.getCompetence(new Integer(id));
        closeDao();

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
        initDao();
       // metierFind = competenceDAO.get(new Integer(id));
        closeDao();

        return metierFind;

    }

    /**
     * Récupérer une compétence à partir de son identifiant
     */
    @WebMethod(operationName = "getCompetence")
    public Competence getCompetence(@WebParam(name = "idCompetence") String id) {
        Competence competenceFind = null;
        initDao();
        competenceFind = competenceDAO.getCompetence(new Integer(id));
        closeDao();

        return competenceFind;

    }

    /**
     * Récupérer une compétence à partir de son identifiant
     */
    @WebMethod(operationName = "getCampagne")
    public Campagne getCampagne(@WebParam(name = "idCampagne") String id) {
        Campagne campagneFind = null;

        initDao();
        //TODO Partie DAO
        closeDao();

        return campagneFind;
    }

    /**
     * Récupérer la liste des campagnes EN COURS pour un compte d'accès donné
     */
    @WebMethod(operationName = "getCampagneListENCOURS")
    public List<Campagne> getCampagneListENCOURS(@WebParam(name = "idCompteAcces") String id) {
        List<Campagne> campagneList = null;
        initDao();
        //TODO Partie dao
        closeDao();

        return campagneList;
    }

    /**
     * Récupérer la liste des campagnes TERMINEE pour un compte d'accès donné
     */
    @WebMethod(operationName = "getCampagneListTERMINEE")
    public List<Campagne> getCampagneListTERMINEE(@WebParam(name = "idCompteAcces") String id) {
        List<Campagne> campagneList = null;
        initDao();
        //TODO Partie dao
        closeDao();

        return campagneList;
    }

    /**
     * Créer/modifier une campagne
     */
    @WebMethod(operationName = "persistCampagne")
    public String persistCampagne(@WebParam(name = "campagne") Campagne campagne) {
        String messageCreate = null;
        initDao();
        //TODO Partie dao
        closeDao();


        return messageCreate;
    }

    /**
     * Créer/modifier un métier
     */
    @WebMethod(operationName = "persistMetier")
    public String persistMetier(@WebParam(name = "metier") Metier metier) {
        String messageCreate = null;
        initDao();
        //TODO Partie dao
        closeDao();


        return messageCreate;
    }
    
    /**
     * Créer/modifier un competence
     */
    @WebMethod(operationName = "persistCompetence")
    public String persistCompetence(@WebParam(name = "competence") Competence competence) {
        String messageCreate = null;
        initDao();
        //TODO Partie dao
        closeDao();


        return messageCreate;
    }
    
    /**
     * Récupérer la liste des autoévalations EN COURS pour un compte d'accès donné
     */
    @WebMethod(operationName = "getEvaluationListENCOURS")
    public List<Evaluation> getEvaluationListENCOURS(@WebParam(name = "idCompteAcces") String id) {
        List<Evaluation> evaluationList = null;
        initDao();
        //TODO Partie dao
        closeDao();

        return evaluationList;
    }
    
    /**
     * Récupérer la liste des autoévalations TERMINES pour un compte d'accès donné
     */
    @WebMethod(operationName = "getEvaluationListTERMINEE")
    public List<Evaluation> getEvaluationListTERMINEE(@WebParam(name = "idCompteAcces") String id) {
        List<Evaluation> evaluationList = null;
        initDao();
        //TODO Partie dao
        closeDao();

        return evaluationList;
    }
    
    /**
     * 
     */
    @WebMethod(operationName = "isRightsAndAuthentificated")
    public CompteAcces isRightsAndAuthentificated(@WebParam(name = "compteAcces") CompteAcces compteAcces) {
        CompteAcces compteAccesFind = null;
        initDao();
        //TODO Partie dao
        closeDao();


        return compteAccesFind;
    }

    private void initDao() {
        competenceDAO = new CompetenceDAO();
        competenceDAO.init();
    }

    private void closeDao() {
        competenceDAO.close();
    }
}
