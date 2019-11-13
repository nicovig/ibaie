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


@WebServlet("/ServletSuppressionCompte")
public class ServletSuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Utilisateur utilisateurenCours;   
  
    public ServletSuppressionCompte() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			
				HttpSession session = request.getSession();		
				String pseudo = (String) session.getAttribute("ID");
				
				utilisateurenCours = new Utilisateur(pseudo);
				
				//userM.readUtilisateur(utilisateurenCours);
				System.out.println(utilisateurenCours);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimerCompte.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			try {
				
				UtilisateurManager userM = new UtilisateurManager();
				
				userM.deleteUtilisateur(utilisateurenCours);
				HttpSession session = request.getSession();
				session.invalidate();
				
				
				
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

}
