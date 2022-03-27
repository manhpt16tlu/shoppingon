<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<c:choose>
		<c:when test="${param.status=='success'}">
			<script>
		Swal.fire('SUCCESS', 'Thank you for your order', 'success');
	    </script>
		</c:when>
		<c:otherwise>
			<script>
		Swal.fire('ERROR', 'Oops, something went wrong', 'error');
	    </script>

		</c:otherwise>
	</c:choose>

	<div class="container mt-5">
		<div class="row">
			<div class="col text-center">
				<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/home" role="button">Go to
					homepage</a>
			</div>
		</div>
	</div>
</body>
</html>