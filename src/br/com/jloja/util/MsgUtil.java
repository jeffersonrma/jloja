package br.com.jloja.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MsgUtil {

	public static void msgInfo(String m) {
		FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO, m, m);
		FacesContext.getCurrentInstance().addMessage(null,  fmsg);	
	}
	public static void msgErro(String m) {
		FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, m, m);
		FacesContext.getCurrentInstance().addMessage(null,  fmsg);	
	}
	
}
