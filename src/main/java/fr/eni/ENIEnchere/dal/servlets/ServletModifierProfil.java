package fr.eni.ENIEnchere.dal.servlets;

import java.io.IOException;

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
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/modifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			Utilisateur user = (Utilisateur) session.getAttribute("user");

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String mot_de_passe = request.getParameter("mot_de_passe");
		String new_mot_de_passe = request.getParameter("new_mot_de_passe");
		String confirmation = request.getParameter("new_mot_de_passe_confirmation");
		user.setPseudo(pseudo);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setRue(rue);
		user.setCode_postal(code_postal);
		user.setVille(ville);

		if (mot_de_passe.equals(user.getMot_de_passe()) && new_mot_de_passe.equals(confirmation)) {
			user.setMot_de_passe(new_mot_de_passe);
		}

		try {
			UtilisateurManager.getInstance().modifierUtilisateur(user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("User", user);
			this.getServletContext().getRequestDispatcher("/Profil").forward(request, response);
	}
}