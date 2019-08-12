<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CineSite | Horarios</title>

	<spring:url value="/resources" var="urlPublic"></spring:url>
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
</head>
<body>
<jsp:include page="includes/menu.jsp"></jsp:include>





<h1>Titulo de la pelicula ${ titulo }</h1>
<h2> Duracion ${duracion } min.</h2>
<h2> Precio ${precio } min.</h2>



<jsp:include page="includes/footer.jsp"></jsp:include>
</body>
</html>