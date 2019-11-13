package fr.eni.ibaie.dal.JdbcImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.dal.CodesResultatDAL;
import fr.eni.ibaie.dal.ConnectionProvider;
import fr.eni.ibaie.bo.Utilisateur;
import fr.eni.ibaie.dal.DAO.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{
	
	
	private static final String VERIF_PSEUDO="SELECT * FROM UTILISATEURS  WHERE pseudo=?;";  	
	private static final String VERIF_CONN="SELECT * FROM UTILISATEURS  WHERE pseudo =? AND mot_de_passe=?;";    
	
	private static final String INSERT_UTILISATEUR="INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?);";	
	private static final String READ_UTILISATEUR="SELECT * FROM UTILISATEURS WHERE pseudo=?;";
	
	private static final String UPDATE_UTILISATEUR=" UPDATE UTILISATEURS SET pseudo=?, "
			+ "																 nom=?, "
			+ "																 prenom=?, "
			+ "																 email=?, "
			+ "																 telephone=?, "
			+ "																 rue=?, "
			+ "																 code_postal=?, "
			+ "																 ville=?, "
			+ "																 mot_de_passe=? "
			+ "																 WHERE no_utilisateur=?;";
	
	
	private static final String DELETE_UTILISATEUR="DELETE FROM UTILISATEURS WHERE pseudo=?;";
	private static final String MDP_FORGOT="SELECT mdp FROM UTILISATEURS WHERE pseudo=?;";
	
	
	public static boolean verifPseudoUtilisateur(Utilisateur utilisateur) throws BusinessException {

	        
	        boolean re = false;	        
	        Connection read = null;	            
	        try {
	            read =  ConnectionProvider.getConnection();
	            //On "active" le mode transactionnel
	            read.setAutoCommit(false);
	            //Instanciation des variables statement	            	            
	            PreparedStatement pstmt = read.prepareStatement(VERIF_PSEUDO);    
	            //Remplissage de la requête SQL
	            pstmt.setString(1, utilisateur.getPseudo());
	            //Exécution de la requête    
	            ResultSet result = pstmt.executeQuery(); 
	
	            if(result.next()) {            	
	            	utilisateur.setNoUtilisateur(result.getInt("no_utilisateur"));
	            	utilisateur.setNom(result.getString("nom"));
	            	utilisateur.setPrenom(result.getString("prenom"));
	            	utilisateur.setEmail(result.getString("email"));
	            	utilisateur.setTelephone(result.getString("telephone"));
	            	utilisateur.setRue(result.getString("rue"));
	            	utilisateur.setCodePostal(result.getString("code_postal"));
	            	utilisateur.setVille(result.getString("ville"));
	            	utilisateur.setMotDePasse(result.getString("mot_de_passe"));
	            	utilisateur.setCredit(result.getInt("credit"));     	
	            	re = false; 
	            }
	            else 
	            {
	            	re = true;
	            	System.out.println("pas de correspondance = pas existant ");
	            }
	            result.close();                            
	        } catch(Exception e) {
	            
	            try {                
	                // Il y a eu un problème, on annule la transaction.
	                read.rollback();
	                read.setAutoCommit(true); // Remettre comme c'était.
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                BusinessException businessException = new BusinessException();
	                businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
	                throw businessException;
	            }
	            
	            e.printStackTrace();
	            BusinessException businessException = new BusinessException();
	            businessException.ajouterErreur(CodesResultatDAL.CONNECT_UTIL_WRONG);
	            throw businessException;
	        }	    
	        return re;        
	    }
	
	public static boolean verifConnexionUtilisateur(Utilisateur utilisateur) throws BusinessException {
	    
	    boolean re = false;    
	    Connection read = null;      
	    try {
	        read =  ConnectionProvider.getConnection();
	        //On "active" le mode transactionnel
	        read.setAutoCommit(false);
	        //Instanciation des variables statement
	    
	        PreparedStatement pstmt = read.prepareStatement(VERIF_CONN);    
	        //Remplissage de la requête SQL
	        pstmt.setString(1, utilisateur.getPseudo());
	        pstmt.setString(2, utilisateur.getMotDePasse());
	        //Exécution de la requête    
	        ResultSet result = pstmt.executeQuery();            

	        if(result.next()) {
            	utilisateur.setNoUtilisateur(result.getInt("no_utilisateur"));
            	utilisateur.setNom(result.getString("nom"));
            	utilisateur.setPrenom(result.getString("prenom"));
            	utilisateur.setEmail(result.getString("email"));
            	utilisateur.setTelephone(result.getString("telephone"));
            	utilisateur.setRue(result.getString("rue"));
            	utilisateur.setCodePostal(result.getString("code_postal"));
            	utilisateur.setVille(result.getString("ville"));
            	utilisateur.setMotDePasse(result.getString("mot_de_passe"));
            	utilisateur.setCredit(result.getInt("credit"));
	            re = true;
	            System.out.println("une correspondance est trouvée = déjà existante donc OK");
	        }
	        else {
	        	re = false;
	        	System.out.println("pas de correspondance = mauvais identifiants ");
	        }
	        
	        result.close();                            
	    } catch(Exception e) {
	        
	        try {                
	            // Il y a eu un problème, on annule la transaction.
	            read.rollback();
	            read.setAutoCommit(true); // Remettre comme c'était.
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            BusinessException businessException = new BusinessException();
	            businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
	            throw businessException;
	        }
	        
	        e.printStackTrace();
	        BusinessException businessException = new BusinessException();
	        businessException.ajouterErreur(CodesResultatDAL.CONNECT_UTIL_WRONG);
	        throw businessException;
	    }

	    return re;
	    
	}	
					
	public void createUtilisateur(Utilisateur utilisateur) throws BusinessException {

		Connection cnx = null;
		
		try {
			
			cnx = ConnectionProvider.getConnection();
			cnx.setAutoCommit(false); // Pour permettre les traitements transactionnels
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
	
			pstmt.executeUpdate();	
			ResultSet rsId = pstmt.getGeneratedKeys();	
			if(rsId.next()){
				utilisateur.setNoUtilisateur(rsId.getInt(1));
			}								
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

	public void readUtilisateur(Utilisateur utilisateur) throws BusinessException {

		Connection read = null;
		
		try {
			
            read =  ConnectionProvider.getConnection();
            //On "active" le mode transactionnel
            read.setAutoCommit(false);
            //Instanciation des variables statement	            	            
            PreparedStatement pstmt = read.prepareStatement(READ_UTILISATEUR);    
            //Remplissage de la requête SQL
            pstmt.setString(1, utilisateur.getPseudo());
            //Exécution de la requête              
            ResultSet result = pstmt.executeQuery(); 
			
			if(result.next()){
            	utilisateur.setNoUtilisateur(result.getInt("no_utilisateur"));
            	utilisateur.setNom(result.getString("nom"));
            	utilisateur.setPrenom(result.getString("prenom"));
            	utilisateur.setEmail(result.getString("email"));
            	utilisateur.setTelephone(result.getString("telephone"));
            	utilisateur.setRue(result.getString("rue"));
            	utilisateur.setCodePostal(result.getString("code_postal"));
            	utilisateur.setVille(result.getString("ville"));
            	utilisateur.setMotDePasse(result.getString("mot_de_passe"));
            	utilisateur.setCredit(result.getInt("credit")); 
			}
			// Insertion
			pstmt = read.prepareStatement(READ_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			// Validation
			read.commit();
			
			
		} catch(Exception e) {
			
			try {				
				// Il y a eu un problème, on annule la transaction.
				read.rollback();
				read.setAutoCommit(true); // Remettre comme c'était.
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
				throw businessException;
			}
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.READ_UTILISATEUR_ECHEC);

			throw businessException;
		}
		
		
		
	}

	public void updateUtilisateur(Utilisateur utilisateurModif) throws BusinessException {	
				
		Connection update = null;
		try {			
            update =  ConnectionProvider.getConnection();
            //On "active" le mode transactionnel
            update.setAutoCommit(false);
            //Instanciation des variables statement	            	            
            PreparedStatement pstmt = update.prepareStatement(UPDATE_UTILISATEUR);                                
			pstmt.setString(1, utilisateurModif.getPseudo());
			pstmt.setString(2, utilisateurModif.getNom());
			pstmt.setString(3, utilisateurModif.getPrenom());
			pstmt.setString(4, utilisateurModif.getEmail());
			pstmt.setString(5, utilisateurModif.getTelephone());
			pstmt.setString(6, utilisateurModif.getRue());
			pstmt.setString(7, utilisateurModif.getCodePostal());
			pstmt.setString(8, utilisateurModif.getVille());
			pstmt.setString(9, utilisateurModif.getMotDePasse());
			pstmt.setInt(10, utilisateurModif.getNoUtilisateur() ); 			           
			//Exécution de la requête    
			pstmt.executeUpdate();
            update.commit();                        	                      
			System.out.println("Modification effectuée"); 
	
		} catch(Exception e) {
			
			try {				
				// Il y a eu un problème, on annule la transaction.
				update.rollback();
				update.setAutoCommit(true); // Remettre comme c'était.
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
				throw businessException;
			}
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_UTILISATEUR_ECHEC);

			throw businessException;
		}
		
	}
	
	public void deleteUtilisateur(Utilisateur utilisateur) throws BusinessException {
		
        Connection delete = null;	            
        try {
            delete =  ConnectionProvider.getConnection();
            //On "active" le mode transactionnel
            delete.setAutoCommit(false);
            //Instanciation des variables statement	            	            
            PreparedStatement pstmt = delete.prepareStatement(DELETE_UTILISATEUR);              
            //Remplissage de la requête SQL
            pstmt.setString(1, utilisateur.getPseudo());
            //Exécution de la requête
            pstmt.execute();
            delete.commit();
           			
		} catch(Exception e) {
			
			try {				
				// Il y a eu un problème, on annule la transaction.
				delete.rollback();
				delete.setAutoCommit(true); // Remettre comme c'était.
			} catch (Exception ex) {
				ex.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
				throw businessException;
			}
			
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_UTILISATEUR_ECHEC);

			throw businessException;
		}
	}
	
	public static String mdpForgot(String email) throws BusinessException{

       String mdpretourne = null;
       Connection read = null;                

       try {
           read =  ConnectionProvider.getConnection();

           //On "active" le mode transactionnel
           read.setAutoCommit(false);

           //Instanciation des variables statement                                
           PreparedStatement pstmt = read.prepareStatement(MDP_FORGOT);

           //Remplissage de la requête SQL
           pstmt.setString(1, email);

           //Exécution de la requête
           ResultSet result = pstmt.executeQuery();            
           if(result.next()) {                
           mdpretourne = result.getString("mot_de_passe");        
           }
           else {
               System.out.println("pas de correspondance = pas existant ");
           }
           result.close();

       } catch(Exception e) {            
    	   
    	   try {

               // Il y a eu un problème, on annule la transaction.
               read.rollback();
               read.setAutoCommit(true); // Remettre comme c'était.

           } catch (Exception ex) {
               ex.printStackTrace();
               BusinessException businessException = new BusinessException();
               businessException.ajouterErreur(CodesResultatDAL.ERREUR_CONNEXION);
               throw businessException;

           }
       	   e.printStackTrace();
           BusinessException businessException = new BusinessException();
           businessException.ajouterErreur(CodesResultatDAL.CONNECT_UTIL_WRONG);
           throw businessException;
       }            

        return mdpretourne;    

    }
}