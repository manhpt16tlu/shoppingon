<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
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
	<!-- Navigation-->
	<%@ include file="../header.jsp"%>
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div class="row mb-5">
				<div class="col-md-8 border border-3 border-end-0">
					<h3 class="text-center">List product</h3>
					<table class="table">
						<thead>
							<tr class="text-center">
								<th scope="col">#</th>
								<th scope="col">Image</th>
								<th scope="col">Product</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty sessionScope.cart}">
								<c:set var="stt" value="${1}" />
								<%--biến đếm stt --%>
								<c:forEach var="entry" items="${sessionScope.cart}">
									<%--foreach lặp hashmap trả về map.entry --%>
									<c:set var="product" value="${entry.value.product}" />
									<tr class="text-center">
										<td>${stt}</td>
										<td><img src="${product.avatar_url}" /></td>
										<td>${product.product_name}</td>
										<td>$${product.product_price}</td>
										<td><input type="number"
											value="${entry.value.quantity}" class=""
											name="" readonly /></td>
										<td><input name="" type="text"
											value="$${product.product_price * entry.value.quantity}"
											readonly /></td>


									</tr>
									<c:set var="stt" value="${stt+1}" />
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<c:if test="${not empty sessionScope.cart}">
						<h3 class="">Total amount : $${totalAmount}</h3>
					</c:if>
				</div>
				<div class="col-md-4 border border-3">
					<h3 class="text-center">Your information</h3>
					<form method="post" action="">
						<div class="mb-3">
							<label for="exampleInputName1" class="form-label">Your
								name </label> <input type="text" class="form-control"
								id="exampleInputName1" required name="name">
						</div>
						<div class="mb-3">
							<label for="exampleInputAddress1" class="form-label">Your
								address </label> <input type="text" class="form-control"
								id="exampleInputAddress1" required name="address">


						</div>
						<div class="mb-3">
							<label for="exampleInputPhone1" class="form-label">Your
								phone number </label> <input type="text" class="form-control"
								id="exampleInputPhone1" required name="phone">


						</div>
						<div class="mb-3">
							<label for="exampleFormControlTextarea1" class="form-label">Note
							</label>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3" name="note"></textarea>
						</div>
						<button type="submit"
							class="btn btn-primary mb-3 w-100 ${empty sessionScope.cart ? 'disabled':''}">Submit</button>
					</form>
				</div>
			</div>
			<a class="btn btn-primary" href="cart" role="button">Back to cart
			</a> <a class="btn btn-primary" href="home" role="button">Continue
				Shopping</a>
		</div>
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>