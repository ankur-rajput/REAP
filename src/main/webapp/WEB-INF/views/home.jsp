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
		<a href="#" class="logo"><img src="resources/images/reap-logo.png"
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
				<li><a href="#" class="navbtn" id="idea"><img
						src="resources/images/ico-idea.png"> Idea</a></li>
				<li><a href="#"><img src="resources/images/ico-bell.png"
						style="margin-top:"></a></li>
			</ul>
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
							style="font-size: 14px">&nbsp RECOGNIZE KARMA</strong>
					</div>
					<div class="panel-body">
						<form:form action="#" method="post" class="form-group"
							modelAttribute="badgeTransaction">
							<div class="row">
								<div class="col-md-12">
									<div class="col-md-6">
										<form:input path="receiver" type="text" class="form-control"
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
													<option value="gold">Gold &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														(${remainingBadges.gold})</option>
													<option value="silver">Silver &nbsp;&nbsp;&nbsp;&nbsp;
														(${remainingBadges.silver})</option>
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
									<div class="col-md-2">
										<input type="text" class="form-control" placeholder="Search"
											value="">
									</div>
									<div class="col-md-3">
										<span> <select class="form-control" required
											name="services" id="services" showAll="true"
											defaultLabel="Service Lines">
												<option value="">Service Lines</option>
												<option value="2">Analytics</option>
												<option value="12">Analytics-SEA</option>
												<option value="9">Digital Marketing</option>
												<option value="20">Digital Marketing India</option>
												<option value="13">Digital Marketing-SEA</option>
												<option value="1">Technology</option>
												<option value="6">ThoughtBuzz India</option>
												<option value="21">TTN Overheads</option>
												<option value="23">TTND-Intern</option>
												<option value="17">TTND-SEA</option>
												<option value="22">TTNV</option>
												<option value="19">Video Solutions</option>
										</select>
										</span>
									</div>
									<div class="col-md-2">
										<span id="practicehead"> <select name="practice"
											class="form-control" showAll="true" defaultLabel="Practices"
											id="practice">
												<option value="">Practices</option>
												<option value="6">Admin</option>
												<option value="14">AMC</option>
												<option value="63">Analytics</option>
												<option value="46">Analytics-SEA</option>
												<option value="20">BigData</option>
												<option value="80">BlogMint</option>
												<option value="70">Business Development</option>
												<option value="37">Creative</option>
												<option value="10">Design</option>
												<option value="71">DevOps</option>
												<option value="66">DM India CORPORATE</option>
												<option value="60">Drupal</option>
												<option value="73">Feen</option>
												<option value="16">Finance</option>
												<option value="9">HR</option>
												<option value="84">Intern</option>
												<option value="68">IT</option>
												<option value="72">JVM</option>
												<option value="40">Management</option>
												<option value="48">MARTECH</option>
												<option value="23">Mean</option>
												<option value="65">Media Planning &amp; Buying</option>
												<option value="11">Mobility</option>
												<option value="83">Sales &amp; Marketing</option>
												<option value="76">Security</option>
												<option value="58">Shared Services-SEA</option>
												<option value="43">Social media</option>
												<option value="64">Social Media Marketing</option>
												<option value="50">Social Media-SEA</option>
												<option value="28">Strategy</option>
												<option value="74">Technology Corporate</option>
												<option value="75">Testing</option>
												<option value="81">ThoughtBuzz India</option>
												<option value="67">TTN Overheads</option>
												<option value="69">TTNVManagement</option>
												<option value="79">Video Corporate</option>
												<option value="78">Video Managed Services</option>
												<option value="77">Video Ready</option>
										</select>
										</span>
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
								<div class="row">
									<div class="col-md-2" style="padding-top: 10px">
										<center>
											<img src="resources/images/my-photo" alt="image"
												class="img-rounded" width="50px" height="50px">
										</center>
									</div>
									<div class="col-md-10" style="padding-top: 10px">
										<a href="#"> <strong>Ankur TTND</strong>
										</a> has received <img src="resources/images/silver.png"
											title="Silver" alt="Silver"> from <a href="#"> <strong>Pratishtha
												Sharma</strong>
										</a> for Karma : Knowledge Sharing
										<div>
											Reason : No reasons; <br> <i class="momentDate"
												data-date="20160617 15:21:13"> DATE: 17-Jun-2016 </i>
										</div>
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-md-2" style="padding-top: 10px">
										<center>
											<img src="resources/images/my-photo" alt="image"
												class="img-rounded" width="50px" height="50px">
										</center>
									</div>
									<div class="col-md-10" style="padding-top: 10px">
										<a href="#"> <strong>Ankur TTND</strong>
										</a> has received <img src="resources/images/silver.png"
											title="Silver" alt="Silver"> from <a href="#"> <strong>Pratishtha
												Sharma</strong>
										</a> for Karma : Knowledge Sharing
										<div>
											Reason : No reasons; <br> <i class="momentDate"
												data-date="20160617 15:21:13"> DATE: 17-Jun-2016 </i>
										</div>
									</div>
								</div>
								<hr>
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
									<a href="#"> <strong style="font-size: 15px"><a
											href="badge/index/${employeeDetails.id}">${employeeDetails.name}</a></strong>
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
						<br> <br>
					</div>
					<!--  panel body -->
				</div>

				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab">NEWER
								BOARDS</a></li>
						<li><a href="#tab2" data-toggle="tab">IDEAS</a></li>
					</ul>
					<div class="tab-content" style="background: #ffffff;">
						<div class="tab-pane active" id="tab1">
							<div class="container-fluid">
								<div class="row">
									<div class="col-lg-4" style="padding-top: 10px">
										<center>
											<img src="resources/images/my-photo" alt="image"
												class="img-rounded" width="50px" height="50px">
										</center>
									</div>
									<div class="col-lg-8" style="padding-top: 10px">
										<div class="row">
											<a href="#"> <strong style="font-size: 15px">Ankur
													TTND</strong>
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
											<div class="col-xs-3">0</div>
											<div class="col-xs-3">1</div>
											<div class="col-xs-3">0</div>
										</div>
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-lg-4" style="padding-top: 10px">
										<center>
											<img src="resources/images/my-photo" alt="image"
												class="img-rounded" width="50px" height="50px">
										</center>
									</div>
									<div class="col-lg-8" style="padding-top: 10px">
										<div class="row">
											<a href="#"> <strong style="font-size: 15px">Ankur
													TTND</strong>
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
											<div class="col-xs-3">0</div>
											<div class="col-xs-3">1</div>
											<div class="col-xs-3">0</div>
										</div>
									</div>
								</div>
								<hr>
							</div>
						</div>
						<div class="tab-pane" id="tab2">
							<div class="row" style="padding-top: 7px">
								<div class="col-lg-3" style="padding-top: 10px">
									<center>
										<img src="resources/images/my-photo" alt="image"
											class="img-rounded" width="50px" height="50px">
									</center>
								</div>
								<div class="col-lg-9" style="padding-top: 10px">
									<div>
										<a href="#ideaInfo_20"
											title="Standard Operating Procedure (SOP)">Standard
											Operating Procedure (SOP)</a> <i> <a href="/badge/index/1093">
												<strong>Surendra Mahawar</strong>
										</a>
										</i>
									</div>
								</div>
							</div>
							<hr>
							<div class="row" style="padding-top: 7px">
								<div class="col-lg-3" style="padding-top: 10px">
									<center>
										<img src="resources/images/my-photo" alt="image"
											class="img-rounded" width="50px" height="50px">
									</center>
								</div>
								<div class="col-lg-9" style="padding-top: 10px">
									<div>
										<a href="#ideaInfo_20"
											title="Standard Operating Procedure (SOP)">Standard
											Operating Procedure (SOP) -</a> <i> <a
											href="/badge/index/1093"> <strong>Surendra
													Mahawar</strong>
										</a>
										</i>
									</div>
								</div>
							</div>
							<hr />
						</div>
					</div>
					<!-- tab-content ended -->
				</div>
			</div>
		</div>
	</div>
</body>