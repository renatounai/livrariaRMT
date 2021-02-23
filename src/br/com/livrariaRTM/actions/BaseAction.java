package br.com.livrariaRTM.actions;

import java.util.List;

import br.com.livrariaRTM.dao.LivroDAO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BaseAction extends ActionSupport implements Preparable{
	private static final long serialVersionUID = -1298971640458915672L;

	private List<String> categorias;
	
	@Override
	public void prepare() throws Exception {
		categorias = new LivroDAO().getCategorias();
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

}
