package fr.eni.ibaie.dal.JdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.dal.CodesResultatDAL;
import fr.eni.ibaie.dal.ConnectionProvider;
import fr.eni.ibaie.bo.Categorie;
import fr.eni.ibaie.dal.DAO.CategorieDAO;

/*public class CategorieDAOJdbcImpl implements CategorieDAO{
	
	private static final String INSERT_CATEGORIE="INSERT INTO CATEGORIES(libelle) VALUES ?;";
	private static final String READ_CATEGORIE="SELECT * FROM CATEGORIES WHERE libelle=?;";
	private static final String DELETE_CATEGORIE="DELETE * FROM CATEGORIES WHERE libelle=?;";
	

	public void createCategorie(String libelle) throws BusinessException {

		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, libelle);			
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_CATEGORIE_ECHEC);

			throw businessException;
		}	
		
	}
	
	public void readCategorie(String libelle) throws BusinessException {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(READ_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, libelle);																							/* <=###########################################*/
	/*		pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(READ_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
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
			businessException.ajouterErreur(CodesResultatDAL.READ_CATEGORIE_ECHEC);

			throw businessException;
		}
		
	}

	public void deleteCategorie(String libelle) throws BusinessException {
		
		Connection cnx = null;
		
		try {
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, libelle);			
			pstmt.executeUpdate();	
			// Insertion
			pstmt = cnx.prepareStatement(DELETE_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
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
			businessException.ajouterErreur(CodesResultatDAL.DELETE_CATEGORIE_ECHEC);

			throw businessException;
		
		
		}
	}
}*/