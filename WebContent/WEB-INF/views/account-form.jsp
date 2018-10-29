<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Account</title>
<style type="text/css">
.error {
	color: red
}
</style>
</head>
<body>
<div class="container">
		<%@ include file="header.jsp"%>
	
		<div class="row">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<h2 class="pagge-header">Please Fill Up The Form Details</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-6">
				<form:form action="saveAccount" modelAttribute="account"
					cssClass="form-horizontal" role="form">

					<div class="form-group row">
						<label for="accountnumber" class="col-6 col-form-label"><spring:message
								code="lbl.accountnumber" /></label>
						<div class="class-6">
							<form:input path="accountnumber" cssClass="form-control" />
							<form:errors path="accountnumber" cssClass="alert-danger" />
							<text class="alert-danger">${message}</text>
						</div>
					</div>

					<div class="form-group row">
						<label for="accountnumber" class="col-6 col-form-label"><spring:message
								code="lbl.holdername" /></label>
						<div class="class-6">
							<form:input path="holdername" cssClass="form-control" />
							<form:errors path="holdername" cssClass="alert-danger" />

						</div>
					</div>

					<div class="form-group row">
						<label for="balance" class="col-6 col-form-label"><spring:message
								code="lbl.balance" /></label>
						<div class="class-6">
							<form:input path="balance" cssClass="form-control" />
							<form:errors path="balance" cssClass="alert-danger" />

						</div>
					</div>

					<div class="form-group row">
						<label for="accounttype" class="col-6 col-form-label"><spring:message
								code="lbl.accounttype" /></label>
						<div class="class-6">
							<form:select path="accounttype" cssClass="form-control">
								<form:option value=""> Select Account type</form:option>
								<form:option value="SAVINGS">Savings</form:option>
								<form:option value="CURRENT">Current</form:option>
							</form:select>
							<form:errors path="accounttype" cssClass="alert-danger" />

						</div>
					</div>

					<div class="form-group row">
						<label for="dob" class="col-6 col-form-label"><spring:message
								code="lbl.dob" /></label>
						<div class="class-6">
							<form:input path="dob" cssClass="form-control" />
							<form:errors path="dob" cssClass="alert-danger" />
							<text class="alert-danger">${message}</text>
						</div>
					</div>

					<div class="form-group row">
						<label for="pscode" class="col-6 col-form-label"><spring:message
								code="lbl.pscode" /></label>
						<div class="class-6">
							<form:input path="pscode" cssClass="form-control" />
							<form:errors path="pscode" cssClass="alert-danger" />
							<text class="alert-danger">${message}</text>
						</div>
					</div>

					<div class="form-group row">
						<div class="offset-6 col-6">
							<input type="submit" value="Save Account" name="btnSubmit"
								class="btn btn-primary"></inpu>
						</div>
					</div>
				</form:form>
			</div>
		</div>

		<%@ include file="footer.jsp"%>
	</div>
	

</body>
</html>