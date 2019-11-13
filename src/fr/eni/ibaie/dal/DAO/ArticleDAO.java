package fr.eni.ibaie.dal.DAO;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Article;
import fr.eni.ibaie.bo.Categorie;
import fr.eni.ibaie.bo.Utilisateur;

public interface ArticleDAO {
	
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param articles
	 * @throws BusinessException
	 */
	public void createArticle(Article articles, Utilisateur utilisateur, Categorie noCategorie) throws BusinessException;	
	public void readArticle(int noArticle) throws BusinessException;	
	public void updateArticle(Article articles, int noUtilisateur, int noCategorie) throws BusinessException;
	public void deleteArticle(int noArticle) throws BusinessException;
	public void enchereEnCours(int Article) throws BusinessException;

}
