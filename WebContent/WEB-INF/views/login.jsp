<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PS Bank: Login form</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="col-6 offset-3 align-self-center">
			<div class="card">
				<div class="card-header bg-info text-white">Existing Users ::
					Login Here</div>
				<div class="card-body">
					<form method="post" role="form" action="<c:url  value='/login' />">
						<div class="form-group">
							<label for="Username">User name:</label> <input type="text"
								class="form-control" name="username"
								placeholder="Enter Username" />
						</div>
						<div class="form-group">
							<label for="Password">Password:</label> <input type="password"
								class="form-control" name="password" placeholder="Password" />
						</div>

						<button name="submit" value="Login" class="btn btn-primary">Submit</button>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}">
					</form>

					<div class="row">
						<c:if test="${not empty error }">
	                       <p class="alert-danger"> ${error}</p></c:if>
						<c:if test="${not empty msg}">
						<p class="alert-warning"> ${msg}</p>
	 
	                    </c:if>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="footer.jsp"%>
	</div>
	<%-- 	<div>Existing user :: login here</div>
	<form method ="post" role="form" action="<c:url  value='/login' />">
		<input type="text" name="username" placeholder="username" /> <input
			type="password" name="password" placeholder="password" />
		<button name="submit" value="submit">Submit</button>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">
	</form>
	
	<div>
	 <c:if test="${not empty error }">
	 ${error}</c:if>
	 <c:if test="${not empty msg}">
	 ${msg}
	 </c:if>
	</div> --%>
</body>
</html>