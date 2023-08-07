package fr.doranco.salaires.entity;

import java.util.Date;
import java.util.Set;

public class User {
	
	private int id;
	private  String genre ;
	private String nom ;
	private String prenom ;
	private String email ;
	private Date dateNaissance;
	private Date dateEntree ;
	private Date  date_sortie;
	private String titre ;
	private float salaire_de_base;
	private String password ;
	private String  statut ;
	private Set<Adresse> adresse;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String genre, String nom, String prenom, String email, Date dateNaissance, Date dateEntree,
			Date date_sortie, String titre, float salaire_de_base, String password, String statut,
			Set<Adresse> adresse) {
		super();
		this.id = id;
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.dateEntree = dateEntree;
		this.date_sortie = date_sortie;
		this.titre = titre;
		this.salaire_de_base = salaire_de_base;
		this.password = password;
		this.statut = statut;
		this.adresse = adresse;
	}


	public User(int int1, String string, String string2) {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public Date getDateEntree() {
		return dateEntree;
	}


	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}


	public Date getDate_sortie() {
		return date_sortie;
	}


	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public float getSalaire_de_base() {
		return salaire_de_base;
	}


	public void setSalaire_de_base(float salaire_de_base) {
		this.salaire_de_base = salaire_de_base;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Set<Adresse> getAdresse() {
		return adresse;
	}


	public int getUser() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
}