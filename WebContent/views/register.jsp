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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<c:set var="paramStatus" value="${param.status}" />
	<c:set var="paramValue" value="${param.value}" />
	<section class="vh-100" style="background-color: #eee;">
		<c:if test="${not empty paramStatus}">
			<c:choose>
				<c:when test="${paramStatus == Contants.SUCCESS}">
					<script type="text/javascript">
			Swal.fire('SUCCESS', 'Please login to continue',
				'success')
		    </script>
				</c:when>
				<c:when
					test="${paramStatus == Contants.ERROR && paramValue == Contants.SQL_ERROR_101}">
					<script type="text/javascript">
			Swal.fire('ERROR', 'This email already exist', 'error')
		    </script>
				</c:when>
			</c:choose>
		</c:if>
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-3 mx-1 mx-md-4 mt-3">Sign
										up</p>

									<form onsubmit="return checkForm()" class="mx-1 mx-md-4"
										method="post" action="" id="register-form">
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="input-name" class="form-control"
													name="fullname" required /> <label class="form-label"
													for="input-name">Your Name</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="email" id="input-email" class="form-control"
													name="email" required /> <label class="form-label"
													for="input-email">Your Email</label>
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fa-solid fa-phone fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="input-phone" class="form-control"
													name="phone" required /> <label class="form-label"
													for="input-phone">Your Phone</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="input-pass" class="form-control"
													name="password" required /> <label class="form-label"
													for="input-pass">Password</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="input-repass"
													class="form-control" name="repassword" required /> <label
													class="form-label" for="input-repass">Repeat your
													password</label>
											</div>
										</div>

										<div class="form-check d-flex justify-content-center mb-3">
											<input class="form-check-input me-2" type="checkbox" value=""
												id="form2Example3c" required /> <label
												class="form-check-label" for="form2Example3"> I
												agree all statements in <a href="#!">Terms of service</a>
											</label>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Register</button>
										</div>

									</form>
									<p class="text-center">
										Already have an account? <a href="login">Login here</a>
									</p>
								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.11.0/mdb.min.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/register-validate.js"></script>
</body>
</html>