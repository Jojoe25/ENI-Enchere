package fr.eni.ENIEnchere.bll;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.dal.DAOFactory;
import fr.eni.ENIEnchere.dal.FormulaireDAO;
import fr.eni.ENIEnchere.bo.Utilisateur;

public class FormulaireMananger {
	
	private FormulaireDAO formulaireDAO;
	
	public void FormulaireManager() {
		this.formulaireDAO = DAOFactory.getFormulaireDAO();
	}
	
	public Utilisateur ajouter(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		Utilisateur formulaire = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 0, false);
		
		this.validerPseudo(formulaire, exception);
		this.validerNom(formulaire, exception);
		this.validerPrenom(formulaire, exception);
		this.validerEmail(formulaire, exception);
		this.validerTelephone(formulaire, exception);
		this.validerRue(formulaire, exception);
		this.validerCodePostal(formulaire, exception);
		this.validerVille(formulaire, exception);
		this.validerMotDePasse(formulaire, exception);
		
		if(!exception.hasErreurs()) {
			this.formulaireDAO.insert(formulaire);
		}
		else {
			throw exception;
		}
		return formulaire;
	}

	private void validerMotDePasse(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getMot_de_passe()== null || formulaire.getMot_de_passe().length() < 6) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MOTDEPASSE_ERREUR);
			throw be;
		}
	}

	private void validerVille(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getVille()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_VILLE_ERREUR);
			throw be;
		}
	}

	private void validerCodePostal(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getCode_postal()== null || formulaire.getCode_postal().length() == 5) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CODEPOSTAL_ERREUR);
			throw be;
		}
	}

	private void validerRue(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getRue()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_RUE_ERREUR);
			throw be;
		}
	}

	private void validerPrenom(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getPrenom()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PRENOM_ERREUR);
			throw be;
		}
	}

	private void validerTelephone(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getTelephone()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_TELEPHONE_ERREUR);
			throw be;
		}
	}

	private void validerEmail(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getEmail()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_ERREUR);
			throw be;
		}
	}

	private void validerNom(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getNom()== null || formulaire.getNom().length() > 30) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NOM_ERREUR);
			throw be;
		}
	}

	private void validerPseudo(Utilisateur formulaire, BusinessException exception) throws BusinessException {
		if(formulaire.getPseudo()== null || formulaire.getPseudo().contains("@")) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR);
			throw be;
		}
	}
	
	
}
