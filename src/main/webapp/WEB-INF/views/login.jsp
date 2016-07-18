<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<script src="<c:url value="/resources/js/registerscripts.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/registerStyle.css" />">

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

	<nav class="navbar navbar-static-top myNavbarClass" style="margin: 0;"
		role="navigation">
	<div class="navbar-header" style="float: left; width: 50%">
		<a href="home" class="logo"><img
			src="<c:url value="/resources/images/reap-logo.png" />"
			style="margin-top: 10px; width: 107px; height: 32px align="center";></a>
		<img class="reapfull hidden-xs"
			src="<c:url value="/resources/images/reap.png" />">
	</div>

	</nav>

	<div class="container">

		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<c:if test="${msg!=null}">${msg}</c:if>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Please login for <strong>REAP</strong>
						</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="login" method="POST">


							<div class="form-group">
								<input type="text" name="email_id" id="email"
									class="form-control input-sm"
									placeholder="User Name/Email Address/Employee ID" />
							</div>

							<div class="form-group">
								<input path="" type="password" name="password" id="password"
									class="form-control input-sm" placeholder="Password" />
							</div>

							<input type="submit" value="Login" class="btn btn-info btn-block">
						</form>
						<br>
						<div>
							Not a member yet! <a href="register">Register</a> here.
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>