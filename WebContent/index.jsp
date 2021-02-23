<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Página Principal</title>
</head>
<body>
<s:if test="livrosLancamentos.size > 0">
	<h2>Ultimos Lançamentos</h2>
	<table>
		<s:iterator value="livrosLancamentos" status="status">
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
</s:if>

<s:if test="livrosPromocao.size > 0">
	<h2>Livros em Promoção</h2>
	<table>
		<s:iterator value="livrosPromocao" status="status">
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
</s:if>

		
	

</body>
</html>
