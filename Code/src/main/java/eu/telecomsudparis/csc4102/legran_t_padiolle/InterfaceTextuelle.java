package eu.telecomsudparis.csc4102.legran_t_padiolle;

import eu.telecomsudparis.csc4102.util.Console;
import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Menu d'utilisation de l'application.
 */
public class InterfaceTextuelle {

	/**
	 * Reference sur l'instance.
	 */
	private static Syndic facade = null;

	/**
	 * Fonction main.
	 */
	public static void main(final String[] args) {
		facade = Syndic.getInstance();

		initialisationDonnees();

		try {

			int choix;
			int choixCopropriete;
			int choixCoproprietaire;
			int choixAssembleeGenerale;
			int choixQuestion;
			int choixVote;
			while ((choix = menuPrincipal()) > 0) {
				switch (choix) {

				case 1:
					while ((choixCopropriete = menuCoproprietes()) > 0) {
						switch (choixCopropriete) {
						case 1:
							ajouterCopropriete();
							break;
						case 2:
							afficherListeCoproprietes();
							break;
						case 3:
							afficherListeCoproprietaires();
							break;
						case 4:
							afficherListeAssembleesGenerales();
							;
							break;
						}

					}
					break;

				case 2:
					while ((choixCoproprietaire = menuCoproprietaires()) > 0) {
						switch (choixCoproprietaire) {
						case 1:
							ajouterCoproprietaire();
							break;
						case 2:
							ajouterCoproprieteACoproprietaire();
							break;
						case 3:
							afficherQuotePart();
							break;
						}
					}
					break;

				case 3:
					while ((choixAssembleeGenerale = menuAssembleesGenerales()) > 0) {
						switch (choixAssembleeGenerale) {
						case 1:
							ajouterAssembleeGenerale();
							break;
						case 2:
							commencerAssembleeGenerale();
							break;
						case 3:
							afficherListeQuestions();
							break;
						case 4:
							afficherFeuilleDePresence();
							break;
						case 5:
							terminerAssembleeGenerale();
							break;
						case 6:
							afficherProcesVerbal();
							break;
						}
					}
					break;

				case 4:
					while ((choixQuestion = menuQuestions()) > 0) {
						switch (choixQuestion) {
						case 1:
							ajouterQuestionVotableMajoriteSimple();
							break;
						case 2:
							ajouterQuestionVotableMajoriteAbsolue();
							break;
						case 3:
							ajouterQuestionVotableMajoriteDouble();
							break;
						case 4:
							ajouterQuestionNonVotable();
							break;
						case 5:
							ajouterCompteRendu();
							break;
						case 6:
							afficherCompteRendu();
							break;
						}
					}
					break;

				case 5:
					while ((choixVote = menuVotes()) > 0) {
						switch (choixVote) {
						case 1:
							procederVoteQuestion();
							break;
						case 2:
							afficherResultatVote();
							break;
						}
					}
					break;

				default:
					break;
				}
			}
		} catch (OperationImpossible op) {
			System.out.println("Erreur Menu : " + op);
		}
	}

