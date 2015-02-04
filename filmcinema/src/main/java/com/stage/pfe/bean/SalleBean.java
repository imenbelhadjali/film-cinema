package com.stage.pfe.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.stage.pfe.persistance.Salle;
import com.stage.pfe.service.SalleService;



@ManagedBean(name = "salleBean")
@SessionScoped
public class SalleBean {
	private Integer idsalle ;
	private String nomsalle;
	private String capacite;
	private List<Salle> salles = new ArrayList<Salle>(0);
	private String action;
	
	
	
	
	public Integer getIdsalle() {
		return idsalle;
	}
	public void setIdsalle(Integer idsalle) {
		this.idsalle = idsalle;
	}
	public String getNomsalle() {
		return nomsalle;
	}
	public void setNomsalle(String nomsalle) {
		this.nomsalle = nomsalle;
	}
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Salle> getSalles() {
		SalleService ser = new SalleService();
		salles = ser.rechercheTousSalle();
		return salles;
	}
		
	
	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
	
	
	
	public void modifierSalle (Salle sa) {
		action="modifier";
		idsalle = sa.getIdsalle();
		nomsalle = sa.getNomsalle();
		capacite= sa.getCapacite();
	
		}

	
	
	public void validation() {
		SalleService ser = new SalleService();
	   Salle c = new Salle();
		c.setNomsalle(nomsalle);
		c.setCapacite(capacite);
		
		
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			c.setIdsalle(idsalle);
			ser.modifierSalle(c);
		   }
	if (action.equals("ajouter"))
	   ser.ajouterSalle(c);
	   
	}
	
	public void ajoutersalle(){
	action="ajouter";
	}

	public void Supprimer(Integer id) {
		SalleService ser = new SalleService();
		ser.supprimerSalle(id);
	}
}

	