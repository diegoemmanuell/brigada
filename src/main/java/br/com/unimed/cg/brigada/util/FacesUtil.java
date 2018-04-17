package br.com.unimed.cg.brigada.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class FacesUtil {

	public static void addErrorMessage(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		context.addMessage(null, message);
	}
	
	public static void addErrorMessageEspecifica(String idCampo, String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		context.addMessage(idCampo, message);
	}

	public static void addInfoMessage(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		context.addMessage(null, message);
	}

	public static void putSession(String key, Object obj) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			context.getExternalContext().getSessionMap().put(key, obj);
		}
	}

	public static void deleteSession(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			context.getExternalContext().getSessionMap().remove(key);
		}
	}

	public static Object getObjectSession(String key) {

		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}

	public static void invalidateSession() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
	}
	
	public static void adicionaMensagemExceção() {
		addErrorMessage("Ocorreu um erro inesperado!");
		addErrorMessage("Favor contactar à Unimed Campina Grande");
	}
	
	public static void abrirModal(String idModal) {
		
	}
}
