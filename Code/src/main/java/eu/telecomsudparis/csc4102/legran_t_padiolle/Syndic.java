package eu.telecomsudparis.csc4102.legran_t_padiolle;

import java.util.ArrayList;

import eu.telecomsudparis.csc4102.util.Console;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

public class Syndic {

	private static Syndic syndic;

	private ArrayList<Copropriete> listeCoproprietes;
	private ArrayList<Coproprietaire> listeCoproprietaires;
	private ArrayList<AssembleeGenerale> listeAGs;
	private AssembleeGenerale assembleeGeneraleEnCours;


	private Syndic(){
		listeCoproprietes = new ArrayList<Copropriete >();
		listeCoproprietaires = new ArrayList<Coproprietaire >();
		listeAGs = new ArrayList<AssembleeGenerale >();
	}

	public ArrayList<Copropriete> getListeCoproprietes() {
		return listeCoproprietes;
	}

	public ArrayList<Coproprietaire> getListeCoproprietaires() {
		return listeCoproprietaires;
	}

	public ArrayList<AssembleeGenerale> getListeAGs() {
		return listeAGs;
	}

	public static Syndic getInstance(){
		if(syndic == null){
			syndic = new Syndic();
		}
		return syndic;
	}

	//Ajouter une copropiete
	public void ajouterCopropriete() throws OperationImpossible{
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(isCoproprietePresente(adresseCopropriete)) {
			throw new OperationImpossible("La copropriete existe déjà");
		}
		new Copropriete(adresseCopropriete);

		System.out.println("Copropriété ajouté !");
	}

	public void afficherListeCoproprietes() throws OperationImpossible{
		for(int i=0; i<this.listeCoproprietes.size(); i++){
			System.out.println(this.listeCoproprietes.get(i).getAdresseCopropriete());
		}
	}

	public void afficherListeCoproprietaires() throws OperationImpossible{
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(chercherCopropriete(adresseCopropriete) == null) {
			throw new OperationImpossible("La copropriete n'existe pas");
		}
		Copropriete coprop = chercherCopropriete(adresseCopropriete);
		for(int i=0; i<coprop.getListeCoproprietaires().size(); i++){
			System.out.println(coprop.getListeCoproprietaires().get(i).toString());
		}
	}

	public void afficherListeAssembleesGenerales() throws OperationImpossible{
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(chercherCopropriete(adresseCopropriete) == null) {
			throw new OperationImpossible("La copropriete n'existe pas");
		}
		Copropriete coprop = chercherCopropriete(adresseCopropriete);
		for(int i=0; i<coprop.getListeAssembleesGenerales().size(); i++){
			System.out.println(coprop.getListeAssembleesGenerales().get(i).getNomAssembleeGenerale());
		}
	}

