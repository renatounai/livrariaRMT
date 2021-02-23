<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h2>Login no Sistema</h2>
<s:form action="login.jsp">
	<s:textfield name="usuario.login" label="Login"/>
	<s:password name="usuario.senha" label="Senha"/>
	<s:submit value="Entrar" cssClass="submit" method="logar"/>
	<s:actionerror/>
</s:form>
</body>
</html>