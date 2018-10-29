<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="lbl.title" /></title>
</head>
<body>
	<h2>Bank account details</h2>

	<p>
		<spring:message code="lbl.accountnumber" />
		: ${account.accountnumber }
	</p>
	<p>
		<spring:message code="lbl.holdername" />
		: ${account.holdername }
	</p>
	<p>
		<spring:message code="lbl.balance" />
		: ${account.balance }
	</p>
	<p>
		<spring:message code="lbl.accounttype" />
		: ${account.accounttype }
	</p>
	<p>
		<spring:message code="lbl.dob" />
		: ${account.dob }
	</p>
	<p>
		<spring:message code="lbl.pscode" />
		: ${account.pscode }
	</p>


</body>
</html>