package fr.eni.ibaie.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bll.UtilisateurManager;
import fr.eni.ibaie.bo.Utilisateur;


@WebServlet("/ServletModificationProfil")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public Utilisateur utilisateurenCours;
	public Utilisateur utilisateurModifie;
	
    public ServletModificationProfil() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UtilisateurManager userM = new UtilisateurManager();
			HttpSession session = request.getSession();		
			String pseudo = (String) session.getAttribute("ID");
			
			utilisateurenCours = new Utilisateur(pseudo);
			
			userM.readUtilisateur(utilisateurenCours);
			request.setAttribute("u", utilisateurenCours);
			
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifProfil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurManager userM;
				
		try {
			
			userM = new UtilisateurManager();
			
			String pseudo = request.getParameter("ID");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String mail = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("CP");
			String ville = request.getParameter("ville");			
			String motDePasseActuel = request.getParameter("MDPActuel");			
			String motDePasseNouveau = request.getParameter("MDPNouveau");
			String mdp = null;
			

			if(motDePasseNouveau.isEmpty()) {
				mdp = motDePasseActuel;
			}
			else {
				if (request.getParameter("MDPNouveau").equals(request.getParameter("MDPVerif"))) {
					mdp = motDePasseNouveau;
				}
			}						
			int no = utilisateurenCours.getNoUtilisateur();		
			utilisateurModifie = new Utilisateur(no, pseudo, nom, prenom, mail, telephone, rue, codePostal, ville, mdp);
			userM.updateUtilisateur(utilisateurModifie);
			
		} catch (BusinessException e1) {
			
			e1.printStackTrace();
		}
		
		HttpSession session = request.getSession();		
		String pseudo = (String) session.getAttribute("ID");
		
		utilisateurenCours = new Utilisateur(utilisateurModifie.getPseudo());
		

		this.getServletContext().getRequestDispatcher("/ServletCompteUtilisateur").forward(request, response);
									
	}

}
	

