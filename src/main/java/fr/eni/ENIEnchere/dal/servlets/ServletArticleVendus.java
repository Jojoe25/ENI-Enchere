package fr.eni.ENIEnchere.dal.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.ArticleVendusManager;
import fr.eni.ENIEnchere.bo.ArticleVendus;

/**
 * Servlet implementation class ServletArticleVendus
 */
@WebServlet("/ServletArticleVendus")
public class ServletArticleVendus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletArticleVendus() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/articlevendus.jsp");
        rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String nom_article, description; 
		Integer prix_initial,prix_vente,no_utilisateur,no_categorie;
		LocalDate  date_debut_encheres, date_fin_encheres ;
        ArticleVendus u;
        nom_article=request.getParameter("nom_article");
        description=request.getParameter("description");
        date_debut_encheres= LocalDate.parse(request.getParameter("date_debut_encheres"));
        date_fin_encheres=LocalDate.parse(request.getParameter("date_fin_encheres"));
        prix_initial=Integer.parseInt(request.getParameter("prix_initial"));
        prix_vente=Integer.parseInt(request.getParameter("prix_initial"));
        no_utilisateur=Integer.parseInt(request.getParameter("prix_initial"));
        no_categorie=Integer.parseInt(request.getParameter("no_categorie"));
       
        
        
		u=new ArticleVendus( nom_article, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie);
        try {
            ArticleVendusManager.getInstance().ajouterArticleVendus(u);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

}
