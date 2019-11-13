package fr.eni.ibaie.ihm;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bll.UtilisateurManager;
import fr.eni.ibaie.bo.Utilisateur;


@WebServlet("/CreerCompte")
public class CreerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CreerCompte() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/sInscrire.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String pseudo;
		String prenom;
		String nom;
		String mail;
		String telephone;
		String rue;
		String codePostal;
		String ville;
		String motDePasse;
	
		if (request.getParameter("MDP").equals(request.getParameter("MDPverif"))) {
		
				pseudo = request.getParameter("ID");
				nom = request.getParameter("nom");
				prenom = request.getParameter("prenom");
				mail = request.getParameter("email");
				telephone = request.getParameter("telephone");
				rue = request.getParameter("rue");
				codePostal = request.getParameter("CP");
				ville = request.getParameter("ville");
				motDePasse = request.getParameter("MDP");
								
				
				Utilisateur user1 = new Utilisateur(pseudo, nom, prenom, mail, telephone, rue, codePostal, ville, motDePasse);
				UtilisateurManager userM = null;
				
				try {
					userM = new UtilisateurManager();
				
				
				} catch (BusinessException e1) {
					
					e1.printStackTrace();
				}	
				try {	
					if(userM.verifPseudoCreer(request)) {
						//if(userM.verifEmail(request)) {
							userM.addUtilisateur(user1);						
						this.getServletContext().getRequestDispatcher("/WEB-INF/accueilUtilisateur.jsp").forward(request, response);
						//}
						//Création ou récup de la session
						HttpSession session = request.getSession();
						
						// Mise en session du noUtilisateur
						String pseudoSession = user1.getPseudo();
						session.setAttribute("pseudo", pseudoSession);
						
						// Recuperation de l'objet depuis la session
						String cle = (String) session.getAttribute("pseudo");
						System.out.println(cle);
					 
						//}
					} else {
						this.getServletContext().getRequestDispatcher("/sInscrire.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			request.setAttribute("utilisateur", user1);			
			
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueilUtilisateur.jsp");
		rd.forward(request, response);	
	
		}
	}
}
