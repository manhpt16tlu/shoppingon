<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manhnguyen.model.Contants"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.11.0/mdb.min.css"
	rel="stylesheet" />
<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}
</style>
</head>
<body>
	<c:forEach var="c" items="${cookie}">
		<!-- cookie là 1 map Map<String, Cookie>-->
		<c:if test="${c.key == Contants.COOKIE_EMAIL}">
			<c:set var="userEmail" value="${c.value.value}" />
			<%--c.value là get value của hashmap --%>
		</c:if>
		<c:if test="${c.key == Contants.COOKIE_PASS}">
			<c:set var="userPass" value="${c.value.value}" />
			<%--c.value là get value của hashmap --%>
		</c:if>
	</c:forEach>
	<section class="vh-100">
		<div class="container py-5 h-100">
			<div
				class="row d-flex align-items-center justify-content-center h-100">
				<div class="col-md-8 col-lg-7 col-xl-6">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
						class="img-fluid" alt="Phone image">
				</div>
				<div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
					<c:if
						test="${not empty requestScope[Contants.MESSAGE_LOGIN_ERROR]}">
						<div class="alert alert-danger" role="alert">${requestScope[Contants.MESSAGE_LOGIN_ERROR]}</div>
					</c:if>
					<form method="post" action="">
						<!-- Email input -->
						<div class="form-outline mb-4">
							<input type="email" id="form1Example13"
								class="form-control form-control-lg" name="email" required value="${empty requestScope[Contants.MESSAGE_LOGIN_ERROR]?userEmail:''}"/> <label
								class="form-label" for="form1Example13">Email address</label>
						</div>

						<!-- Password input -->
						<div class="form-outline mb-4">
							<input type="password" id="form1Example23"
								class="form-control form-control-lg" name="password" required value="${empty requestScope[Contants.MESSAGE_LOGIN_ERROR]?userPass:''}" />
							<label class="form-label" for="form1Example23">Password</label>
						</div>

						<div class="d-flex justify-content-around align-items-center mb-4">
							<!-- Checkbox -->
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="remember"
									id="form1Example3" name="remember" checked/> <label
									class="form-check-label" for="form1Example3"> Remember
									me </label>
							</div>
							<a href="#!">Forgot password?</a>
						</div>

						<!-- Submit button -->
						<button type="submit" class="btn btn-primary btn-lg btn-block">Sign
							in</button>

						<div class="divider d-flex align-items-center my-4">
							<p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
						</div>

						<a class="btn btn-primary btn-lg btn-block"
							style="background-color: #3b5998" href="#!" role="button"> <i
							class="fab fa-facebook-f me-2"></i>Continue with Facebook
						</a> <a class="btn btn-primary btn-lg btn-block"
							style="background-color: #55acee" href="#!" role="button"> <i
							class="fab fa-twitter me-2"></i>Continue with Twitter
						</a>
					</form>
					<p class="text-center mt-3">
						Not a member? <a href="register">Register</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.11.0/mdb.min.js"></script>
</body>
</html>