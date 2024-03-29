package fr.eni.ibaie.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletDeDeconnexion")
public class ServletDeDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletDeDeconnexion() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/deconnexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        session.invalidate();
        
        this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);

	}

}
