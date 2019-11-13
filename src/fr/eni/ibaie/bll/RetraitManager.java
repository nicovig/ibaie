package fr.eni.ibaie.bll;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Retrait;
import fr.eni.ibaie.dal.DAO.RetraitDAO;
import fr.eni.ibaie.dal.factory.Factory;

public class RetraitManager {
	
	private RetraitDAO daoRetrait;
	
	public RetraitManager() throws BusinessException{
		daoRetrait = Factory.getRetraitDAO();
		
	}
	
	public void addRetrait(Retrait retrait) throws BusinessException{
		daoRetrait.createRetrait(noArticle, utilisateur);

	}
}
