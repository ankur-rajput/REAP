<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/reap.css" />">

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<!-- DateRangePicker -->
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
							Please register for <strong>REAP</strong>
						</h3>
					</div>
					<div class="panel-body">
						<form:form method="POST" action="register"
							modelAttribute="employeeDetails">
							<div class="form-group">
								<form:input path="name" type="text" id="name"
									class="form-control input-sm" placeholder="Name" />
							</div>

							<div class="row">
								<div class="form-group">
									<div class="col-xs-7 col-sm-7 col-md-7">
										<div class="form-group">
											<form:input path="user_name" type="text" id="email"
												class="form-control input-sm" placeholder="User Name" />
										</div>
									</div>
									<div class="col-xs-5 col-sm-5 col-md-5">
										<input type="text" class="form-control input-sm"
											value="@tothenew.com" readonly="readonly" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<form:input path="password" type="password" name="password"
											id="password" class="form-control input-sm"
											placeholder="Password" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm Password">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">

										<form:select path="serviceLine" class="form-control"
											id="serviceLine">
											<option>Service Lines</option>
											<option>Analytics</option>
											<option>Digital Marketing</option>
											<option>Digital Marketing India</option>
											<option>Digital Marketing-SEA</option>
											<option>Technology</option>
											<option>ThoughtBuzz India</option>
											<option>TTND Overheads</option>
											<option>TTND-Intern</option>
											<option>TTND-SEA</option>
											<option>TTNDV</option>
											<option>Video Solutions</option>
										</form:select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">

										<form:select path="practice" class="form-control"
											id="serviceLine">
											<option>Practice</option>
											<option>Admin</option>
											<option>Admin-DM</option>
											<option>Admin-TTND</option>
											<option>Admin.Noida</option>
											<option>AMC</option>
											<option>Analytics</option>
											<option>Analytics-SEA</option>
											<option>AWS</option>
											<option>BigData</option>
											<option>BlogMint</option>
											<option>BlogMint-Sales</option>
											<option>Business Development</option>
											<option>BUSINESS DEVELOPMENT-DM</option>
											<option>Business Development-DM</option>
											<option>Client Servicing</option>
											<option>Creative</option>
											<option>Delivery</option>
											<option>Delivery-Analyitcs</option>
											<option>Delivery-Video Ready</option>
											<option>Design</option>
											<option>DevOps</option>
											<option>Digital Marketing Team- Gurgaon</option>
											<option>Digital Marketing Team-Mumbai</option>
											<option>Digital Marketing Team-Noida</option>
											<option>DM India CORPORATE</option>
											<option>Drupal</option>
											<option>Executive</option>
											<option>Fame</option>
											<option>Feen</option>
											<option>Finance</option>
											<option>Finance-DM</option>
											<option>Finance-TTND</option>
											<option>Grails</option>
											<option>HR</option>
											<option>HR-Operations</option>
											<option>TTNDV</option>
											<option>Video Solutions</option>
										</form:select>
									</div>
								</div>
							</div>
							<input type="submit" value="Register"
								class="btn btn-info btn-block">

						</form:form>
						<br>
						<div>
							Already a member! <a href="login">Login</a> here
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>