package fr.eni.ibaie.bll;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Article;
import fr.eni.ibaie.bo.Categorie;
import fr.eni.ibaie.bo.Utilisateur;
import fr.eni.ibaie.dal.DAO.ArticleDAO;
import fr.eni.ibaie.dal.factory.Factory;

public class ArticleManager {

	private ArticleDAO daoArticle;
	
	public ArticleManager() throws BusinessException{
		daoArticle = Factory.getArticleDAO();
		
	}
	
	public void addArticle(Article articles, Utilisateur noUtilisateur, Categorie noCategorie) throws BusinessException{
		daoArticle.createArticle(articles, noUtilisateur, noCategorie);
		
	}

	
}	


	

