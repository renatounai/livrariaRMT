package br.com.livrariaRTM.actions;

import java.util.List;

import br.com.livrariaRTM.dao.LivroDAO;
import br.com.livrariaRTM.pojo.Livro;

public class IndexAction extends BaseAction {
	private static final long serialVersionUID = -3202983506473969949L;

	private List<Livro> livrosPromocao;
	private List<Livro> livrosLancamentos;
	
	@Override
	public String execute() throws Exception {
		LivroDAO livroDAO = new LivroDAO();
		
		livrosLancamentos = livroDAO.getLancamentos();
		livrosPromocao = livroDAO.getEmPromocao();
		
		return SUCCESS;
	}

	public List<Livro> getLivrosPromocao() {
		return livrosPromocao;
	}

	public void setLivrosPromocao(List<Livro> livrosPromocao) {
		this.livrosPromocao = livrosPromocao;
	}

	public List<Livro> getLivrosLancamentos() {
		return livrosLancamentos;
	}

	public void setLivrosLancamentos(List<Livro> livrosLancamentos) {
		this.livrosLancamentos = livrosLancamentos;
	}
	
}
