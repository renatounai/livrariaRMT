<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${livro.titulo}</h2>
<img align="top" alt="${livro.titulo}" src="MostraImagemLivro.jsp?livro.ISBN=${livro.ISBN}" class="imagemLivro"/>
<div class="divAutor">
	<p class="autor">${livro.autor}</p>
</div>
<div class="dadosCadastrais">
	<p class="sinopse">${livro.sinopse}</p>
	<h4>Ficha Técnica</h4>
	<p><b>ISBN:</b> ${livro.ISBN}<br />
	<b>Formato:</b> ${livro.formato}<br />
	<b>Acabamento:</b> ${Acabamento.ISBN}<br />
	<b>Idioma:</b> ${livro.idioma}<br />
	<b>Origem:</b> ${livro.origem}<br />
	<b>Edição:</b> ${livro.edicao}<br />
	<b>Lançamento:</b> <s:date name="livro.dataLancamento" format="dd/MM/yyyy"/> </p>
	<s:if test="livro.promocao">
		<p class="preco">De ${livro.preco} por apenas ${livro.precoPromocao}</p>	
	</s:if>
	<s:else>
		<p class="preco">Apenas ${livro.preco}</p>
	</s:else>
</div>

<div class="comprar">
	<a href="AdicionarAoCarrinho.jsp?livro.ISBN=${livro.ISBN}">Adicionar ao Carrinho!</a>
</div>

</body>
</html>