
package fr.eni.ibaie.dal;

public abstract class CodesResultatDAL {
	
	/**/
	//GLOBAL
	/**
	 * Echec général quand erreur de connexion.
	 */
	public static final int ERREUR_CONNEXION=19999;
	
	/**/
	//UTILISATEUR
	/**
	 * Echec général quand tentative d'ajouter un utilisateur avec le même pseudo
	 */
	public static final int INSERT_UTIL_EXIST=10001;
	/**
	 * Echec général quand tentative de connexion avec le mauvais login/mdp
	 */
	public static final int CONNECT_UTIL_WRONG=10010;	
	/**
	 * Echec général quand erreur de selection d'un utilisateur
	 */
	public static final int READ_UTILISATEUR_ECHEC=10011;
	/**
	 * Echec général quand erreur de selection d'un utilisateur
	 */
	public static final int DELETE_UTILISATEUR_ECHEC=10012;
	/**
	 * Echec général quand erreur de selection d'un utilisateur
	 */
	public static final int UPDATE_UTILISATEUR_ECHEC=10013;
	
	
	/**/
	//ARTICLE
	/**
	 * Echec général quand tentative de créer un article avec une date d'ouverture d'enchère supérieure à la date de fin d'enchères
	 */
	public static final int INSERT_OBJECT_DATE=12001;
	/**
	 * Echec général quand tentative de créer un article avec un des champs de Retrait remplis mais pas les autres
	 */
	public static final int INSERT_OBJECT_EXPEDITION=12002;
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int INSERT_OBJET_ECHEC=12003;
	/**
	 * Echec général quand erreur non gérée à la selection 
	 */
	public static final int SELECT_FROM_ARTICLE_ECHEC=12003;
	/**
	 * Echec général quand erreur non gérée à l'update
	 */
	public static final int UPDATE_FROM_ARTICLE_ECHEC=12004;
	/**
	 * Echec général quand erreur non gérée à la suppresion
	 */
	public static final int DELETE_FROM_ARTICLE_ECHEC=12005;
	
	
	/**/
	//CATEGORIE
	/**
	 * Echec général quand tentative de créer un une catégorie
	 */
	public static final int INSERT_CATEGORIE_ECHEC=12100;
	/**
	 * Echec général quand tentative de requêter sur la catégorie
	 */
	public static final int READ_CATEGORIE_ECHEC=12101;
	/**
	 * Echec général quand tentative de supprimer une catégorie
	 */
	public static final int DELETE_CATEGORIE_ECHEC=12102;	
	
	
	/**/
	//RETRAIT
	/**
	 * Echec général quand tentative de créer un point de retrait
	 */
	public static final int INSERT_RETRAIT_ECHEC=12200;
	/**
	 * Echec général quand tentative de requêter sur un point de retrait
	 */
	public static final int READ_RETRAIT_ECHEC=12201;	
	/**
	 * Echec général quand tentative d'update un point de retrait
	 */
	public static final int UPDATE_RETRAIT_ECHEC=12203;	
	/**
	 * Echec général quand tentative de supprimer un point de retrait
	 */
	public static final int DELETE_RETRAIT_ECHEC=12203;	
	
	
	/**/
	//ENCHERES
	/**
	 * Echec général quand tentative d'enchérir avec un prix inférieur au prix de vente
	 */
	public static final int ACTION_OBJECT_PRICE=12010;
	/**
	 * Echec général quand tentative d'enchérir avec plus de points que dans le crédit (après soustraction)
	 */
	public static final int ACTION_OBJECT_POCKET=12012;
	/**
	 * Echec général quand tentative de modification après le début de l'enchère
	 */
	public static final int MODIF_AFTER_ACTION=12020;
	/**
	 * Echec général quand tentative d'annuler après le début de l'enchère
	 */
	public static final int DELETE_AFTER_ACTION=12021;


	
	
}
