package fr.eni.ENIEnchere.bll;

import fr.eni.ENIEnchere.bo.Utilisateur;
import fr.eni.ENIEnchere.dal.DAOFactory;
import fr.eni.ENIEnchere.dal.UtilisateurDAO;
import fr.eni.ENIEnchere.BusinessException;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;
	private static UtilisateurManager instance;

	private UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public Utilisateur seConnecter(String identifiant, String mdp) throws BusinessException {
		Utilisateur user = null;
		if (identifiant.contains("@")) user = utilisateurDAO.getUtilisateurByMail(identifiant);
		else user= utilisateurDAO.getUtilisateurByPseudo(identifiant);
		
		if (user == null || !mdp.equals(user.getMot_de_passe())) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.IDENTIFIANT_KO);
			throw be;
		}
		return user;
	}

	public Utilisateur afficherUtilisateur(String pseudo) throws BusinessException {
		return utilisateurDAO.getUtilisateurByPseudo(pseudo);	
	}

	public void modifierUtilisateur (Utilisateur utilisateur) throws BusinessException {
		utilisateurDAO.updateById(utilisateur);}
	
	public Utilisateur modifierUtilisateur (String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe,int credit,boolean administrateur) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		Utilisateur User = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe);
		
		this.validerPseudo(User, exception);
		this.validerNom(User, exception);
		this.validerPrenom(User, exception);
		this.validerEmail(User, exception);
		this.validerTelephone(User, exception);
		this.validerRue(User, exception);
		this.validerCodePostal(User, exception);
		this.validerVille(User, exception);
		this.validerMotDePasse(User, exception);
		
		if(!exception.hasErreurs()) {
			utilisateurDAO.updateById(User);
		}
		else {
			throw exception;
		}
		return User;
	}

	private void validerMotDePasse(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getMot_de_passe()== null || User.getMot_de_passe().length() < 6) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MOTDEPASSE_ERREUR);
			throw be;
		}
	}

	private void validerVille(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getVille()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_VILLE_ERREUR);
			throw be;
		}
	}

	private void validerCodePostal(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getCode_postal()== null || User.getCode_postal().length() == 5) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CODEPOSTAL_ERREUR);
			throw be;
		}
	}

	private void validerRue(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getRue()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_RUE_ERREUR);
			throw be;
		}
	}

	private void validerPrenom(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getPrenom()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PRENOM_ERREUR);
			throw be;
		}
	}

	private void validerTelephone(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getTelephone()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_TELEPHONE_ERREUR);
			throw be;
		}
	}

	private void validerEmail(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getEmail()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_ERREUR);
			throw be;
		}
	}

	private void validerNom(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getNom()== null || User.getNom().length() > 30) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NOM_ERREUR);
			throw be;
		}
	}

	private void validerPseudo(Utilisateur User, BusinessException exception) throws BusinessException {
		if(User.getPseudo()== null || User.getPseudo().contains("@")) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR);
			throw be;
		}
	}
	
}
