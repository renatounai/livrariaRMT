package br.com.livrariaRTM.actions;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import br.com.livrariaRTM.dao.LivroDAO;
import br.com.livrariaRTM.pojo.Livro;
import br.com.livrariaRTM.utilidades.Constantes;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;


public class ManterLivroAction extends BaseAction implements SessionAware {
	private static final long serialVersionUID = 5200079692983979891L;

	private Livro livro;
	private List<Livro> livros;
	private LivroDAO livroDAO = new LivroDAO();
	
	private File imagem;
	
	private String contentType;
	private String filename;	
	private String inputName;
	private String contentDisposition;
	private int contentLength;
	
	private InputStream imagemGerada;
	
	private Map session;
	
	
	@Override
	@SkipValidation
	public String execute() throws Exception {
		if(livro != null && livro.getISBN() > 0){
			return selecionar();
		}
		return SUCCESS;
	}
	
	@SkipValidation
	public String selecionar(){
		int auxISNB = livro.getISBN();
		livro = (Livro) livroDAO.selecionar(livro.getISBN());
		
		if(livro == null){
			addActionError("Não foi possível encontrar o livro solicitado. ISBN: "+auxISNB);
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	@SkipValidation
	public String editar(){
		if( session.get(Constantes.USUARIO) == null ){
			return "login";
		}
		
		if(livro == null)
			return INPUT;
		
		int auxISNB = livro.getISBN();
		livro = (Livro) livroDAO.selecionar(livro.getISBN());
		
		if(livro == null){
			addActionError("Não foi possível encontrar o livro solicitado. ISBN: "+auxISNB);
			return ERROR;
		}
		
		return INPUT;		
	}
	
	@Validations(
			requiredStrings={
					@RequiredStringValidator(fieldName="livro.titulo", message="O título é obrigatório!"),
					@RequiredStringValidator(fieldName="livro.autor", message="O autor é obrigatório!"),
					@RequiredStringValidator(fieldName="livro.sinopse", message="A sinopse é obrigatória!"),
					@RequiredStringValidator(fieldName="livro.categoria", message="A categoria é obrigatória!")
			},intRangeFields={
					@IntRangeFieldValidator(fieldName="livro.ISBN", message="O ISBN é obrigatório!", min="1"),
					@IntRangeFieldValidator(fieldName="livro.edicao", message="A edição é obrigatória!", min="1"),
					@IntRangeFieldValidator(fieldName="livro.numeroPaginas", message="O número de páginas é obrigatória!", min="1"),
			}
			
	)	
	public String salvar(){
		if( session.get(Constantes.USUARIO) == null ){
			return "login";
		}
		
		if( livro.getPreco() == null || livro.getPreco().doubleValue() == 0){
			addFieldError("livro.preco", "O Preço é obrigatório!");
			return INPUT;
		}
		
		if(imagem != null){
			try {
				livro.setImagem(FileUtils.readFileToByteArray(imagem));
			} catch (IOException e) {
				e.printStackTrace();
				return INPUT;
			}
		}else{
			Livro auxLivro = (Livro) livroDAO.selecionar(livro.getISBN());
			livro.setImagem(auxLivro.getImagem());
		}
		livroDAO.salvar(livro);
		return SUCCESS;
	}
	
	@SkipValidation
	public String excluir(){
		if( session.get(Constantes.USUARIO) == null ){
			return "login";
		}
		
		Livro l = (Livro) livroDAO.selecionar(livro.getISBN());
		livroDAO.excluir(l);
		return SUCCESS;
 
	}
	
	@SkipValidation
	public String gerarImagem(){
		try {
			livro = (Livro) livroDAO.selecionar(livro.getISBN());
			imagemGerada = new ByteArrayInputStream(livro.getImagem());
			this.setContentDisposition( "filename=logo.jpg" );
			this.setContentLength( livro.getImagem().length );
			return SUCCESS;
		} catch (Exception e) {
			addActionError(e.getMessage());
			return "imagemNula";
		}
	}	
	
	@SkipValidation
	public String selecionarPorCategoria(){
		livros = livroDAO.getPorCategoria(livro.getCategoria());
		return "categoria";
	}
	
	@SkipValidation
	public String selecionarEmPromocao(){
		livros = livroDAO.getEmPromocao();
		return "promocao";
	}
	
	@SkipValidation
	public String selecionarLancamento(){
		livros = livroDAO.getLancamentos();
		return "lancamento";
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public File getImagem() {
		return imagem;
	}

	public void setImagem(File imagem) {
		this.imagem = imagem;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public InputStream getImagemGerada() {
		return imagemGerada;
	}

	public void setImagemGerada(InputStream imagemGerada) {
		this.imagemGerada = imagemGerada;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	
	
}