	private static void initialisationDonnees() {
		Copropriete copropriete1 = new Copropriete("Copropriete 1");
		Copropriete copropriete2 = new Copropriete("Copropriete 2");
		Copropriete copropriete3 = new Copropriete("Copropriete 3");
		Coproprietaire coproprietaire1 = new Coproprietaire("Nom 1", "Prenom 1");
		Coproprietaire coproprietaire2 = new Coproprietaire("Nom 2", "Prenom 2");
		Coproprietaire coproprietaire3 = new Coproprietaire("Nom 3", "Prenom 3");
		Coproprietaire coproprietaire4 = new Coproprietaire("Nom 4", "Prenom 4");
		Coproprietaire coproprietaire5 = new Coproprietaire("Nom 5", "Prenom 5");
		Coproprietaire coproprietaire6 = new Coproprietaire("Nom 6", "Prenom 6");
		Coproprietaire coproprietaire7 = new Coproprietaire("Nom 7", "Prenom 7");
		Coproprietaire coproprietaire8 = new Coproprietaire("Nom 8", "Prenom 8");
		Coproprietaire coproprietaire9 = new Coproprietaire("Nom 9", "Prenom 9");
		coproprietaire1.ajouterCopropriete(copropriete1, 0.4);
		coproprietaire2.ajouterCopropriete(copropriete1, 0.4);
		coproprietaire3.ajouterCopropriete(copropriete1, 0.2);
		coproprietaire4.ajouterCopropriete(copropriete2, 0.4);
		coproprietaire5.ajouterCopropriete(copropriete2, 0.4);
		coproprietaire6.ajouterCopropriete(copropriete2, 0.2);
		coproprietaire7.ajouterCopropriete(copropriete3, 0.4);
		coproprietaire8.ajouterCopropriete(copropriete3, 0.4);
		coproprietaire9.ajouterCopropriete(copropriete3, 0.2);
		AssembleeGenerale ag1 = new AssembleeGenerale("Ag 1", copropriete1);
		ag1.commencerAssembleeGenerale();
		ag1.ajouterCoproprietairePresent(coproprietaire1);
		ag1.ajouterCoproprietairePresent(coproprietaire2);
		ag1.ajouterCoproprietaireRepresentation(coproprietaire3, coproprietaire2);
		CalculMajoriteAbsolue calcul = new CalculMajoriteAbsolue();
		try {
			ag1.ajouterQuestionVotable("Question 1", calcul);
		} catch (OperationImpossible e) {
			e.printStackTrace();
		}
		try {
			ag1.ajouterQuestionNonVotable("Question nv 1");
		} catch (OperationImpossible e) {
			e.printStackTrace();
		}
		new AssembleeGenerale("AG 2", copropriete2);
		new AssembleeGenerale("AG 3", copropriete3);
	}

