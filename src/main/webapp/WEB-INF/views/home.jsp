<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="resources/images/favicon.ico">
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
		<a href="home" class="logo"><img src="resources/images/reap-logo.png"
			style="margin-top: 10px; width: 107px; height: 32px";></a> <img
			class="reapfull hidden-xs" src="resources/images/reap.png">
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
						id="test" src="resources/images/ico-dashboard.png">
						Dashboard</a></li>
				<li><a href='<c:url value="badges" />' class="navbtn"
					id="badge"><img src="resources/images/ico-badge.png">
						Badges</a></li>
				<li style="float: right padding-top:2px;"><a href="#"><img
						src="resources/images/sanam.jpg"
						style="margin-top: 2px; width: 40px; height: 50px"
						; data-toggle="modal" data-target="#myModal"></a></li>
			</ul>
			<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog"
				data-backdrop="false">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Your Profile</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-md-3 col-sm-3 col-lg-3E">
									<div class="col-md-12 col-sm-12 col-lg-12">
										<div class="head-bar">
											<img style="float: left; height: 150px; width: 130px"
												src="resources/images/sanam.jpg">
										</div>
									</div>
								</div>

								<div class="col-md-9 col-sm-9 col-lg-">

									<div class="col-md-12 col-sm-12 col-lg-12">




										<div class="table-responsive">
											<table class="table table-bordered ">

												<tbody>
													<tr class="size">
														<td style="width: 25%">Employee-ID</td>
														<td><strong>${employeeDetails.id}</strong></td>
													</tr>
													<tr class="size">
														<td style="width: 25%">Name</td>
														<td><strong>${employeeDetails.name}</strong></td>

													</tr>

													<tr class="size">
														<td style="width: 25%">Service Line</td>
														<td><strong>${employeeDetails.serviceLine}</strong></td>

													</tr>
													<tr class="size">
														<td style="width: 25%">Practice</td>
														<td><strong>${employeeDetails.practice}</strong></td>
													</tr>
													<tr class="size">
														<td style="width: 25%">Email-ID</td>
														<td><strong>${employeeDetails.email}</strong></td>

													</tr>
												</tbody>
											</table>

										</div>




									</div>
								</div>
							</div>
							<div class="modal-footer">
								<!-- <button type="button" class="btn btn-default"
									data-dismiss="modal">Log out</button> -->
								<a href="logout"><strong>Logout</strong></a>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- Modal End -->
		</div>

	</div>
	</nav>

	<div class="container-fluid" style="background: #f1f4f5;">
		<div class="row" style="padding: 0 15;">
			<div class="col-md-9" style="padding: 0 15;">
				<div class="panel panel-default" style="margin-top: 30px">
					<div class="panel-heading"
						style="background: #ea8744; color: #ffffff">
						<img src="resources/images/ico-badge-white.png" /> <strong
							style="font-size: 14px">&nbsp; RECOGNIZE KARMA</strong>
					</div>
					<div class="panel-body">
						<form:form action="karma" method="post" class="form-group"
							modelAttribute="newBadgeTransaction">
							<div class="row">
								<div class="col-md-12">
									<div class="col-md-6">
										<form:input path="receiverId" type="text" class="form-control"
											placeholder="Select a Newer"
											style="padding-left: 40px; border: 1px solid #e5e5e5;" />
										<input type="hidden" name="user" id="user" /> <span
											style="padding: 4px 12px; border-right: 1px solid #e5e5e5; position: absolute; top: 6px;">
											<img src="resources/images/select-newer.png">
										</span>
									</div>
									<div class="col-md-6">
										<div class="col-md-5 dropdown">
											<span> <form:select path="badge" class="form-control"
													name="badgeType" id="badgeType">
													<option>Select a Badge</option>
													<option value="gold">Gold
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														(${remainingBadges.gold})</option>
													<option value="silver">Silver
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (${remainingBadges.silver})</option>
													<option value="bronze">Bronze &nbsp;&nbsp;&nbsp;
														(${remainingBadges.bronze})</option>
												</form:select>
											</span>
										</div>
										<div class="col-md-7">
											<span> <form:select path="karma" class="form-control"
													name="karma" id="karma">
													<option>Select a Karma</option>
													<option value="Extra Miler">Extra Miler</option>
													<option value="Knowledge Sharing">Knowledge
														Sharing</option>
													<option value="Mentorship">Mentorship</option>
													<option value="Pat on the back">Pat on the back</option>
													<option value="Customer Delight">Customer Delight</option>
												</form:select>
											</span>
										</div>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label for="name">Reason :</label>
										<form:textarea path="reason" class="form-control" rows="7"
											resize="none"></form:textarea>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12" align="right">
									<input type="submit" name="submit" value="Recognize"
										class="btn btn-default" id="submit"
										style="background: #505B72; color: white" />
								</div>
							</div>
						</form:form>
					</div>
				</div>

				<!-- Wall of fame-->
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-heading"
							style="background: #8d9fc4; color: #ffffff">
							<div class="row">
								<div class="col-lg-4">
									<img src="resources/images/ico-wall.png" /> <strong
										style="font-size: 16px"> WALL OF FAME</strong>
								</div>
								<form action="#" method="post">
									<div class="col-md-7">
										<input type="text" class="form-control" placeholder="Search"
											value="">
									</div>
									<div class="col-md-1" id="datetimepicker">
										<span class="glyphicon glyphicon-calendar"
											style="font-size: 30px"></span>
									</div>
								</form>
							</div>
						</div>
						<!-- End of panel heading  -->

						<div class="panel-body">
							<div class="content">

								<c:forEach var="badgeTransaction"
									items="${badgeTransactionList}">
									<div class="row">
										<div class="col-md-2" style="padding-top: 10px">
											<center>
												<img src="resources/images/my-photo" alt="image"
													class="img-rounded" width="50px" height="50px">
											</center>
										</div>
										<div class="col-md-10" style="padding-top: 10px">
											<strong><a
												href="badge/index/${badgeTransaction.receiver.id}">${badgeTransaction.receiver.name}</a></strong>
											has received <img src="resources/images/silver.png"
												title="Silver" alt="Silver"> from <strong><a
												href="badge/index/${badgeTransaction.sender.id}">${badgeTransaction.sender.name}</a></strong>
											for Karma : ${badgeTransaction.karma}
											<div>
												Reason : ${badgeTransaction.reason} <br> <i
													class="momentDate"> ${badgeTransaction.date} </i>
											</div>
										</div>
									</div>
									<hr>
								</c:forEach>

							</div>
						</div>
						<!-- end of panel body -->
					</div>
					<!-- End of wall of fame -->
				</div>
			</div>
			<div class="col-md-3">
				<div class="panel panel-default" style="margin-top: 30px">
					<div class="panel-heading"
						style="background: #8d9fc4; color: #ffffff">
						<img src="resources/images/ico-badge-white.png"> <strong
							style="font-size: 16px"> MY BADGES</strong>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-4" style="padding-top: 10px">
								<center>
									<img src="resources/images/my-photo" alt="image"
										class="img-rounded" width="50px" height="50px">
								</center>
							</div>
							<div class="col-lg-8" style="padding-top: 10px">
								<div class="row">
									<a href="badge/index/${employeeDetails.id}"> <strong
										style="font-size: 15px">${employeeDetails.name}</strong></a>

								</div>
								<div class="row" style="padding-top: 5px">
									<div class="col-xs-3">
										<img class="img-rounded img-responsive"
											src="resources/images/gold.png">
									</div>
									<div class="col-xs-3">
										<img class="img-rounded img-responsive"
											src="resources/images/silver.png">
									</div>
									<div class="col-xs-3">
										<img class="img-rounded img-responsive"
											src="resources/images/bronze.png">
									</div>
								</div>
								<div class="row" style="padding-top: 5px">
									<div class="col-xs-3">${receivedBadges.gold}</div>
									<div class="col-xs-3">${receivedBadges.silver}</div>
									<div class="col-xs-3">${receivedBadges.bronze}</div>
								</div>
							</div>
						</div>
						<br> <br>
					</div>
					<!--  panel body -->
				</div>

				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab">NEWER
								BOARDS</a></li>
						<!-- <li><a href="#tab2" data-toggle="tab">IDEAS</a></li> -->
					</ul>
					<div class="tab-content" style="background: #ffffff;">
						<div class="tab-pane active" id="tab1">
							<div class="container-fluid">
								<c:forEach var="receivedBadges" items="${receivedBadgesList}">
									<div class="row">
										<div class="col-lg-4" style="padding-top: 10px">
											<center>
												<img src="resources/images/my-photo" alt="image"
													class="img-rounded" width="50px" height="50px">
											</center>
										</div>
										<div class="col-lg-8" style="padding-top: 10px">
											<div class="row">
												<a href="badge/index/${receivedBadges.employeeDetails.id}">
													<strong style="font-size: 15px">${receivedBadges.employeeDetails.name}</strong>
												</a>
											</div>
											<div class="row" style="padding-top: 5px">
												<div class="col-xs-3">
													<img class="img-rounded img-responsive"
														src="resources/images/gold.png">
												</div>
												<div class="col-xs-3">
													<img class="img-rounded img-responsive"
														src="resources/images/silver.png">
												</div>
												<div class="col-xs-3">
													<img class="img-rounded img-responsive"
														src="resources/images/bronze.png">
												</div>
											</div>
											<div class="row" style="padding-top: 5px">
												<div class="col-xs-3">${receivedBadges.gold}</div>
												<div class="col-xs-3">${receivedBadges.silver}</div>
												<div class="col-xs-3">${receivedBadges.bronze}</div>
											</div>
										</div>
									</div>
									<hr>
								</c:forEach>

							</div>
						</div>
					</div>
					<!-- tab-content ended -->
				</div>
			</div>
		</div>
	</div>
</body>