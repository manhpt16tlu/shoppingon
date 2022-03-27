<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@fancyapps/ui@4.0/dist/fancybox.css" />
<script src="https://kit.fontawesome.com/b3b8f7e66f.js"
	crossorigin="anonymous"></script>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet" />
<style>
td img {
	width: 50px;
	height: 50px;
}

td input {
	width: 5vw;
}

td {
	vertical-align: middle;
}
</style>
<body>
	<%@ include file="../header.jsp"%>
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Shop in style</h1>
				<p class="lead fw-normal text-white-50 mb-0">With this shop
					hompeage template</p>
			</div>
		</div>
	</header>
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<c:choose>
				<c:when test="${empty sessionScope.cart}">
					<h2 class="text-center my-5">Empty Cart</h2>
				</c:when>
				<c:otherwise>
					<h2 class="text-center my-5">Your Cart</h2>
				</c:otherwise>
			</c:choose>
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr class="text-center">
								<th scope="col">#</th>
								<th scope="col">Image</th>
								<th scope="col">Product</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Total</th>
								<th scope="col">Remove</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty sessionScope.cart}">
								<c:set var="stt" value="${1}" />
								<c:forEach var="entry" items="${sessionScope.cart}">
									<%--foreach lặp hashmap trả về map.entry --%>
									<c:set var="product" value="${entry.value.product}" />
									<tr class="text-center">
										<td>${stt}</td>
										<td><img src="${product.avatar_url}" /></td>
										<td>${product.product_name}</td>
										<td>$${product.product_price}</td>
										<td>
											<form
												action="${pageContext.request.contextPath}/cart/update-quantity"
												method="post" class="productCart-form">
												<input type="hidden" value="${product.id}" name="productID" />
												<input min="0" type="number" value="${entry.value.quantity}"
													class="inputQuantity" name="productQuantity" />
											</form>
										</td>
										<td><input name="inputTotal" type="text"
											value="$${product.product_price * entry.value.quantity}"
											readonly /></td>
										<td><a
											href="${pageContext.request.contextPath}/cart/remove?productID=${entry.key}"><i
												class="fa-solid fa-xmark"></i></a></td>

									</tr>
									<c:set var="stt" value="${stt+1}" />
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<c:if test="${not empty sessionScope.cart}">
						<h3 class="mt-5">Total amount : $${totalAmount}</h3>
					</c:if>
					<a class="btn btn-primary my-5" href="home" role="button">Continue
						Shopping</a>
					<c:if test="${not empty sessionScope.cart}">
						<a class="btn btn-primary my-3" href="checkout" role="button">Checkout</a>
					</c:if>

				</div>
			</div>
		</div>

	</section>
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2021</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/@fancyapps/ui@4.0/dist/fancybox.umd.js"></script>
	<script src="${pageContext.request.contextPath}/js/change-quantity.js"></script>
</body>
</html>