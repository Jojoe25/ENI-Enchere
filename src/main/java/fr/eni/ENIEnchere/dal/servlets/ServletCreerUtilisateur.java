package fr.eni.ENIEnchere.dal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.FormulaireMananger;
import fr.eni.ENIEnchere.bo.Utilisateur;

import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation
 */
@WebServlet("/ServletCreerUtilisateur")
public class ServletCreerUtilisateur extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public ServletCreerUtilisateur() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/formulaire.jsp");
        rd.forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String pseudo,  nom,  prenom,  email,  telephone,  rue, code_postal, ville, mot_de_passe;
        int credit = 0;
        boolean administrateur = false;
        Utilisateur u;
        pseudo=request.getParameter("pseudo");
        nom=request.getParameter("nom");
        prenom=request.getParameter("prenom");
        email=request.getParameter("email");
        telephone=request.getParameter("telephone");
        rue=request.getParameter("rue");
        code_postal=request.getParameter("code_postal");
        ville=request.getParameter("ville");
        mot_de_passe=request.getParameter("mot_de_passe");
        
        
        u=new Utilisateur( pseudo,  nom,  prenom,  email,  telephone,  rue, code_postal, ville, mot_de_passe, credit, administrateur);
        try {
            FormulaireMananger.getInstance().ajouterUtilisateur(u);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}