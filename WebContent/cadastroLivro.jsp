<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Cadastro de Livros</title>

</head>
<body>
<h2>Cadastro de Livros</h2>
<s:form action="livro.jsp" cssStyle="text-align: right" enctype="multipart/form-data">
	<s:textfield name="livro.ISBN" label="ISBN"/>
	<s:textfield name="livro.titulo" label="Título"/>
	<s:textfield name="livro.autor" label="Autor"/>
	<s:textfield name="livro.numeroPaginas" label="Páginas"/>
	<s:textfield name="livro.categoria" label="Categoria"/>
	<s:textfield name="livro.quantidadeEstoque" label="Qtd. Estoque"/>
	<s:textfield name="livro.preco" label="Preço"/>
	<s:textfield name="livro.precoPromocao" label="Preço Promoção"/>
	<s:textfield name="livro.formato" label="Formato"/>
	<s:textfield name="livro.acabamento" label="acabamento"/>
	<s:textfield name="livro.idioma" label="idioma"/>
	<s:textfield name="livro.origem" label="origem"/>
	<s:textfield name="livro.edicao" label="Edição"/>
	<s:textfield name="livro.dataLancamento" label="Data Lançamento"/>
	<s:textarea name="livro.sinopse" label="Sinopse"/>
	<s:checkbox name="livro.promocao" label="Em Promoção"/>
	<s:file name="imagem" label="Imagem"/>
	<s:submit method="salvar" value="Salvar" cssClass="submit"/>
	<s:submit method="limparImagem" value="Limpar" cssClass="submit"/>
</s:form>
</body>
</html>