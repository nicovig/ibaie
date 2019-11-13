package fr.eni.ibaie.dal.JdbcImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.*;
import java.util.Calendar;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.dal.ConnectionProvider;
import fr.eni.ibaie.bo.Article;
import fr.eni.ibaie.bo.Utilisateur;
import fr.eni.ibaie.bo.Categorie;
import fr.eni.ibaie.dal.CodesResultatDAL;
import fr.eni.ibaie.dal.DAO.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	
	private static final String INSERT_ARTICLE="INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_FROM_ARTICLE="SELECT * FROM ARTICLES_VENDUS WHERE nom_article=(?);";
	private static final String DELETE_FROM_ARTICLE="DELETE * FROM ARTICLES WHERE nom_article=(?);";
	//private static final String MAJ_AUTO_PRIX="SELECT pr"
	
	public void createArticle(Article articles, Utilisateur utilisateur, Categorie noCategorie) throws BusinessException {
		
		if (articles.getDateDebutEncheres().after(articles.getDateFinEncheres())) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_DATE);
			throw businessException;
		}
		
		if (articles.getRetrait().getRue().isEmpty() || articles.getRetrait().getCodePostal().isEmpty() || articles.getRetrait().getVille().isEmpty()) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_EXPEDITION);
			throw businessException;
		}
		else if (articles.getRetrait().getRue().isEmpty() && articles.getRetrait().getCodePostal().isEmpty() && articles.getRetrait().getVille().isEmpty()) {
		}
		
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, articles.getNomArticle());			
			pstmt.setString(2, articles.getDescription());
			pstmt.setDate(3, (Date) articles.getDateDebutEncheres());
			pstmt.setDate(4, (Date) articles.getDateFinEncheres());
			pstmt.setInt(5, articles.getPrixInitial());
			pstmt.setInt(6, articles.getPrixInitial());
			pstmt.setInt(7, utilisateur.getNoUtilisateur());
			//pstmt.setInt(8, noCategorie);
			pstmt.executeUpdate();	
			// Validation
			cnx.commit();
			
			
		} catch(Exception e) {
			
			try {				
				// Il y a eu un problème, on annule la transaction.
				cnx.rollback();
				cnx.setAutoCommit(true); // Remettre comme c'était.
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
				throw businessException;
			}
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);

			throw businessException;
		}	
	
	}
	
	public void readArticle(int noArticle) throws BusinessException {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_FROM_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noArticle);
			pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(SELECT_FROM_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			// Validation
			cnx.commit();
			
			
		} catch(Exception e) {
			
			try {				
				// Il y a eu un problème, on annule la transaction.
				cnx.rollback();
				cnx.setAutoCommit(true); // Remettre comme c'était.
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
				throw businessException;
			}
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_FROM_ARTICLE_ECHEC);

			throw businessException;
		}	
	}
	
	public void updateArticle(Article articles, int noUtilisateur, int noCategorie) throws BusinessException {
		//Avant la date d'enchere
				
	/*	if ( articles.getDateDebutEncheres()) { 																					/* <=###########################################*/
	/*		BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJECT_DATE);
			throw businessException;
		}
		*/		
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, articles.getNomArticle());			
			pstmt.setString(2, articles.getDescription());
			pstmt.setDate(3, (Date) articles.getDateDebutEncheres());
			pstmt.setDate(4, (Date) articles.getDateFinEncheres());
			pstmt.setInt(5, articles.getPrixInitial());
			pstmt.setInt(6, articles.getPrixVente());
			pstmt.setInt(7, noUtilisateur);
			pstmt.setInt(8, noCategorie);
			pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			// Validation
			cnx.commit();
			
			
		} catch(Exception e) {
			
			try {				
				// Il y a eu un problème, on annule la transaction.
				cnx.rollback();
				cnx.setAutoCommit(true); // Remettre comme c'était.
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
				throw businessException;
			}
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_FROM_ARTICLE_ECHEC);

			throw businessException;
		}	
	
	}
		
	public void deleteArticle(int noArticle) throws BusinessException {

		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_FROM_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noArticle);					
			pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(DELETE_FROM_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			// Validation
			cnx.commit();
			
			
		} catch(Exception e) {
			
			try {				
				// Il y a eu un problème, on annule la transaction.
				cnx.rollback();
				cnx.setAutoCommit(true); // Remettre comme c'était.
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
				throw businessException;
			}
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_FROM_ARTICLE_ECHEC);

			throw businessException;
		}
		
	}

	@Override
	public void enchereEnCours(int Article) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
		
		
}