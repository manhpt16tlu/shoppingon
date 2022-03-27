<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manhnguyen.model.Contants"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<style>
a {
	text-decoration: none;
}

li.active a {
	color: white;
}
</style>
<body>

	<c:if test="${not empty sessionScope.addToCartResult}">
		<c:choose>
			<c:when test="${sessionScope.addToCartResult == Contants.SUCCESS}">
				<script type="text/javascript">
		    Swal.fire('SUCCESS', 'Add new product to cart', 'success')
		</script>
			</c:when>
		</c:choose>
		<c:remove var="addToCartResult" scope="session" />
	</c:if>
	<!-- Navigation-->
	<%@ include file="../header.jsp"%>
	<!-- Header-->
	<header class="bg-dark py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="text-center text-white">
				<h1 class="display-4 fw-bolder">Shop in style</h1>
				<p class="lead fw-normal text-white-50 mb-0">With this shop
					hompeage template</p>
			</div>
		</div>
	</header>
	<!-- Section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row">
				<div class="col-md-3">
					<h3 class="text-center">Categories</h3>
					<ul class="list-group">
						<%-- <li class="list-group-item active" aria-current="true">An
							active item</li>
						<li class="list-group-item">A second item</li>
						<li class="list-group-item">A third item</li>
						<li class="list-group-item">A fourth item</li>
						<li class="list-group-item">And a fifth one</li>--%>


						<c:forEach var="category" items="${categories}">
							<li
								class="list-group-item ${param.category == category.id ? 'active':''}"><a
								href="?category=${category.id}">${category.category_name}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="col-md-9">
					<h3 class="text-center">Products</h3>
					<div
						class="
                row
                gx-4 gx-lg-5
                row-cols-2 row-cols-3
                justify-content-center
              ">
						<c:forEach var="product" items="${products}">
							<div class="col mb-5">
								<div class="card h-100">
									<!-- Product image-->
									<img class="card-img-top" src="${product.avatar_url}" alt="..." />
									<!-- Product details-->
									<div class="card-body p-4">
										<div class="text-center">
											<!-- Product name-->
											<h5 class="fw-bolder">
												<a href="detail?productID=${product.id}">${product.product_name}</a>
											</h5>
											<!-- Product price-->
											$${product.product_price}
										</div>
									</div>
									<!-- Product actions-->
									<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
										<div class="text-center">
											<form method="post"
												action="${pageContext.request.contextPath}/cart/add-to-cart">
												<input type="hidden" value="${product.id}" name="productID" />
												<button type="submit" class="btn btn-outline-dark mt-auto">
													Add to cart</button>
											</form>
										</div>
									</div>
								</div>
							</div>

						</c:forEach>
					</div>
				</div>
			</div>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<li
						class="page-item ${activePage==1 || empty activePage?'disabled':''}"><a
						class="page-link"
						href="?category=${param.category}&page=${activePage-1}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<c:forEach begin="1" var="page" end="${totalPage}">
						<li class="page-item ${page==activePage ? 'active':''}"><a
							class="page-link" href="?category=${param.category}&page=${page}">${page}</a></li>
					</c:forEach>
					<li class="page-item ${activePage==totalPage?'disabled':''}"><a
						class="page-link"
						href="?category=${param.category}&page=${activePage+1}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</section>
	<%--
 	<c:out value="${totalRecord}" />
	<c:out value="${totalPage}" />
	<c:out value="${activePage}" />
 --%>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2021</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
