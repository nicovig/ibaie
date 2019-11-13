package fr.eni.ibaie.dal.DAO;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Utilisateur;

public interface RetraitDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param retrait
	 * @throws BusinessException
	 */
	public void createRetrait(int noArticle, Utilisateur utilisateur) throws BusinessException;
	public void readRetrait(int noArticle) throws BusinessException;
	public void updateRetrait(int noArticle, Utilisateur utilisateur) throws BusinessException;
	public void deleteRetrait(int noArticle) throws BusinessException;
}
