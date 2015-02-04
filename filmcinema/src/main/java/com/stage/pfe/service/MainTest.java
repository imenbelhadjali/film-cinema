package com.stage.pfe.service;
import java.util.List;


import com.stage.pfe.persistance.Seance;



public class MainTest {
	public static void main(String[] args) {
		
		
	//	ConnectionBean n = new ConnectionBean();
		SeanceService ser=new SeanceService ();	
		List<Seance> l =ser.rechercheParNum(4);
		
		System.out.println(l.size());
		
		for(int i=0;i<l.size();i++)
			System.out.println(l.get(i).getFilm().getNom_realisateur()+"  "+l.get(i).getSalle().getNomsalle());
	}
}
