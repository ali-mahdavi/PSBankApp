<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To Ps Bank</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="jumbotron">
					<h1 class="display-4">Welcome to PS Bank</h1>
					<p class="lead">happiness = A good Bank Account , A good Cook</p>
					<a href="user/new" class="btn btn-lg btn-success">Register Here</a>
					<p>
						<br /> Existing Users : <a href="user/login">Login Here</a>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
				<div class="card" style="height: 200px">
					<div class="card-header">Online</div>
					<img src="<spring:url value='/resource/images/stay-online.png'/>"
						class="card-img-top" alt="Online" />
					<div class="card-body">
						<p class="card-text">200+ Transaction via Net Banking</p>
					</div>

				</div>
			</div>
			
			<div class=" col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="card" style="height: 200px">
				 <div class="card-header">Online</div>
					<img src="<spring:url value='/resource/images/stay-online.png'/>"
						class="card-img-top" alt="Online" />
					<div class="card-body">
						<p class="card-text">200+ Transaction via Net Banking</p>
					</div>
				 
				</div>
			</div>
			
			<div class=" col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="card" style="height: 200px">
				<div class="card-header">Online</div>
					<img src="<spring:url value='/resource/images/stay-online.png'/>"
						class="card-img-top" alt="Online" />
					<div class="card-body">
						<p class="card-text">200+ Transaction via Net Banking</p>
					</div>
				
				</div>
			</div>
			
			<div class=" col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="card" style="height: 200px">
				<div class="card-header">Online</div>
					<img src="<spring:url value='/resource/images/stay-online.png'/>"
						class="card-img-top" alt="Online" />
					<div class="card-body">
						<p class="card-text">200+ Transaction via Net Banking</p>
					</div>
				
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>

	</div>
</body>
</html>