	/**
	 * Affichage du menu principal.
	 * 
	 * @return code du menu (0 ==> quit)
	 */
	static int menuPrincipal() {
		System.out.println("\n" + ": Menu principal");
		System.out.println("  1- Gestion des copropriétés");
		System.out.println("  2- Gestion des copropriétaires");
		System.out.println("  3- Gestion des assemblées générales");
		System.out.println("  4- Gestion des questions");
		System.out.println("  5- Gestion des votes");
		System.out.println("  0- Quitter");
		int choix = 0;
		try {
			choix = Console.readInt("\nEntrer le choix :");
			switch (choix) {
			case 0:
				System.exit(0);
				break;
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 5;
			default:
				System.out.println("Choix non fourni");
			}
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return choix;
	}

	static int menuCoproprietes() {
		System.out.println("\n" + ": Menu de gestion des copropriétés");
		System.out.println("  1- Ajouter une copropriété");
		System.out.println("  2- Voir la liste des copropriétés");
		System.out.println("  3- Voir la liste des copropriétaires d'une copropriété");
		System.out.println("  4- Voir la liste des assemblées générales d'une copropriété");
		System.out.println("  0- Retour");
		int choix = 0;
		try {
			choix = Console.readInt("\nEntrer le choix :");
			switch (choix) {
			case 0:
				break;
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			default:
				System.out.println("Choix non fourni");
			}
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return choix;
	}

	static int menuCoproprietaires() {
		System.out.println("\n" + ": Menu de gestion des copropriétaires");
		System.out.println("  1- Ajouter un copropriétaire");
		System.out.println("  2- Ajouter une copropriété à un copropriétaire");
		System.out.println("  3- Afficher la quote-part de la copropriété");
		System.out.println("  0- Retour");
		int choix = 0;
		try {
			choix = Console.readInt("\nEntrer le choix :");
			switch (choix) {
			case 0:
				break;
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			default:
				System.out.println("Choix non fourni");
			}
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return choix;
	}

	static int menuAssembleesGenerales() {
		System.out.println("\n" + ": Menu de gestion des assemblées générales");
		System.out.println("  1- Ajouter une assemblée générale");
		System.out.println("  2- Commencer une assemblée générale");
		System.out.println("  3- Afficher la liste des questions");
		System.out.println("  4- Afficher la feuille de présence");
		System.out.println("  5- Terminer une assemblée générale");
		System.out.println("  6- Afficher le procès verbal");
		System.out.println("  0- Retour");
		int choix = 0;
		try {
			choix = Console.readInt("\nEntrer le choix :");
			switch (choix) {
			case 0:
				break;
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 5;
			case 6:
				return 6;
			default:
				System.out.println("Choix non fourni");
			}
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return choix;
	}

	static int menuQuestions() {
		System.out.println("\n" + ": Menu de gestion des questions");
		System.out.println("  1- Ajouter une question votable à majorité simple");
		System.out.println("  2- Ajouter une question votable à majorité absolue");
		System.out.println("  3- Ajouter une question votable à majorité double");
		System.out.println("  4- Ajouter une question non votable");
		System.out.println("  5- Ajouter un compte-rendu de discussion");
		System.out.println("  6- Afficher le compte-rendu d'une question");
		System.out.println("  0- Retour");
		int choix = 0;
		try {
			choix = Console.readInt("\nEntrer le choix :");
			switch (choix) {
			case 0:
				break;
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 5;
			case 6:
				return 6;
			default:
				System.out.println("Choix non fourni");
			}
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return choix;
	}

	static int menuVotes() {
		System.out.println("\n" + ": Menu de gestion des votes");
		System.out.println("  1- Procéder au vote d'une question");
		System.out.println("  2- Afficher résultat d'un vote");
		System.out.println("  0- Retour");
		int choix = 0;
		try {
			choix = Console.readInt("\nEntrer le choix :");
			switch (choix) {
			case 0:
				break;
			case 1:
				return 1;
			case 2:
				return 2;
			default:
				System.out.println("Choix non fourni");
			}
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return choix;
	}

	private static void ajouterCopropriete() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterCopropriete();
	}

	private static void afficherListeCoproprietes() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherListeCoproprietes();
	}

	private static void afficherListeCoproprietaires() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherListeCoproprietaires();
	}

	private static void afficherListeAssembleesGenerales() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherListeAssembleesGenerales();
	}

	private static void ajouterCoproprietaire() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterCoproprietaire();
	}

	private static void ajouterCoproprieteACoproprietaire() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterCoproprieteACoproprietaire();
	}

	private static void afficherQuotePart() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherQuotePart();
	}

	private static void ajouterAssembleeGenerale() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterAssembleeGenerale();
	}

	private static void commencerAssembleeGenerale() throws OperationImpossible {
		// saisie des données en entrée
		facade.commencerAssembleeGenerale();
	}

	private static void afficherListeQuestions() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherListeQuestions();
	}

	private static void afficherFeuilleDePresence() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherFeuilleDePresence();
	}

	private static void terminerAssembleeGenerale() throws OperationImpossible {
		// saisie des données en entrée
		facade.terminerAssembleeGenerale();
	}

	private static void ajouterQuestionVotableMajoriteSimple() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterQuestionVotableMajoriteSimple();
	}

	private static void ajouterQuestionVotableMajoriteAbsolue() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterQuestionVotableMajoriteAbsolue();
	}

	private static void ajouterQuestionVotableMajoriteDouble() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterQuestionVotableMajoriteDouble();
	}

	private static void ajouterQuestionNonVotable() throws OperationImpossible {
		// saisie des données en entrée
		facade.creerQuestionNonVotable();
	}

	private static void ajouterCompteRendu() throws OperationImpossible {
		// saisie des données en entrée
		facade.ajouterCompteRendu();
	}

	private static void afficherCompteRendu() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherCompteRendu();
	}

	private static void procederVoteQuestion() throws OperationImpossible {
		// saisie des données en entrée
		facade.procederVoteQuestion();
	}

	private static void afficherResultatVote() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherResultatVote();
	}

	private static void afficherProcesVerbal() throws OperationImpossible {
		// saisie des données en entrée
		facade.afficherProcesVerbal();
	}

}
