<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ocorreu um erro</title>
</head>
<body>
<h2>Ops, ocorreu um erro...</h2>
<div class="errorMessage"><s:actionerror/><s:fielderror></s:fielderror> </div>
</body>
</html>