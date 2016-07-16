<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="/REAP/resources/images/favicon.ico"
	type="image/x-icon">
<title>REAP</title>

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<!-- Latest compiled and minified JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/reap.css" />">
</head>
<body>
	<nav class="navbar navbar-static-top myNavbarClass" style="margin: 0;"
		role="navigation">
	<div class="navbar-header" style="float: left; width: 50%">
		<a href="#" class="logo"><img
			src="/REAP/resources/images/reap-logo.png"
			style="margin-top: 10px; width: 107px; height: 32px";></a> <img
			class="reapfull hidden-xs" src="/REAP/resources/images/reap.png">
	</div>
	<div>
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#myNavbar">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
	</div>
	<div class="collapse navbar-collapse" id="myNavbar">
		<div class="myMenu">
			<ul id="myNavbarButtons" class="nav navbar-nav" style="float: right">
				<li><a href='<c:url value="/" />' class="navbtn" id="dashboard"><img
						id="test" src="/REAP/resources/images/ico-dashboard.png"> Dashboard</a></li>
				<li><a href='<c:url value="badges" />' class="navbtn"
					id="badge"><img src="/REAP/resources/images/ico-badge.png"> Badges</a></li>
				<li><a href="#" class="navbtn" id="idea"><img
						src="/REAP/resources/images/ico-idea.png"> Idea</a></li>
				<li><a href="#"><img src="/REAP/resources/images/ico-bell.png"
						style="margin-top:"></a></li>
			</ul>
		</div>

	</div>
	</nav>
	<!--navigation bar completed-->
	<!--My Badges and Points section started-->
	<div class="row">
		<div class="container-fluid responsive"
			style="background: #f1f4f5; padding-top: 20px;">
			<div class="col-md-4">
				<div class="box-content">
					<div class="panel panel-default"
						style="margin-left: 15px; margin-right: 15px;">
						<div class="panel-heading"
							style="background: #8d9fc4; color: #ffffff">
							<img src="/REAP/resources/images/ico-badge.png" /> <strong
								style="font-size: 14px">&nbsp Badges and Points</strong>
						</div>

						<div class="panel-body">

							<div class="row">
								<div class="col-md-3">

									<div class="col-md-12">
										<div class="head-bar badge-content-left">
											<span style="padding: 4px 12px;"> <img
												class="image-responsive" src="/REAP/resources/images/sanam.jpg"
												style="height: 42px width:35px">
											</span>
										</div>
									</div>
								</div>

								<div class="col-md-6">
									<div class="col-md-12">

										<table class="table table-sm">
											<thead>
												<tr>
													<td colspan="3"><strong>${employeeDetails.getName()}</strong></td>

												</tr>
											</thead>
											<tbody>
												<tr>

													<td><img class="image-responsive "
														src="/REAP/resources/images/gold.png"></td>
													<td><img class="image-responsive "
														src="/REAP/resources/images/silver.png"></td>
													<td><img class="image-responsive "
														src="/REAP/resources/images/bronze.png"></td>
												</tr>
												<tr>
													<td>${receivedBadges.getGold()}</td>
													<td>${receivedBadges.getSilver()}</td>
													<td>${receivedBadges.getBronze()}</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="col-md-3 custom-availablePoints">

									<!-- 
									<div class="col-md-12 h1point custom-availablePoints">
										<strong><h1>0 pts</h1></strong>

									</div> -->

								</div>

							</div>


						</div>
						<!--Panel body over-->

					</div>
					<!--Complete Panel-->

				</div>
			</div>
			<!--Col-md-4 over-->
			<div class="col-md-8" style="padding-right: 30px">
				<div class="box-content static">
					<div class="head-bar no-bg">
						<div class="head-inputs">
							<div class="row">
								<div class="col-lg-12 col-md-12">
									<!-- Nav tabs -->
									<div>

										<button type="button" class="navbar-toggle"
											data-toggle="collapse" data-target="#myTab"
											aria-expanded="false">
											<span class="sr-only">ALL(0)</span> <span class="icon-bar"></span>
											<span class="icon-bar"></span> <span class="icon-bar"></span>

										</button>
									</div>
									<div class="collapse navbar-collapse" id="myTab">
										<div class="nav-outer ">
											<ul class="nav nav-tabs trending " role="tablist">
												<li role="presentation" class="active"><a href="#"
													role="tab"> <b>ALL(0)</b>
												</a></li>
												<li role="presentation" class=""><a href="shared" role="tab">
														<b> BADGES SHARED(0)</b>
												</a></li>
												<li role="presentation" class=""><a href="received" role="tab">
														<b> BADGES RECIEVED(0)</b>
												</a></li>

												<li role="presentation" class=""><a
													href="badgeHistory" role="tab"> <b>
															BADGES HISTORY</b>
												</a></li>
											</ul>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-group">
						<div class="panel panel-default">

							<div class="panel-body">No data found</div>
						</div>

					</div>
				</div>

			</div>
			<!--col-md-8 over-->
		</div>
		<!--Container fluid over-->
	</div>
	<!--Class row over-->

	</div>
</body>
</html>
