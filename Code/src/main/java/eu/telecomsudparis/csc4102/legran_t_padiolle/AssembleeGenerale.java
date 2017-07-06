package eu.telecomsudparis.csc4102.legran_t_padiolle;

import java.time.LocalDate;
import java.util.ArrayList;

import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

public class AssembleeGenerale {

	@Override
	public String toString() {
		return "AssembleeGenerale [nomAssembleeGenerale=" + nomAssembleeGenerale + ", dateAssembleeGenerale="
				+ dateAssembleeGenerale + ", statut=" + statut + ", copropriete=" + copropriete + "]";
	}

	private String nomAssembleeGenerale;
	private LocalDate dateAssembleeGenerale;
	private EStatut statut;

	public final static int maxMandataire = 3;


	private Syndic syndic = Syndic.getInstance();
	private Copropriete copropriete;
	private ArrayList<Question> listeQuestions = new ArrayList<Question>();
	private ArrayList<QuestionVotable> listeQuestionsVotables = new ArrayList<QuestionVotable>();
	private ArrayList<QuestionNonVotable> listeQuestionsNonVotables = new ArrayList<QuestionNonVotable>();
	private ArrayList<FicheDePresence> feuilleDePresence = new ArrayList<FicheDePresence>();
	private ArrayList<FicheDePresencePhysique> fichesPresencePhysique = new ArrayList<FicheDePresencePhysique>();
	private ArrayList<FicheDeRepresentation> fichesReprensentation = new ArrayList<FicheDeRepresentation>();

	/**
	 * Crée une assemblée générale à partir du nom de l'assemblée générale et en
	 * renseignant une {@link Copropriete}.
	 * <p>
	 * Le constructeur vérifie que le nom de l'assemblée générale est non null,
	 * et que la copropriété est non null.
	 *
	 * @param nomAssembleeGenerale
	 *            nom de l'assemblée générale à créer
	 * @param copropriete
	 *            copropriété donnant lieu à l'assemblée générale
	 * @return the image at the specified URL
	 * @see Image
	 */
	public AssembleeGenerale(String nomAssembleeGenerale, Copropriete copropriete) {
		if (nomAssembleeGenerale == null) {
			throw new IllegalArgumentException("Nom incorrect: " + nomAssembleeGenerale);
		}
		if (copropriete == null) {
			throw new IllegalArgumentException("Copropriete incorrecte: " + copropriete);
		}
		this.nomAssembleeGenerale = nomAssembleeGenerale;
		this.dateAssembleeGenerale = Datutil.aujourdhui();
		this.copropriete = copropriete;
		this.statut = EStatut.NON_DEBUTEE;
		copropriete.ajouterAssembleeGenerale(this);
		syndic.getListeAGs().add(this);
	}

	public void ajouterAssembleeGenerale(Copropriete copropriete) {
		if (copropriete == null) {
			throw new IllegalArgumentException("Copropriete incorrecte: " + copropriete);
		}
		this.copropriete = copropriete;
		copropriete.setAssembleeGenerale(this);
		copropriete.getListeAssembleesGenerales().add(this);
	}

	/**
	 * Section relative aux paramètres de l'assemblée générale.
	 */

	/**
	 * @return nom de l'{@link AssembleeGenerale}.
	 */
	public String getNomAssembleeGenerale() {
		return nomAssembleeGenerale;
	}

	/**
	 * Modifie le nom de l'{@link AssembleeGenerale}.
	 * 
	 * @param nomAssembleeGenerale
	 */
	public void setNomAssembleeGenerale(String nomAssembleeGenerale) {
		this.nomAssembleeGenerale = nomAssembleeGenerale;
	}

	/**
	 * @return la date de l'{@link AssembleeGenerale}
	 */
	public LocalDate getDateAssembleeGenerale() {
		return dateAssembleeGenerale;
	}

	/**
	 * Modifie la date de l'{@link AssembleeGenerale}.
	 * 
	 * @param dateAssembleeGenerale
	 */
	public void setDateAssembleeGenerale(LocalDate dateAssembleeGenerale) {
		this.dateAssembleeGenerale = dateAssembleeGenerale;
	}

	/**
	 * @return la {@link Copropriete} faisant l'objet de
	 *         l'{@link AssembleeGenerale}.
	 */
	public Copropriete getCopropriete() {
		return copropriete;
	}

