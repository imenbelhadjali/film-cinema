package com.stage.pfe.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.stage.pfe.persistance.Cinema;
import com.stage.pfe.service.CinemaService;



@ManagedBean(name = "cinemaBean")
@SessionScoped
public class CinemaBean {
	private Integer idcinema ;
	private String nomcinema;
	private String adresse;
	private List<Cinema> cinemas = new ArrayList<Cinema>(0);
	private String action;
	
	
	
	
	
	
	public Integer getIdcinema() {
		return idcinema;
	}
	public void setIdcinema(Integer idcinema) {
		this.idcinema = idcinema;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getNomcinema() {
		return nomcinema;
	}
	public void setNomcinema(String nomcinema) {
		this.nomcinema = nomcinema;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Cinema> getCinemas() {
		CinemaService ser = new CinemaService();
		cinemas = ser.rechercheTousCinema();
	 return cinemas;
	}
	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
	
	
	public void modifierCinema (Cinema c) {
		action="modifier";
		idcinema = c.getIdcinema();
		nomcinema = c.getNomcinema();
		adresse= c.getAdresse();
	
		}

	
	
	public void validation() {
		CinemaService ser = new CinemaService();
	    Cinema c = new Cinema();
		c.setNomcinema(nomcinema);
		c.setAdresse(adresse);
		
		
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			c.setIdcinema(idcinema);
			ser.modifierCinema(c);
		   }
	if (action.equals("ajouter"))
	   ser.ajouterCinema(c);
	   
	}
	
	public void ajouterCinema(){
	action="ajouter";
	}

	public void Supprimer(Integer id) {
		CinemaService ser = new CinemaService();
		ser.supprimerCinema(id);
	}
}

	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	