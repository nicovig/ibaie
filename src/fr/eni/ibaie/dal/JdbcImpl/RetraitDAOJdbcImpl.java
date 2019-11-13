package fr.eni.ibaie.dal.JdbcImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.dal.CodesResultatDAL;
import fr.eni.ibaie.dal.ConnectionProvider;
import fr.eni.ibaie.bo.Article;
import fr.eni.ibaie.bo.Retrait;
import fr.eni.ibaie.bo.Utilisateur;
import fr.eni.ibaie.dal.DAO.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO{
	
	private static final String INSERT_RETRAIT="INSERT INTO RETRAITS(no_article, rue, code_postal, ville) VALUES(?,?,?,?);";
	private static final String READ_RETRAIT="SELECT * FROM RETRAITS WHERE no_article = ?;";
	private static final String DELETE_RETRAIT="DELETE * FROM RETRAITS WHERE no_article = ?;";
	
	public void createRetrait(int noArticle, Utilisateur utilisateur) throws BusinessException {
		
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noArticle);			
			pstmt.setString(2, utilisateur.getRue());
			pstmt.setString(3, utilisateur.getCodePostal());
			pstmt.setString(4, utilisateur.getVille());
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_RETRAIT_ECHEC);

			throw businessException;
		}	
		
	}
		

	public void readRetrait(int noArticle) throws BusinessException {
		
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(READ_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noArticle);			
			pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(READ_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
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
			businessException.ajouterErreur(CodesResultatDAL.READ_RETRAIT_ECHEC);

			throw businessException;
		}
		
	}

	public void updateRetrait(int noArticle, Utilisateur utilisateur) throws BusinessException {

		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noArticle);			
			pstmt.setString(2, utilisateur.getRue());
			pstmt.setString(3, utilisateur.getCodePostal());
			pstmt.setString(4, utilisateur.getVille());
			pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_RETRAIT_ECHEC);

			throw businessException;
		}	
		
	}

	public void deleteRetrait(int noArticle) throws BusinessException {
		
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noArticle);			
			pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(DELETE_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
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
			businessException.ajouterErreur(CodesResultatDAL.DELETE_RETRAIT_ECHEC);

			throw businessException;
		}
	}

}