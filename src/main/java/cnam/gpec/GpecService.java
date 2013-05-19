/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnam.gpec;

import cnam.gpec.business.Competence;
import cnam.gpec.dao.CompetenceDAO;
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

    private CompetenceDAO competenceDAO ;

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
            return competenceFind.getIntituleCompetence();
        } else {
            return "Compétence non trouvée";
        }
    }
    
    
    
   private void initDao() {
      competenceDAO =  new CompetenceDAO();
      competenceDAO.init();
   }

   private void closeDao() {
      competenceDAO.close();
   }
}
