package br.com.livrariaRTM.interceptors;

import br.com.livrariaRTM.dao.Conexao;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class GerenciaConexaoInterceptor implements Interceptor {
	private static final long serialVersionUID = -8343507218983483891L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		try{
			Conexao conexao = Conexao.getInstance();
			conexao.iniciarTransacao();
			
			String resultado = actionInvocation.invoke();
			
			if(resultado.equals("success")){
				conexao.commit();
			}else{
				conexao.rollback();
			}
			
			return resultado;
		}catch (Exception e) {
			Conexao.getInstance().rollback();
			e.printStackTrace();
			return "error";
		}finally{
			Conexao.getInstance().fecharConexao();
		}
	}

}
