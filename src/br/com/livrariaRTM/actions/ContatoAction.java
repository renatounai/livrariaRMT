package br.com.livrariaRTM.actions;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class ContatoAction extends BaseAction {
	private static final long serialVersionUID = -3104743330274896315L;
	
	private String nome;
	private String mensagem;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String enviarMensagem(){
		HtmlEmail email = new HtmlEmail();

		email.setHostName("smtp.gmail.com");
		email.setSSL(true);
		email.setAuthentication("login", "senha");
		email.setSmtpPort( 587 );
		try {
			email.addTo("renatomcn@gmail.com");
			email.setFrom("livrariaRTM@com.br");
			email.setSubject("Contato na Livraria RTM - "+nome);
			email.setHtmlMsg(mensagem);
			
			email.send();
			
			addActionMessage("Mensagem Enviada com sucesso!");
			
		} catch (EmailException e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		
		
		return SUCCESS;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
