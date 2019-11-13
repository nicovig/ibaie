package fr.eni.ibaie.dal.DAO;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Categorie;

public interface CategorieDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param encheres
	 * @throws BusinessException
	 */
	public void createCategorie(Categorie categorie) throws BusinessException;
	public void readCategorie(String libelle) throws BusinessException;
	public void deleteCategorie(String libelle) throws BusinessException;
}
