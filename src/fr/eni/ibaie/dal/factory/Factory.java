package fr.eni.ibaie.dal.factory;

import fr.eni.ibaie.dal.DAO.ArticleDAO;
import fr.eni.ibaie.dal.DAO.CategorieDAO;
import fr.eni.ibaie.dal.DAO.EnchereDAO;
import fr.eni.ibaie.dal.DAO.RetraitDAO;
import fr.eni.ibaie.dal.DAO.UtilisateurDAO;
import fr.eni.ibaie.dal.JdbcImpl.ArticleDAOJdbcImpl;
//import fr.eni.ibaie.dal.JdbcImpl.CategorieDAOJdbcImpl;
import fr.eni.ibaie.dal.JdbcImpl.EnchereDAOJdbcImpl;
import fr.eni.ibaie.dal.JdbcImpl.RetraitDAOJdbcImpl;
import fr.eni.ibaie.dal.JdbcImpl.UtilisateurDAOJdbcImpl;

public abstract class Factory implements ArticleDAO, CategorieDAO, EnchereDAO, RetraitDAO, UtilisateurDAO {

	public static ArticleDAO getArticleDAO(){
		return new ArticleDAOJdbcImpl();
	}
	
//	public static CategorieDAO getCategorieDAO(){
//		return new CategorieDAOJdbcImpl();
//	}
	
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
}
