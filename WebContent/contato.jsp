<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contato</title>
</head>
<body>
<h2>Formulário Para Contato</h2>
	<s:form action="Contato.jsp" theme="simple">
		<fieldset>
			<legend>Nos envie uma mensagem: </legend>
			<p><label>Nome:<br /><input type="text" name="nome"/></label></p>
			<p><label>Mensagem:<br /><textarea rows="5" cols="5" name="mensagem"></textarea></label></p>
			<p><label><s:submit cssClass="submit" method="enviarMensagem"></s:submit> </label></p>
		</fieldset>
	</s:form>
	<s:actionmessage/>
	<s:actionerror/>

</body>
</html>