	/**
	 * Définit la {@link Copropriete} faisant l'objet de
	 * l'{@link AssembleeGenerale}.
	 * 
	 * @param copropriete
	 */
	public void setCopropriete(Copropriete copropriete) {
		this.copropriete = copropriete;
	}

	/**
	 * @return liste des {@link Question}.
	 */
	public ArrayList<Question> getListeQuestions() {
		return listeQuestions;
	}

	/**
	 * Section relative au statut de l'assemblée générale.
	 */

	/**
	 * Méthode commençant l'{@link AssembleeGenerale}.
	 */
	public void commencerAssembleeGenerale() {
		this.statut = EStatut.EN_COURS;
		syndic.setAssembleeGeneraleEnCours(this);
	}

	/**
	 * Méthode terminant l'{@link AssembleeGenerale}.
	 */
	public void terminerAssembleeGenerale() {
		this.statut = EStatut.TERMINEE;
		syndic.setAssembleeGeneraleEnCours(null);
	}

	/**
	 * @return si l'{@link AssembleeGenerale} est non débutée.
	 */
	public boolean isNonDebutee() {
		return (this.statut == EStatut.NON_DEBUTEE);
	}

	/**
	 * @return si l'{@link AssembleeGenerale} est en cours.
	 */
	public boolean isEnCours() {
		return (this.statut == EStatut.EN_COURS);
	}

	/**
	 * @return si l'{@link AssembleeGenerale} est terminée.
	 */
	public boolean isTerminee() {
		return (this.statut == EStatut.TERMINEE);
	}

	/**
	 * @return statut de l'{@link AssembleeGenerale}.
	 */
	public EStatut getStatut() {
		return statut;
	}

	/**
	 * Définit le statut de l'{@link AssembleeGenerale}.
	 * 
	 * @param statut
	 *            de l'assemblée générale
	 */
	public void setStatut(EStatut statut) {
		this.statut = statut;
	}

	/**
	 * Section relative aux questions
	 */

	/**
	 * Détermine si une {@link Question} est présente.
	 * 
	 * @param sujetQuestion
	 *            sujet de la question
	 * @return si la question est présente
	 */
	public boolean isQuestionPresente(String sujetQuestion) {
		return chercherQuestion(sujetQuestion) != null;
	}

	/**
	 * Cherche la {@link Question} dans la liste des questions.
	 * 
	 * @param sujetQuestion
	 *            sujet de la question
	 * @return la question si elle existe, null sinon
	 */
	public Question chercherQuestion(String sujetQuestion) {
		for (int i = 0; i < listeQuestions.size(); i++) {
			if (listeQuestions.get(i).getSujetQuestion().equals(sujetQuestion)) {
				return listeQuestions.get(i);
			}
			;
		}
		return null;
	}
	
	/**
	 * Ajoute la {@link Question} à la liste des questions, après vérififaction
	 * que le sujet et la stratégie de calcul sont non null, 
	 * et que la question est non déjà présente.
	 * 
	 * @param sujetQuestion sujet de la question à ajouter
	 * @param strategieDeCalculVote à implémenter pour la question
	 * @throws OperationImpossible si la question existe déjà
	 */
	public void ajouterQuestionVotable(String sujetQuestion, StrategieDeCalculVote strategieDeCalculVote) throws OperationImpossible {
		if (sujetQuestion == null) {
			throw new IllegalArgumentException("Sujet question incorrect: " + sujetQuestion);
		}
		if (isQuestionPresente(sujetQuestion)) {
			throw new OperationImpossible("Question déjà présente");
		}
		QuestionVotable question = new QuestionVotable(sujetQuestion, strategieDeCalculVote);
		listeQuestions.add(question);
		listeQuestionsVotables.add(question);
	}
	
	/**
	 * Ajoute la {@link Question} à la liste des questions, après vérififaction
	 * que le sujet et la stratégie de calcul sont non null, 
	 * et que la question est non déjà présente.
	 * 
	 * @param question à ajouter
	 * @throws OperationImpossible si la question existe déjà
	 */
	public void ajouterQuestionVotable(QuestionVotable question) throws OperationImpossible {
		if (question == null) {
			throw new IllegalArgumentException("Question incorrect: " + question);
		}
		listeQuestions.add(question);
	}
	
