package fr.eni.ibaie.bll;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Categorie;
import fr.eni.ibaie.dal.DAO.EnchereDAO;
import fr.eni.ibaie.dal.factory.Factory;

public class EnchereManager {
	
	private EnchereDAO daoEnchere;
	
	public EnchereManager() throws BusinessException{
		daoEnchere = Factory.getEnchereDAO();
		
	}
	
	public void addCategorie(Categorie categorie) throws BusinessException{
		daoEnchere.createEnchere(noUtilisateur, articles);

	}
}
