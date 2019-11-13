package fr.eni.ibaie.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ibaie.BusinessException;
import fr.eni.ibaie.bll.UtilisateurManager;

	

	@WebServlet("/ServletMdpOublie")
	public class ServletMdpOublie extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
        
 

    public ServletMdpOublie() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/mdpOublie.jsp").forward(request, response);	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		System.out.println(email);
		try {
			UtilisateurManager UserM =new UtilisateurManager();
			//Récupération du mot de passe Utilisateurs
			String Mdp = UserM.mdpOublie(email);
			
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/RenduMdp.jsp").forward(request, response);
		
	}

}
