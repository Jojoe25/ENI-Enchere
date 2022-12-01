package fr.eni.ENIEnchere.dal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.UtilisateurManager;
import fr.eni.ENIEnchere.bo.Utilisateur;



/**
 * Servlet implementation class ServletProfil
 */
@WebServlet("/Profil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pseudo = request.getParameter("pseudo");
			Utilisateur user= null;
			if (pseudo != null) {
				try {
					user = UtilisateurManager.getInstance().afficherUtilisateur(pseudo);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 

			else {
				user= (Utilisateur)request.getSession().getAttribute("user");		
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}	
}