	/**
	 * Ajoute la {@link Question} à la liste des questions, après vérififaction
	 * que le sujet et la stratégie de calcul sont non null, 
	 * et que la question est non déjà présente.
	 * 
	 * @param sujetQuestion sujet de la question à ajouter
	 * @param strategieDeCalculVote à implémenter pour la question
	 * @throws OperationImpossible si la question existe déjà
	 */
	public void ajouterQuestionNonVotable(String sujetQuestion) throws OperationImpossible {
		if (sujetQuestion == null) {
			throw new IllegalArgumentException("Sujet question incorrect: " + sujetQuestion);
		}
		if (isQuestionPresente(sujetQuestion)) {
			throw new OperationImpossible("Question déjà présente");
		}
		QuestionNonVotable question = new QuestionNonVotable(sujetQuestion);
		listeQuestions.add(question);
		listeQuestionsNonVotables.add(question);
	}

	/**
	 * Section relative aux copropriétaires
	 */

	/**
	 * Ajoute un {@link Coproprietaire} présent, sous réserve qu'il existe.
	 * 
	 * @param coproprietaire
	 */
	public void ajouterCoproprietairePresent(Coproprietaire coproprietaire) {
		if (coproprietaire == null) {
			throw new IllegalArgumentException("Coproprietaire incorrect: " + coproprietaire);
		}
		FicheDePresencePhysique ficheDePresencePhysique = new FicheDePresencePhysique(coproprietaire);
		feuilleDePresence.add(ficheDePresencePhysique);
		fichesPresencePhysique.add(ficheDePresencePhysique);
	}

	/**
	 * Ajoute un {@link Coproprietaire} représenté, sous réserve qu'il existe et
	 * que le mandataire existe.
	 * 
	 * @param coproprietaire
	 *            mandant
	 * @param mandataire
	 *            copropriétaire recevant le mandat
	 */
	public void ajouterCoproprietaireRepresentation(Coproprietaire coproprietaire, Coproprietaire mandataire) {
		if (coproprietaire == null) {
			throw new IllegalArgumentException("Coproprietaire incorrect: " + coproprietaire);
		}
		if (mandataire == null) {
			throw new IllegalArgumentException("Mandataire incorrect: " + mandataire);
		}
		FicheDeRepresentation ficheDeRepresentation = new FicheDeRepresentation(coproprietaire, mandataire);
		feuilleDePresence.add(ficheDeRepresentation);
		fichesReprensentation.add(ficheDeRepresentation);
	}

