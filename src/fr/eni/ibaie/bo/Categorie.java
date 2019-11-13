package fr.eni.ibaie.bo;

import java.util.List;

public class Categorie {

	private int noCategorie;
	private String libelle;
	private List<Article> articles;
	
	public Categorie(int noCategorie, String libelle, List<Article> articles) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articles = articles;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", articles=" + articles + "]";
	}
	
	
}
