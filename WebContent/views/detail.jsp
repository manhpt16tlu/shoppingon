<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manhnguyen.model.Contants"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style>
.images img {
	height: 100px;
}

.product-rating span.checked {
	color: orange;
}
</style>
</head>
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
	<%@ include file="../header.jsp"%>
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<h2 class="mb-5 text-center">Product detail</h2>
			<div class="row">
				<div class="col-md-6">
					<div class="images-list">
						<div class="image-avatar">
							<a href="${product.avatar_url}" data-fancybox="gallery"
								data-caption="${product.product_name}"> <img
								src="${product.avatar_url}" class="img-thumbnail" alt="..." />
							</a>
						</div>
						<div class="images d-flex">
							<c:forEach var="image" items="${images}">
								<div>
									<a href="${image.image_url}" data-fancybox="gallery"
										data-caption="${product.product_name}"> <img
										class="img-thumbnail" src="${image.image_url}"
										alt="ảnh sản phẩm" />
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<h3>${product.product_name}</h3>
					<div class="product-rating my-2">
						<span class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span
							class="fa fa-star checked"></span> <span class="fa fa-star"></span>
						<span class="fa fa-star"></span>
					</div>
					<p style="font-size: 20px">
						<em>${product.product_desc}</em>
					</p>
					<h3 class="mb-5 text-center">Price: $${product.product_price}</h3>
					<form class="d-inline" method="post"
						action="${pageContext.request.contextPath}/cart/add-to-cart">
						<input type="hidden" name="productID" value="${product.id}" /> <input
							type="submit" class="btn btn-lg btn-outline-primary ms-5"
							role="button" value="Add to cart"></input>
					</form>
					<a class=" btn btn-lg btn-outline-primary ms-3" href="home"
						role="button">Continue shopping</a>
				</div>
			</div>
		</div>
	</section>
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
	<!-- Core theme JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/@fancyapps/ui@4.0/dist/fancybox.umd.js"></script>
</body>
</html>