	/**
	 * Vérifie si un mandataire peut recevoir un mandat.
	 * 
	 * @param mandataire
	 *            voulant recevoir un mandat
	 * @return s'il peut recevoir un mandat
	 */
	public boolean isMandatPossible(Coproprietaire mandataire) {
		ArrayList<FicheDeRepresentation> listeMandatsEffectifs = new ArrayList<FicheDeRepresentation>();
		for(int i=0; i<this.getFichesReprensentation().size(); i++){
			if(this.getFichesReprensentation().get(i).getMandataire().equals(mandataire)){
				listeMandatsEffectifs.add(this.getFichesReprensentation().get(i));
			}
		}
		long nombreMandatsEffectifs = listeMandatsEffectifs.size();
		if (nombreMandatsEffectifs > 3) {
			int sommeQuoteParts = 0;
			for (FicheDeRepresentation fiche : listeMandatsEffectifs) {
				double quotePart = fiche.getCoproprietaire().getMapCoproprietes().get(this.getCopropriete());
				sommeQuoteParts += quotePart;
			}
			if (sommeQuoteParts > 0.05) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Cherche si le {@link Coproprietaire} a rempli une fiche de présence.
	 * 
	 * @param coproprietaire
	 *            à vérifier
	 * @return s'il a rempli une fiche de présence
	 */
	public boolean hasFicheDePresence(Coproprietaire coproprietaire) {
		if (coproprietaire == null) {
			throw new IllegalArgumentException("Coproprietaire incorrect: " + coproprietaire);
		}
		for (int i = 0; i < feuilleDePresence.size(); i++) {
			if (feuilleDePresence.get(i).getCoproprietaire().equals(coproprietaire)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return liste des {@link FicheDePresence}.
	 */
	public ArrayList<FicheDePresence> getFeuilleDePresence() {
		return feuilleDePresence;
	}

	/**
	 * @return liste des {@link FicheDePresencePhysique}.
	 */
	public ArrayList<FicheDePresencePhysique> getFichesPresencePhysique() {
		return fichesPresencePhysique;
	}

	/**
	 * @return la liste des {@link FicheDeRepresentation}.
	 */
	public ArrayList<FicheDeRepresentation> getFichesReprensentation() {
		return fichesReprensentation;
	}

	/**
	 * Section relative aux votes
	 */

	/**
	 * Vérifie si le {@link Coproprietaire} a déjà voté.
	 * 
	 * @param coproprietaire
	 *            à vérifier
	 * @return si le copropriétaire a voté
	 */
	public boolean hasVote(Coproprietaire coproprietaire) {
		int nombreFiches = this.feuilleDePresence.size();
		for (int i = 0; i < nombreFiches; i++) {
			if (feuilleDePresence.get(i).getCoproprietaire().equals(coproprietaire)) {
				return feuilleDePresence.get(i).hasVote();
			}
		}
		throw new IllegalArgumentException("Coproprietaire non présent ou représenté");
	}

	/**
	 * Définit si le {@link Coproprietaire} a déjà voté.
	 * 
	 * @param coproprietaire
	 *            à vérifier
	 */
	public void setHasVote(Coproprietaire coproprietaire) {
		int nombreFiches = this.feuilleDePresence.size();
		for (int i = 0; i < nombreFiches; i++) {
			if (feuilleDePresence.get(i).getCoproprietaire().equals(coproprietaire)) {
				feuilleDePresence.get(i).setHasVote(true);
			}
		}
	}
	
	/**
	 * Affiche la liste des questions votables et leur résultat
	 */
	public void afficherQuestionsVotables() {
		System.out.println("--------------------------------------------------");
		System.out.println("Affichage des questions votables");
		for(int i=0; i<this.listeQuestionsVotables.size(); i++){
			System.out.println("");
			System.out.println(this.listeQuestionsVotables.get(i).getSujetQuestion());
			this.listeQuestionsVotables.get(i).afficherResultatVote();
		}
	}
	
	/**
	 * Affiche la liste des questions non votables et leur compte rendu
	 */
	public void afficherQuestionsNonVotables() {
		System.out.println("--------------------------------------------------");
		System.out.println("Affichage des questions non votables");
		for(int i=0; i<this.listeQuestionsNonVotables.size(); i++){
			System.out.println("");
			System.out.println(this.listeQuestionsNonVotables.get(i).getSujetQuestion());
			System.out.println(this.listeQuestionsNonVotables.get(i).getCompteRenduDiscussion());
		}
	}
	
	/**
	 * affiche l'ensemble des copropriétaires présents ou représentés au cours d'une assemblée générale
	 */
	public void afficherFeuillePresence() {
		System.out.println("--------------------------------------------------");
		System.out.println("Affichage de la feuille de présence");
		for(int i=0; i<this.getFichesPresencePhysique().size(); i++){
			System.out.println(this.getFichesPresencePhysique().get(i).getCoproprietaire().getNom()
					+ " " + this.getFichesPresencePhysique().get(i).getCoproprietaire().getPrenom());
		}
		for(int i=0; i<this.getFichesReprensentation().size(); i++){
			System.out.println(this.getFichesReprensentation().get(i).getCoproprietaire().getNom()
					+ " " + this.getFichesReprensentation().get(i).getCoproprietaire().getPrenom()
					+ " représenté par " + this.getFichesReprensentation().get(i).getMandataire().getNom()
					+ " " + this.getFichesReprensentation().get(i).getMandataire().getPrenom());
		}
	}
	
	/**
	 * affiche la feuille de présence et l'ensemble des questions de l'ordre du jour
	 */
	public void afficherProcesVerbal(){
		this.afficherFeuillePresence();
		this.afficherQuestionsVotables();
		this.afficherQuestionsNonVotables();
		
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssembleeGenerale other = (AssembleeGenerale) obj;
		if (copropriete == null) {
			if (other.copropriete != null)
				return false;
		} else if (!copropriete.equals(other.copropriete))
			return false;
		if (dateAssembleeGenerale == null) {
			if (other.dateAssembleeGenerale != null)
				return false;
		} else if (!dateAssembleeGenerale.equals(other.dateAssembleeGenerale))
			return false;
		if (nomAssembleeGenerale == null) {
			if (other.nomAssembleeGenerale != null)
				return false;
		} else if (!nomAssembleeGenerale.equals(other.nomAssembleeGenerale))
			return false;
		if (statut != other.statut)
			return false;
		return true;
	}

	public ArrayList<QuestionVotable> getListeQuestionsVotables() {
		return listeQuestionsVotables;
	}

	public ArrayList<QuestionNonVotable> getListeQuestionsNonVotables() {
		return listeQuestionsNonVotables;
	}

}
