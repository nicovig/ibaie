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


@WebServlet("/ServletDeConnexion")
public class ServletDeConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletDeConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/seConnecter.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			UtilisateurManager userM = new UtilisateurManager();
		
			
			
			if (userM.verifPseudoConnexion(request)) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/accueilUtilisateur.jsp").forward(request, response);
				
				
				// Mise en session du noUtilisateur
				String pseudo = request.getParameter("ID");
				
				//Création ou récup de la session
				HttpSession session = request.getSession();		
				session.setAttribute("ID", pseudo);
				System.out.println(session);
				
				
			} else {
				this.getServletContext().getRequestDispatcher("/seConnecter.jsp").forward(request, response);
			}
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
	}

}
