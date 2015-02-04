package com.stage.pfe.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.stage.pfe.persistance.Film;

import com.stage.pfe.service.FilmService;



@ManagedBean(name = "filmBean")
@SessionScoped
public class FilmBean {
	private Integer idfilm ;
	private String titre;
	private String annee;
	private String nom_realisateur;
	
	
	private List<Film> films = new ArrayList<Film>(0);
	private String action;
	
	
	public Integer getIdfilm() {
		return idfilm;
	}
	public void setIdfilm(Integer idfilm) {
		this.idfilm = idfilm;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getNom_realisateur() {
		return nom_realisateur;
	}
	public void setNom_realisateur(String nom_realisateur) {
		this.nom_realisateur = nom_realisateur;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Film> getFilms() {
	 FilmService ser = new FilmService();
		films = ser.rechercheTousFilm();
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}

	
	

	public void modifierFilm(Film f) {
		action="modifier";
		idfilm = f.getIdfilm();
		titre = f.getTitre();
		annee= f.getAnnee();
		nom_realisateur = f.getNom_realisateur();
		}

	
	
	public void validation() {
		FilmService ser = new FilmService();
		Film f = new Film();
		f.setTitre(titre);
		f.setAnnee(annee);
		f.setNom_realisateur(nom_realisateur);
		
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			f.setIdfilm(idfilm);
			ser.modifierFilm(f);
		   }
	if (action.equals("ajouter"))
	   ser.ajouterFilm(f);
	   
	}
	
	public void ajouterFilm(){
	action="ajouter";
	}

	public void Supprimer(Integer id) {
		FilmService ser = new FilmService();
		ser.supprimerFilm(id);
	}
}

	
	
	
	
	

