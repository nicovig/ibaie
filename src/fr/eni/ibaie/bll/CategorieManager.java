package fr.eni.ibaie.bll;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Categorie;
import fr.eni.ibaie.dal.DAO.CategorieDAO;
import fr.eni.ibaie.dal.factory.Factory;

public class CategorieManager {

	private CategorieDAO daoCategorie;
	
	public CategorieManager() throws BusinessException{
		daoCategorie = Factory.getCategorieDAO();
		
	}
	
	public void addCategorie(Categorie categorie) throws BusinessException{
		daoCategorie.createCategorie(categorie);
		
	}
	
}
