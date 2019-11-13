package fr.eni.ibaie.bll;

import javax.servlet.http.HttpServletRequest;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Utilisateur;
import fr.eni.ibaie.dal.DAO.UtilisateurDAO;
import fr.eni.ibaie.dal.JdbcImpl.UtilisateurDAOJdbcImpl;
import fr.eni.ibaie.dal.factory.Factory;

public class UtilisateurManager{
	private UtilisateurDAO daoUtilisateur;
	
	public UtilisateurManager() throws BusinessException{
		daoUtilisateur = Factory.getUtilisateurDAO();	
	}	
	
	public void addUtilisateur(Utilisateur utilisateur) throws BusinessException{
		daoUtilisateur.createUtilisateur(utilisateur);		
	}	
	
	public boolean verifPseudoCreer(HttpServletRequest request) throws BusinessException{
		String pseudo = request.getParameter("ID");	   
		Utilisateur u = new Utilisateur(pseudo); // Constructeur pseudo        	    
	    boolean resultat;	  	     
	    	if(UtilisateurDAOJdbcImpl.verifPseudoUtilisateur(u)){
	    	   resultat = true;
	       } else {
	           resultat = false;
	       }        	    	
	    return resultat;
	 }
	
	public boolean verifPseudoConnexion(HttpServletRequest request) throws BusinessException{
	      
		String pseudo = request.getParameter("ID");
		String mdp = request.getParameter("MDP");	   
		Utilisateur u = new Utilisateur(pseudo, mdp); // Constructeur pseudo  + mdp      	    
	    boolean resultat;
	     
	    	if(UtilisateurDAOJdbcImpl.verifConnexionUtilisateur(u)){
	    	   resultat = true;
	       } else {
	           resultat = false;
	       }        
	    	
	    return resultat;
	 }  

	public void readUtilisateur(Utilisateur utilisateur) throws BusinessException{
        daoUtilisateur.readUtilisateur(utilisateur); 	
	}
	
	public void updateUtilisateur(Utilisateur utilisateurModif) throws BusinessException{
		daoUtilisateur.updateUtilisateur(utilisateurModif);
	}

	public void deleteUtilisateur(Utilisateur utilisateur) throws BusinessException{
		daoUtilisateur.deleteUtilisateur(utilisateur);
	}
	
	public String mdpOublie(String email) {
        String mdp = null;
   
        try {
            mdp = UtilisateurDAOJdbcImpl.mdpForgot(email);
            System.out.println(email);
            System.out.println(mdp);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
       return mdp;        

    }
}


