package br.com.livrariaRTM.actions;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.jboleto.JBoleto;
import org.jboleto.JBoletoBean;
import org.jboleto.control.Generator;
import org.jboleto.control.PDFGenerator;

import br.com.livrariaRTM.dao.LivroDAO;
import br.com.livrariaRTM.pojo.Livro;
import br.com.livrariaRTM.utilidades.Constantes;

public class CarrinhoAction extends BaseAction implements SessionAware{
	private static final long serialVersionUID = 7924765074176427544L;
	
	private Livro livro;
	private List<Livro> livros;
	private Map session;
	
	private String caminho;
	
	private BigDecimal precoTotal;
	
	@Override
	public String execute() throws Exception {
		livros = (List<Livro>) session.get(Constantes.ITENS_CARRINHO);
		precoTotal = new BigDecimal(0);
		if(livros != null)
		for(Livro l: livros){
			if( l.isPromocao() )
				precoTotal =precoTotal.add(l.getPrecoPromocao());
			else
				precoTotal =precoTotal.add(l.getPreco());
		}
		
		return SUCCESS;
	}
	
	public String adicionarAoCarrinho(){
		List<Livro> livros = (List<Livro>) session.get(Constantes.ITENS_CARRINHO);
		if(livros == null){
			livros = new ArrayList<Livro>();
		}
		
		livro = (Livro) new LivroDAO().selecionar(livro.getISBN());
		
		livros.add(livro);
		
		session.put(Constantes.ITENS_CARRINHO, livros);
		setLivros(livros);
		
		precoTotal = new BigDecimal(0);
		for(Livro l: livros){
			if( l.isPromocao() )
				precoTotal = precoTotal.add(l.getPrecoPromocao());
			else
				precoTotal = precoTotal.add(l.getPreco());
		}
		
		return SUCCESS;
	}
	
	public String esvaziarCarrinho(){
		session.put(Constantes.ITENS_CARRINHO, null);
		livros = null;
		precoTotal = null;
		return SUCCESS;
	}
	
	public String gerarBoleto(){
		precoTotal = new BigDecimal(0);
		List<Livro> livros = (List<Livro>) session.get(Constantes.ITENS_CARRINHO);
		if(livros == null)
			return SUCCESS;
		for(Livro l: livros){
			if( l.isPromocao() )
				precoTotal = precoTotal.add(l.getPrecoPromocao());
			else
				precoTotal = precoTotal.add(l.getPreco());
		}
		
		
		JBoletoBean jBoletoBean = new JBoletoBean();
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		jBoletoBean.setDataDocumento(df.format(new Date()));
        jBoletoBean.setDataProcessamento(df.format(new Date()));      
            
        jBoletoBean.setCedente("Livraria RTM");  
        jBoletoBean.setCarteira("17");

        jBoletoBean.setNomeSacado("Cliente Pessoa Física");
        
        jBoletoBean.setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO BANCO DO BRASIL");
        jBoletoBean.setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO BANCO DO BRASIL");        
        
        Vector descricoes = new Vector();
        jBoletoBean.setDescricoes(descricoes);
        
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        
        
        jBoletoBean.setDataVencimento(df.format(calendar.getTime()) );
        jBoletoBean.setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        jBoletoBean.setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        jBoletoBean.setInstrucao3("");
        jBoletoBean.setInstrucao4("");

        jBoletoBean.setAgencia("3415");
        jBoletoBean.setContaCorrente("00543004"); 
               
        jBoletoBean.setNumConvenio("1101354");
        jBoletoBean.setNossoNumero("0005963971",10);
        jBoletoBean.setValorBoleto(precoTotal.toPlainString());
        
        Generator generator = new PDFGenerator(jBoletoBean, JBoleto.BANCO_DO_BRASIL);
        JBoleto jBoleto = new JBoleto(generator, jBoletoBean, JBoleto.BANCO_DO_BRASIL);
        
        jBoleto.addBoleto();
        
        caminho = "WEB-INF/"+new Date().getTime()+"boleto.pdf";
        String auxCaminho = ServletActionContext.getRequest().getRealPath("/")+caminho;
        caminho = caminho;
        
        jBoleto.closeBoleto(auxCaminho);	        
		
		return "boleto";
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