	//Ajouter un copropietaire
	public void ajouterCoproprietaire() throws OperationImpossible{
		String nom = null;
		try {
			nom = Console.readLine("Nom du copropriétaire \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		String prenom = null;
		try {
			prenom = Console.readLine("Prénom du copropriétaire \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		new Coproprietaire(nom, prenom);

		System.out.println("Copropriétaire ajouté !");
	}

	public void ajouterCoproprieteACoproprietaire() throws OperationImpossible{
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nom = null;
		try {
			nom = Console.readLine("Nom du copropriétaire \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		String prenom = null;
		try {
			prenom = Console.readLine("Prénom du copropriétaire \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Coproprietaire coproprietaire = chercherCoproprietaire(nom, prenom);
		double quotePart = 0;
		try {
			quotePart = Double.parseDouble(Console.readLine("Quote-part du copropriétaire \n"));
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		coproprietaire.ajouterCopropriete(copropriete, quotePart);

		System.out.println("Copropriété ajouté à copropriétaire !");
	}

	public void afficherQuotePart() throws OperationImpossible{
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		String nom = null;
		try {
			nom = Console.readLine("Nom du copropriétaire \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		String prenom = null;
		try {
			prenom = Console.readLine("Prénom du copropriétaire \n");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		double quotePart = 0;
		quotePart = chercherQuotePart(adresseCopropriete, nom, prenom);

		System.out.println("Quote-part du copropriétaire: " + quotePart);
	}

	//Ajouter assemblee generale
	public void ajouterAssembleeGenerale() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		if(copropriete == null) {
			throw new IllegalArgumentException("La copropriété n'existe pas");
		}
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(chercherAssembleeGenerale(copropriete, nomAssembleeGenerale) != null) {
			throw new OperationImpossible("L'assemblée générale existe déjà");
		}
		new AssembleeGenerale(nomAssembleeGenerale, copropriete);

		System.out.println("Assemblée générale créée !");
	}

	public void commencerAssembleeGenerale() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		if(copropriete == null) {
			throw new IllegalArgumentException("La copropriété n'existe pas");
		}
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale ag = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		ag.setStatut(EStatut.EN_COURS);

		System.out.println("L'Assemblée générale " + ag.getNomAssembleeGenerale() + " a commencé !");
	}

	public void afficherListeQuestions() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		if(copropriete == null) {
			throw new IllegalArgumentException("La copropriété n'existe pas");
		}
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale ag = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		for(int i=0; i<ag.getListeQuestions().size(); i++){
			System.out.println(ag.getListeQuestions().get(i).getSujetQuestion());
		}
	}

	public void afficherFeuilleDePresence() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		if(copropriete == null) {
			throw new IllegalArgumentException("La copropriété n'existe pas");
		}
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale ag = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		ag.afficherFeuillePresence();
	}



	public void terminerAssembleeGenerale() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		if(copropriete == null) {
			throw new IllegalArgumentException("La copropriété n'existe pas");
		}
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale ag = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		ag.setStatut(EStatut.TERMINEE);

		System.out.println("L'Assemblée générale " + ag.getNomAssembleeGenerale() + " est terminée !");
	}

	public AssembleeGenerale getAssembleeGeneraleEnCours() {
		return assembleeGeneraleEnCours;
	}

	public void setAssembleeGeneraleEnCours(AssembleeGenerale assembleeGeneraleEnCours) {
		this.assembleeGeneraleEnCours = assembleeGeneraleEnCours;
	}

	//creer question non votable
	public void creerQuestionNonVotable() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(assembleeGenerale.chercherQuestion(sujetQuestion) != null) {
			throw new OperationImpossible("La question existe déjà");
		}
		assembleeGenerale.ajouterQuestionNonVotable(sujetQuestion);

		System.out.println("Question non votable créée !");
	}

	public void ajouterCompteRendu() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		String compteRendu = null;
		try {
			compteRendu = Console.readLine("Compte-rendu");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(assembleeGenerale.chercherQuestion(sujetQuestion) == null) {
			throw new OperationImpossible("La question n'existe pas");
		}
		QuestionNonVotable question = (QuestionNonVotable) chercherQuestion(assembleeGenerale, sujetQuestion);
		question.setCompteRenduDiscussion(compteRendu);
		
		System.out.println("Compte-rendu ajouté !");
	}
	
	public void afficherCompteRendu() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question").toLowerCase();
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(assembleeGenerale.chercherQuestion(sujetQuestion) == null) {
			throw new OperationImpossible("La question n'existe pas");
		}
		QuestionNonVotable question = (QuestionNonVotable) chercherQuestion(assembleeGenerale, sujetQuestion);
		System.out.println(question.getCompteRenduDiscussion());
	}

	//creer question votable
	public void ajouterQuestionVotableMajoriteSimple() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question").toLowerCase();
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(assembleeGenerale.chercherQuestion(sujetQuestion) != null) {
			throw new OperationImpossible("La question existe déjà");
		}
		CalculMajoriteSimple calculMajoriteSimple = new CalculMajoriteSimple();
		assembleeGenerale.ajouterQuestionVotable(sujetQuestion, calculMajoriteSimple);

		System.out.println("Question votable à majorité simple créée !");
	}

	public void ajouterQuestionVotableMajoriteAbsolue() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question").toLowerCase();
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(assembleeGenerale.chercherQuestion(sujetQuestion) != null) {
			throw new OperationImpossible("La question existe déjà");
		}
		CalculMajoriteAbsolue calculMajoriteAbsolue = new CalculMajoriteAbsolue();
		assembleeGenerale.ajouterQuestionVotable(sujetQuestion, calculMajoriteAbsolue);

		System.out.println("Question votable à majorité absolue créée !");
	}

	public void ajouterQuestionVotableMajoriteDouble() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question").toLowerCase();
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(assembleeGenerale.chercherQuestion(sujetQuestion) != null) {
			throw new OperationImpossible("La question existe déjà");
		}
		CalculMajoriteDouble calculMajoriteDouble = new CalculMajoriteDouble();
		assembleeGenerale.ajouterQuestionVotable(sujetQuestion, calculMajoriteDouble);

		System.out.println("Question votable à majorité simple créée !");
	}
	public void procederVoteQuestion() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(chercherQuestion(assembleeGenerale, sujetQuestion) == null){
			throw new OperationImpossible("La question n'existe pas");
		}
		QuestionVotable question = (QuestionVotable) chercherQuestion(assembleeGenerale, sujetQuestion);
		
		for(int i=0; i<assembleeGeneraleEnCours.getFichesPresencePhysique().size(); i++){
			Coproprietaire coproprietaire = assembleeGenerale.getFichesPresencePhysique().get(i).getCoproprietaire();
			String vote = null;
			try {
				vote = Console.readLine(coproprietaire.getNom() + " " + coproprietaire.getPrenom() + " Oui, non ou abstention ?").toLowerCase();
			} catch (Exception e) {
				System.err.println("Erreur de saisie");
			}
			if(vote == null){
				throw new IllegalStateException("Erreur lors du vote");
			}
			question.ajouterVoteCoproprietaire(coproprietaire, stringToEvote(question, coproprietaire, vote));
		}
		
		for(int i=0; i<assembleeGenerale.getFichesReprensentation().size(); i++){
			Coproprietaire coproprietaire = assembleeGenerale.getFichesReprensentation().get(i).getCoproprietaire();
			String vote = null;
			try {
				vote = Console.readLine(coproprietaire.getNom() + " " + coproprietaire.getPrenom() + " Oui, non ou abstention ?").toLowerCase();
			} catch (Exception e) {
				System.err.println("Erreur de saisie");
			}
			if(vote == null){
				throw new IllegalStateException("Erreur lors du vote");
			}
			question.ajouterVoteCoproprietaire(coproprietaire, stringToEvote(question, coproprietaire, vote));
		}
		question.calculerIssueVote();
		question.afficherResultatVote();

		System.out.println("Le vote est terminé !");
	}
	
	public void afficherResultatVote() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		String sujetQuestion = null;
		try {
			sujetQuestion = Console.readLine("Sujet Question");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		if(chercherQuestion(assembleeGenerale, sujetQuestion) == null){
			throw new OperationImpossible("La question n'existe pas");
		}
		QuestionVotable question = (QuestionVotable) chercherQuestion(assembleeGenerale, sujetQuestion);
		question.afficherResultatVote();
	}
	
	public void afficherProcesVerbal() throws OperationImpossible {
		String adresseCopropriete = null;
		try {
			adresseCopropriete = Console.readLine("Adresse de la copropriete");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		String nomAssembleeGenerale = null;
		try {
			nomAssembleeGenerale = Console.readLine("Nom assemblee generale");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		AssembleeGenerale assembleeGenerale = chercherAssembleeGenerale(copropriete, nomAssembleeGenerale);
		assembleeGenerale.afficherProcesVerbal();
		
	}
	
	public Evote stringToEvote(QuestionVotable question, Coproprietaire coproprietaire, String vote){
		if(vote.toLowerCase().equals("oui")){
			return Evote.OUI;
		} else if(vote.toLowerCase().equals("non")){
			return Evote.NON;
		} else if(vote.toLowerCase().equals("abstention")){
			return Evote.ABSTENTION;
		} else {
			throw new IllegalStateException("Vote incorrect");
		}
	}

	public Question chercherQuestion(AssembleeGenerale ag, String sujetQuestion) {
		for(int i=0; i<ag.getListeQuestions().size(); i++) {
			if(ag.getListeQuestions().get(i).getSujetQuestion().equals(sujetQuestion)) {
				if(ag.getListeQuestions().get(i) instanceof QuestionVotable){
					return (QuestionVotable) ag.getListeQuestions().get(i);
				}
				if(ag.getListeQuestions().get(i) instanceof QuestionNonVotable){
					return (QuestionNonVotable) ag.getListeQuestions().get(i);
				}
			};
		}
		return null;
	}

	public void ajouterCopropriete(String adresseCopropriete) throws OperationImpossible{
		if(adresseCopropriete == null) {
			throw new IllegalArgumentException("Adresse incorrecte :" + adresseCopropriete);
		}
		if(!isCoproprietePresente(adresseCopropriete)){
			Copropriete copropriete = new Copropriete(adresseCopropriete);
			listeCoproprietes.add(copropriete);
		} else{
			throw new OperationImpossible("Copropriete déjà présente");
		}
	}

	public Copropriete chercherCopropriete(String adresseCopropriete) {
		for(int i=0; i<listeCoproprietes.size(); i++) {
			if(listeCoproprietes.get(i).getAdresseCopropriete().equals(adresseCopropriete)) {
				return listeCoproprietes.get(i);
			};
		}
		return null;
	}

	public boolean isCoproprietePresente(String adresseCopropriete){
		return chercherCopropriete(adresseCopropriete) != null;
	}

	public Coproprietaire chercherCoproprietaire(String nom, String prenom) {
		for(int i=0; i<listeCoproprietaires.size(); i++) {
			if((listeCoproprietaires.get(i).getNom().equals(nom)) && (listeCoproprietaires.get(i).getPrenom().equals(prenom))) {
				return listeCoproprietaires.get(i);
			};
		}
		return null;
	}

	public double chercherQuotePart(String adresseCopropriete, String nom, String prenom) {
		Copropriete copropriete = chercherCopropriete(adresseCopropriete);
		Coproprietaire coproprietaire = chercherCoproprietaire(nom, prenom);
		return coproprietaire.getMapCoproprietes().get(copropriete);
	}

	public AssembleeGenerale chercherAssembleeGenerale(Copropriete copropriete, String nomAssembleeGenerale) {
		for(int i=0; i<copropriete.getListeAssembleesGenerales().size(); i++) {
			if(copropriete.getListeAssembleesGenerales().get(i).getNomAssembleeGenerale().equals(nomAssembleeGenerale)) {
				return copropriete.getListeAssembleesGenerales().get(i);
			};
		}
		return null;
	}

}
