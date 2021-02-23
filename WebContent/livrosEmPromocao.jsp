<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros em Promoção</title>
</head>
<body>
	<h2>Livros em Promoção</h2>
	<table>
		<s:iterator value="livros" status="status">
			<s:if test="#status.odd == true">
				<tr class="Par">
			</s:if>
			<s:else>
				<tr class="Impar">
			</s:else>
				<td><a href="livro.jsp?livro.ISBN=${ISBN}">${titulo}</a></td>
				<s:if test="#session.usuarioLogado != null">
					<td><a href="livro!editar.jsp?livro.ISBN=${ISBN}"> |Editar</a></td> 
					<td><a href="livro!excluir.jsp?livro.ISBN=${ISBN}"> |Excluir</a></td>
				</s:if>
			</tr>
		</s:iterator>
	</table>
</body>
</html>