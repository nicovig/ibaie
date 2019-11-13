package fr.eni.ibaie.bo;

import java.util.Date;

public class Enchere {

	private Date dateEnchere;
	private int montant;
	private Utilisateur utilisateurs;
	private Article articles;
	
	public Enchere(Date dateEnchere, int montant, Utilisateur utilisateurs, Article articles) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant = montant;
		this.utilisateurs = utilisateurs;
		this.articles = articles;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Utilisateur getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Utilisateur utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Article getArticles() {
		return articles;
	}

	public void setArticles(Article articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant=" + montant + ", utilisateurs=" + utilisateurs
				+ ", articles=" + articles + "]";
	}
	
		
}
