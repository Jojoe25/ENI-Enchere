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

@WebServlet("/seconnecter")
public class ServletSeConnecter extends HttpServlet {
    private static final long serialVersionUID = 1l;
    public ServletSeConnecter(){

    }
    /**
     * @see HttpServletlet#doget(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("WEB-INF/jsp/seconnecter.jsp").forward(request, response);
    }
    /**
     * @see HttpServletlet#doget(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String identifiant = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        Utilisateur user =null;
        
        try {
            user = UtilisateurManager.getInstance().seConnecter(identifiant,mdp);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("Index");
        } catch (BusinessException e) {
            request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
            request.getRequestDispatcher("WEB-INF/jsp/seconnecter.jsp").forward(request, response);
        }  
    }
}