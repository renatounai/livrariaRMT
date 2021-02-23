package br.com.livrariaRTM.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import br.com.livrariaRTM.pojo.Usuario;
import br.com.livrariaRTM.utilidades.Constantes;

public class LoginAction extends BaseAction implements SessionAware{
	private static final long serialVersionUID = -1687079273784800824L;

	private Usuario usuario;
	private Map session;
	
	
	
	@Override
	public String execute() throws Exception {
		return INPUT;
	}
	
	public String logar(){
		if(usuario != null && usuario.getLogin().equals("renato") && usuario.getSenha().equals("custodio")){
			session.put(Constantes.USUARIO, usuario);
			return SUCCESS;
		}
		addActionError("Nome de usuário ou senha incorretos!");
		return INPUT;
	}
	
	public String logoff(){
		session.put(Constantes.USUARIO, null);
		return SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
}
