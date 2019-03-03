<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${ pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Booksera - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	console.log(menu);
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
 
<!-- Bootstrap Sketchy theme CSS -->
<link href="${css}/bootstrap-slate-theme.min.css" rel="stylesheet"> 

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<link href="${css}/breadcrumb.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<div class="content">

		<!-- Navigation/Header -->
		<%@include file="./master/header.jsp"%>


		<!-- Dynamic Contents (Loads one at a time) -->
		
			<!-- Home Content -->
			<c:if test="${userClickHome == true}">
				<%@include file="./home.jsp"%>
			</c:if>

			<!-- About us Content -->
			<c:if test="${userClickAbout == true}">
				<%@include file="./about.jsp"%>
			</c:if>

			<!-- Contact us Content -->
			<c:if test="${userClickContact == true}">
				<%@include file="./contact.jsp"%>
			</c:if>
			
			<!-- Sell Here Content -->
			<c:if test="${userClickSelling == true}">
				<%@include file="./selling.jsp"%>
			</c:if>
			
			<!-- Categorized List content -->
			<c:if test="${userClickCategory == true}">
				<%@include file="./listProduct.jsp"%>
			</c:if>
			
			</div>
		</div>


		<!-- Footer -->
		<%@include file="./master/footer.jsp"%>


	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>

	<!-- Custom JS -->
	<script src="${js}/myCustom.js"></script>


</body>

</html>

