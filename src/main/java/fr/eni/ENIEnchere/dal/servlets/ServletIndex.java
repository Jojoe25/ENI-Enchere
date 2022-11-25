package fr.eni.ENIEnchere.dal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.UtilisateurManager;

/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("/Index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Servlet pour se connecter
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /*
     * Servlet pour l'ajout de se connecter sur la page index.
     */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String identifiant = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        try {
            UtilisateurManager.getInstance().seConnecter(identifiant,mdp);
            response.sendRedirect("/index.html");
        } catch (BusinessException e) {
            request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
            request.getRequestDispatcher("WEB-INF/jsp/seconnecter.jsp").forward(request, response);
        }  
    }
}
