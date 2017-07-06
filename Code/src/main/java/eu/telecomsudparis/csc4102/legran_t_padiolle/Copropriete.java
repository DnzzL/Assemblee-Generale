package eu.telecomsudparis.csc4102.legran_t_padiolle;

import java.util.ArrayList;

public class Copropriete {

	private String adresseCopropriete;
	
	private Syndic syndic = Syndic.getInstance();
	private AssembleeGenerale assembleeGenerale;
	private ArrayList<AssembleeGenerale> listeAssembleesGenerales = new ArrayList<AssembleeGenerale>();
	private ArrayList<Coproprietaire> listeCoproprietaires = new ArrayList<Coproprietaire>();

	public Copropriete(String adresseCopropriete) {
		if(adresseCopropriete == null) {
			throw new IllegalArgumentException("Adresse incorrecte :" + adresseCopropriete);
		}
		this.adresseCopropriete = adresseCopropriete;
		syndic.getListeCoproprietes().add(this);
	}
	
	public void ajouterAssembleeGenerale(String nomAssembleeGenerale){
		AssembleeGenerale ag = new AssembleeGenerale(nomAssembleeGenerale, this);
		setAssembleeGenerale(ag);
		listeAssembleesGenerales.add(ag);	
	}
	
	public void ajouterAssembleeGenerale(AssembleeGenerale ag){
		setAssembleeGenerale(ag);
		listeAssembleesGenerales.add(ag);	
	}
	
	public AssembleeGenerale chercherAssembleeGenerale(String nomAssembleeGenerale) {
		for(int i=0; i<listeAssembleesGenerales.size(); i++) {
			if((listeAssembleesGenerales.get(i).getNomAssembleeGenerale().equals(nomAssembleeGenerale))) {
				return listeAssembleesGenerales.get(i);
			};
		}
		throw new IllegalArgumentException("L'assemblée générale n'existe pas");
	}
	
	public void ajouterCoproprietaire(Coproprietaire coproprietaire){
		if(coproprietaire == null) {
			throw new IllegalArgumentException("Coproprietaire incorrect: " + coproprietaire);
		}
		this.listeCoproprietaires.add(coproprietaire);
	}
	
	public Coproprietaire chercherCoproprietaire(String nom, String prenom) {
		for(int i=0; i<listeCoproprietaires.size(); i++) {
			if((listeCoproprietaires.get(i).getNom().equals(nom)) && (listeCoproprietaires.get(i).getPrenom().equals(prenom))) {
				return listeCoproprietaires.get(i);
			};
		}
		throw new IllegalArgumentException("Le copropriétaire n'existe pas");
	}

	public String getAdresseCopropriete() {
		return adresseCopropriete;
	}

	public AssembleeGenerale getAssembleeGenerale() {
		return assembleeGenerale;
	}
	
	public void setAssembleeGenerale(AssembleeGenerale assembleeGenerale) {
		this.assembleeGenerale = assembleeGenerale;
	}

	public ArrayList<AssembleeGenerale> getListeAssembleesGenerales() {
		return listeAssembleesGenerales;
	}

	public ArrayList<Coproprietaire> getListeCoproprietaires() {
		return listeCoproprietaires;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Copropriete other = (Copropriete) obj;
		if (adresseCopropriete == null) {
			if (other.adresseCopropriete != null)
				return false;
		} else if (!adresseCopropriete.equals(other.adresseCopropriete))
			return false;
		if (assembleeGenerale == null) {
			if (other.assembleeGenerale != null)
				return false;
		} else if (!assembleeGenerale.equals(other.assembleeGenerale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Copropriete [adresseCopropriete=" + adresseCopropriete + "]";
	}

	
	
}
