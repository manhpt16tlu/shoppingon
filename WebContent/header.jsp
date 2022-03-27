<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manhnguyen.model.Contants"%>
<script src="https://kit.fontawesome.com/b3b8f7e66f.js"
	crossorigin="anonymous"></script>
<c:if test="${not empty sessionScope.cart}">
	<c:set var="quantityProductCart" value="${sessionScope.cart.size()}" />
</c:if>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="${pageContext.request.contextPath}/home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">All Products</a></li>
						<li><hr class="dropdown-divider" /></li>
						<li><a class="dropdown-item" href="#!">Popular Items</a></li>
						<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
					</ul></li>
			</ul>
			<form class="d-flex mx-auto" action="" method="get">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="keyword" required />
				<button class="btn btn-outline-success" type="submit">
					Search</button>
			</form>
			<a class="btn btn-outline-dark"
				href="${pageContext.request.contextPath}/cart"> <i
				class="bi-cart-fill me-1"></i> Cart <span
				class="badge bg-dark text-white ms-1 rounded-pill">${empty quantityProductCart ? 0 : quantityProductCart}</span>
			</a>
			<c:choose>
				<c:when test="${empty sessionScope[Contants.USER_LOGGED]}">
					<a class="btn btn-primary ms-3"
						href="${pageContext.request.contextPath}/login" role="button">Login</a>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-primary ms-3">${sessionScope[Contants.USER_LOGGED].fullname}</button>
					<a class="btn btn-primary ms-1"
						href="${pageContext.request.contextPath}/logout" role="button">Logout</a>
				</c:otherwise>
			</c:choose>


		</div>
	</div>
</nav>