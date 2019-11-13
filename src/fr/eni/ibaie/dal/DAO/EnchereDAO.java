package fr.eni.ibaie.dal.DAO;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Article;

public interface EnchereDAO {
	
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param encheres
	 * @throws BusinessException
	 */
	public void createEnchere(int noUtilisateur, Article articles) throws BusinessException;
	public void readEnchereUtilisateur(int noUtilisateur) throws BusinessException;
	public void readEnchereArticle(int noArticle) throws BusinessException;
	public void updateEnchere(int noUtilisateur, Article articles) throws BusinessException;
	public void deleteEnchereUtilisateur(int noUtilisateur) throws BusinessException;
	public void deleteEnchereArticle(int noArticle) throws BusinessException;
}
