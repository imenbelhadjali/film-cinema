package com.stage.pfe.persistance;

// Generated 22 janv. 2015 15:05:41 by Hibernate Tools 3.4.0.CR1

/**
 * seance generated by hbm2java
 */
public class Seance implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idseance;
	private Integer numseance;
	private String heure_deb;
	
	private Salle salle;
	private Film film;
	
	
	
	public Seance() {
	}

	public Seance  (Integer numseance, String heure_deb) {
		
		this.numseance = numseance;
		this.heure_deb = heure_deb;
	}

	public Integer getIdseance() {
		return idseance;
	}

	public void setIdseance(Integer idseance) {
		this.idseance = idseance;
	}

	

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
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

	@Override
	public String toString() {
		return "Seance [idseance=" + idseance + ", numseance=" + numseance
				+ ", heure_deb=" + heure_deb + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((heure_deb == null) ? 0 : heure_deb.hashCode());
		result = prime * result
				+ ((idseance == null) ? 0 : idseance.hashCode());
		result = prime * result
				+ ((numseance == null) ? 0 : numseance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		if (heure_deb == null) {
			if (other.heure_deb != null)
				return false;
		} else if (!heure_deb.equals(other.heure_deb))
			return false;
		if (idseance == null) {
			if (other.idseance != null)
				return false;
		} else if (!idseance.equals(other.idseance))
			return false;
		if (numseance == null) {
			if (other.numseance != null)
				return false;
		} else if (!numseance.equals(other.numseance))
			return false;
		return true;
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	