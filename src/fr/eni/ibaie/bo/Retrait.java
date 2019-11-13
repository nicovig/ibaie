package fr.eni.ibaie.bo;

import java.util.List;

public class Retrait {

	private String rue;
	private String codePostal;
	private String ville;
	private List<Article> articles;
	
	public Retrait(String rue, String codePostal, String ville, List<Article> articles) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articles = articles;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Adresse du point de retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", articles=" + articles
				+ "]";
	}
	
	
	
}
