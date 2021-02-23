<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Livraria RTM - <decorator:title/></title>
	<link rel="stylesheet" type="text/css" media="all" href="styles.css" />
	<decorator:head/>
</head>
<body>
<div id="container">
	<div id="header">
		<h1></h1>
		<h2></h2>
	</div><!-- end header -->
	<div id="top-menu">
		<ul>
			<li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
			<li><a href="livro!selecionarLancamento.jsp">Lançamentos</a></li>
			<li><a href="livro!selecionarEmPromocao.jsp">Promoção</a></li>
			<s:if test="#session.usuarioLogado == null">
				<li><a href="login.jsp">Login</a></lica>
			</s:if>
			<s:else>
				<li><a href="login!logoff.jsp">Logoff</a></li>
			</s:else>
			<li><a href="Carrinho.jsp">Carrinho</a></li>
			<li><a href="Contato.jsp">Contato</a></li>
		</ul>
	</div><!-- end top-nav -->
	<div id="main">
		<div id="left">
			<ul>
				<li><h2>Categorias</h2></li>
			
				<s:iterator value="categorias" id="x">
					<s:set name="item" value="x"></s:set>
					<li><a href="livro!selecionarPorCategoria.jsp?livro.categoria=${item}">${item}</a></li>
				</s:iterator>
			</ul>
			<s:if test="#session.usuarioLogado != null">
				<ul>
					<li><h2>Administração</h2></li>
					<li><a href="livro!editar.jsp">Novo Livro</a></li>
				</ul>
			</s:if>
			
		</div><!-- end left -->
		<div id="content">
			<decorator:body/>
		</div>
		<div id="right">
			<h2>Pesquisa</h2>
				
			<h2>Gallery</h2>
				<img src="images/reading.jpg" width="120" height="81" alt="gallery" class="border" />
				<img src="images/site_seguro.gif" alt="site seguro" />
		</div><!-- end right -->
	</div><!-- end main -->
	
	<div id="footer">
		<p>&copy; 2008 - ${sessionScope.usuarioLogado.login}</p>
		<!-- Please keep the following link intact. Link removal is possible for a small fee. -->
		<p class="link"><small>Design by <a href="http://www.webmatter.de">webmatter</a></small></p>
	</div><!-- end footer -->
</div>
</body>
</html>