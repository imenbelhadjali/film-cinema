package com.stage.pfe.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.stage.pfe.persistance.Seance;
import com.stage.pfe.service.SeanceService;



@ManagedBean(name = "seanceBean")
@SessionScoped
public class SeanceBean {
	private Integer idseance ;
	private Integer numseance;
	private String heure_deb;
	private List<Seance> seances = new ArrayList<Seance>(0);
	private String action;
	
	public Integer getIdseance() {
		return idseance;
	}
	public void setIdseance(Integer idseance) {
		this.idseance = idseance;
	}
	
	public Integer getNumseance() {
		return numseance;
	}
	public void setNumseance(Integer numseance) {
		this.numseance = numseance;
	}
	public String getHeure_deb() {
		return heure_deb;
	}
	public void setHeure_deb(String heure_deb) {
		this.heure_deb = heure_deb;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Seance> getSeances() {
		System.out.println("debut");
		SeanceService ser = new SeanceService();
		seances = ser.rechercheTousSeance();
		System.out.println("fin");
		return seances;
	}
	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	
	
	public void modifierSeance (Seance s) {
		action="modifier";
		idseance = s.getIdseance();
		numseance = s.getNumseance();
		heure_deb= s.getHeure_deb();
	
		}

	
	
	public void validation() {
		SeanceService ser = new SeanceService();
		Seance s = new Seance();
		s.setNumseance(numseance);
		s.setHeure_deb(heure_deb);
		
		
		
		if(action.equals("modifier"))
		   {
			System.out.println("c'est une modification");
			s.setIdseance(idseance);
			ser.modifierSeance(s);
		   }
	if (action.equals("ajouter"))
	   ser.ajouterSeance(s);
	   
	}
	
	public void ajouterSeance(){
	action="ajouter";
	}

	public void Supprimer(Integer id) {
		SeanceService ser = new SeanceService();
		ser.supprimerSeance(id);
	}
}

	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	