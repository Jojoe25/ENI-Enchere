package fr.eni.ENIEnchere.dal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.UtilisateurManager;
import fr.eni.ENIEnchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletDeleteProfil
 */
@WebServlet("/supprimerUser")
public class ServletDeleteProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeleteProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("User");
		
		
	//		try {
	//			UtilisateurManager.supprimerUtilisateur(user.getUtilisateurId());
				session.removeAttribute("User");
				session.invalidate();
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Index");
				dispatcher.forward(request, response);
	//		} catch (BusinessException e) {
	//			e.printStackTrace();
	//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Profil");
				dispatcher.forward(request, response);
				
	//		}
		
		
	}

}