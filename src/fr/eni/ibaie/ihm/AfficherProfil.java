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


@WebServlet("/AfficherProfil")
public class AfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AfficherProfil() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UtilisateurManager userM = new UtilisateurManager();

			HttpSession session = request.getSession();
			
			String pseudo = (String) session.getAttribute("ID");
			
			Utilisateur u = new Utilisateur(pseudo);
			
			userM.readUtilisateur(u);
			request.setAttribute("u", u);
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/monProfil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
