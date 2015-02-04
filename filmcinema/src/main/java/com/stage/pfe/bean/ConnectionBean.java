package com.stage.pfe.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name = "connectionBean")
@SessionScoped
public class ConnectionBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String motpass;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotpass() {
		return motpass;
	}

	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}

	private String connecte;
	public String getConnecte() {
		return connecte;
	}

	public void setConnecte(String connecte) {
		this.connecte = connecte;
	}

	
	
	public String connecter() {
		FacesContext face = FacesContext.getCurrentInstance();
		
		
		if (login == null || (login.trim().length() == 0))
			{face.addMessage("form:loginid", new FacesMessage("Login manquant"));
			}

		if (motpass == null || (motpass.trim().length() == 0))
			{face.addMessage("form:mpid", new FacesMessage("Mot de passe manquant"));
			}
		if(face.getMessageList().size()==0)
		{		
			if (login.equals("admin") && motpass.equals("admin"))
				return "accepted";
			else
				face.addMessage("form:f", new FacesMessage("N'existe pas un compte avec ces param�tres."));
		}
		
		return null;
	}

	public void annuler(){
		login=null;
		motpass=null;
	}
	
}
