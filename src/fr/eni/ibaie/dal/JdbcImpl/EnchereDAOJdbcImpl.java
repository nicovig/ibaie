package fr.eni.ibaie.dal.JdbcImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.dal.CodesResultatDAL;
import fr.eni.ibaie.dal.ConnectionProvider;
import fr.eni.ibaie.bo.Article;
import fr.eni.ibaie.bo.Enchere;
import fr.eni.ibaie.bo.Utilisateur;
import fr.eni.ibaie.dal.DAO.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO{

	private static final String INSERT_ENCHERE="INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?);";
	private static final String READ_ENCHERE_UTILISATEUR="SELECT * FROM ENCHERES WHERE no_utilisateur=? ;";
	private static final String READ_ENCHERE_ARTICLE="SELECT * FROM ENCHERES WHERE no_article=? ;";
	private static final String DELETE_ENCHERE_UTILISATEUR="DELETE * FROM ENCHERES WHERE no_utilisateur=? ;";
	private static final String DELETE_ENCHERE_ARTICLE="DELETE * FROM ENCHERES WHERE no_article=? ;";
	
	public void createEnchere(int noUtilisateur, Article articles) throws BusinessException {
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noUtilisateur);
			pstmt.setInt(2, articles.getNoArticle());
			pstmt.setDate(3, (Date) articles.getDateFinEncheres());		
			pstmt.setInt(4, articles.getPrixVente());
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

	
	public void readEnchereUtilisateur(int noUtilisateur) throws BusinessException {
		
		
	}

	public void readEnchereArticle(int noArticle) throws BusinessException {
		
		
	}

	public void updateEnchere(int noUtilisateur, Article articles) throws BusinessException {
		//Si admin met en standby le compte, alors enchere annulées	
		
	}


	public void deleteEnchereUtilisateur(int noUtilisateur) throws BusinessException {
		//Si admin supprime le compte, alors enchere annulées	
	}


	public void deleteEnchereArticle(int noArticle) throws BusinessException {
		
	}




}