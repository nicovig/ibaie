package fr.eni.ibaie.dal.DAO;

import java.util.List;
import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bo.Utilisateur;
public interface UtilisateurDAO {

	public void createUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public void readUtilisateur(Utilisateur utilisateur) throws BusinessException;
	public void updateUtilisateur(Utilisateur utilisateurModif) throws BusinessException;
	public void deleteUtilisateur(Utilisateur utilisateur) throws BusinessException;

}


