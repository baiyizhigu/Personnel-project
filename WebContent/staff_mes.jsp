<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 加入tablib的声明 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.gec.entity.Message"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Gramos - Admin Dashboard</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">

<!-- begin::global styles -->
<link rel="stylesheet" href="assets/vendors/bundle.css" type="text/css">
<!-- end::global styles -->

<!-- begin::datepicker -->
<link rel="stylesheet"
	href="assets/vendors/datepicker/daterangepicker.css">
<!-- begin::datepicker -->

<!-- begin::vmap -->
<link rel="stylesheet" href="assets/vendors/vmap/jqvmap.min.css">
<!-- begin::vmap -->

<!-- begin::custom styles -->
<link rel="stylesheet" href="assets/css/app.css" type="text/css">
<link rel="stylesheet" href="assets/css/custom.css" type="text/css">
<!-- end::custom styles -->

</head>
<body>

	<!-- begin::page loader-->
	<div class="page-loader">
		<div class="spinner-border"></div>
		<span>Loading ...</span>
	</div>
	<!-- end::page loader -->

	<!-- begin::sidebar -->
	<div class="sidebar">
		<ul class="nav nav-pills nav-justified m-b-30" id="pills-tab"
			role="tablist">
			<li class="nav-item"><a class="nav-link" id="notifications-tab"
				data-toggle="pill" href="#notifications" role="tab"
				aria-controls="notifications" aria-selected="false"> <i
					class="fa fa-bell"></i>
			</a></li>
			<li class="nav-item"><a class="nav-link" id="settings-tab"
				data-toggle="pill" href="#settings" role="tab"
				aria-controls="settings" aria-selected="false"> <i
					class="ti-settings"></i>
			</a></li>
		</ul>

	</div>

	</div>

	</div>
	</div>

	<!-- 导入左侧菜单 -->
	<c:if test="${roles == 'staff'}">
		<jsp:include page="staff_menu.jsp" />
	</c:if>

	<c:if test="${roles == 'admin'}">
		<jsp:include page="admin_menu.jsp" />
	</c:if>
	<!-- end::side menu -->

	<!-- begin::navbar -->
	<nav class="navbar">
	<div class="container-fluid">

		<div class="header-logo">
			<a href="#"> <img src="assets/media/image/light-logo.png"
				alt="..."> <span class="logo-text d-none d-lg-block">${now_login.name}</span>
			</a>
		</div>

		<div class="header-body">
			<ul class="navbar-nav">
				<li class="nav-item dropdown d-none d-lg-block">
					<!-- <a href="#"
					class="nav-link" data-toggle="dropdown"> <i
						class="fa fa-th-large"></i>
				</a> -->
					<div class="dropdown-menu dropdown-menu-big dropdown-menu-nav-grid">
						<div class="dropdown-menu-title">Quick menu</div>
						<div class="dropdown-menu-body">
							<div class="nav-grid">
								<div class="nav-grid-row">
									<a href="#" class="nav-grid-item"> <i
										class="fa fa-address-book-o"></i> <span>App</span>
									</a> <a href="#" class="nav-grid-item"> <i
										class="fa fa-envelope-o"></i> <span>Mail</span>
									</a>
								</div>
								<div class="nav-grid-row">
									<a href="#" class="nav-grid-item"> <i
										class="fa fa-sticky-note"></i> <span>Chat</span>
									</a> <a href="#" class="nav-grid-item"> <i
										class="fa fa-dashboard"></i> <span>Dashboard</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</li>
			</ul>

			<ul class="navbar-nav">
				<li class="nav-item"><a href="#"
					class="d-lg-none d-sm-block nav-link search-panel-open"> <i
						class="fa fa-search"></i>
				</a></li>
				<li class="nav-item dropdown"><a href="#"
					data-toggle="dropdown"> <img style="width: 35px; height: 35px;"
						class="rounded-circle" src="/image/${now_login.head}" alt="...">
						</figure>
				</a>
					<div class="dropdown-menu dropdown-menu-right">

						<!-- <div class="dropdown-divider"></div> -->
						<a href="http://localhost:8080/Personnel_Management/"
							class="text-danger dropdown-item">Logout</a>
					</div></li>
				<li class="nav-item d-lg-none d-sm-block"><a href="#"
					class="nav-link side-menu-open"> <i class="ti-menu"></i>
				</a></li>
			</ul>
		</div>

	</div>
	</nav>
	<!-- end::navbar -->

	<!-- begin::main content -->
	<main class="main-content">

	<div class="container-fluid">

		<!-- here!---------------------------------------------------------------------------------------------------- -->


		<div class="container-fluid">

			<!-- begin::page header -->
			<!-- <div
				class="page-header d-md-flex justify-content-between align-items-center">
				<div>
					<h4>Chat</h4>
					<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
						<li class="breadcrumb-item"><a href="#">Apps</a></li>
						<li class="breadcrumb-item active" aria-current="page">Chat</li>
					</ol>
					</nav>
				</div>
				<button type="submit" class="btn btn-primary" data-toggle="modal"
					data-target="#createEventModal">
					<i class="ti-comment m-r-5"></i> New Chat
				</button>
			</div> -->
			<!-- end::page header -->

			<div class="card chat-app-wrapper">
				<div class="row chat-app">
					<div class="col-lg-3 chat-sidebar">
						<div class="chat-sidebar-search">
							<form action="staff_Q_alls">
								<input type="text" class="form-control" placeholder="搜索"
									name="search" value="${name}">
							</form>
						</div>
						<div class="chat-sidebar-messages">
							<div class="list-group">

								<!-- aaaaaaaa -->
								<!-- 遍历集合 -->
								<c:forEach items="${staffList}" var="Q_alls">
									<a href="staff_Q_mes?r_id=${Q_alls.id}"
										class="list-group-item list-group-item-action d-flex ">
										<div>
											<figure class="avatar avatar-sm"> <img
												src="/image/${Q_alls.head}" class="rounded-circle"> </figure>
										</div>
										<div>
											<h6 class="m-0">${Q_alls.name}</h6>
											<!-- <p class="m-0 small">Lorem ipsum dolor sit amet.</p> -->
										</div> <!-- <span class="badge badge-primary badge-pill ml-auto">new</span> -->
										<%-- <c:set var="istrue" value="false" /> <c:set var="id"
											value="${Q_alls.id}" /> <c:forEach items="${idList}"
											var="item">
											<c:if test="${item eq id}">
												<c:set var="istrue" value="true" />
											</c:if>
										</c:forEach> <c:if test="${istrue}">
											<span class="badge badge-primary badge-pill ml-auto">new</span>
										</c:if> --%>
									</a>
								</c:forEach>
								<!-- aaaaaa -->

							</div>
						</div>
					</div>
					<div class="col-lg-9 chat-body">
						<div class="chat-body-header">
							<a href="#"
								class="btn btn-dark opacity-3 m-r-10 btn-chat-sidebar-open">
								<i class="ti-menu"></i>
							</a>
							<div>
								<h6 class="m-b-0 m-t-5">${r_name}</h6>
								<!-- <i class="small text-success">He is writing . . .</i> -->
							</div>
							<!-- <div class="ml-auto d-flex">
								<button type="button"
									class="ml-2 btn btn-sm btn-success btn-floating">
									<i class="fa fa-video-camera"></i>
								</button>
								<div class="dropdown ml-2">
									<button type="button" data-toggle="dropdown"
										class="btn btn-sm  btn-warning btn-floating">
										<i class="fa fa-cog"></i>
									</button>
									<div class="dropdown-menu dropdown-menu-right">
										<div class="dropdown-menu-body">
											<ul>
												<li><a class="dropdown-item" href="#">Profile</a></li>
												<li><a class="dropdown-item" href="#">Block</a></li>
												<li><a class="dropdown-item" href="#">Delete</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div> -->
						</div>
						<div class="chat-body-messages">
							<div class="message-items">
								<!-- <div class="message-item message-item-date-border">
									<span class="badge">Today</span>
								</div> -->

								<%-- <div class="message-item">
											123<small class="message-item-date text-muted">${Q_mes.time}</small>
										</div>
								<div class="message-item outgoing-message">
											456<small class="message-item-date text-muted">${Q_mes.time}</small>
										</div> --%>

								<!-- 111111111111111111111111 -->
								<!-- 遍历集合 -->
							<%
								List<Message> messageList = (List<Message>) request.getAttribute("messageList");
								int r_id = Integer.parseInt(request.getAttribute("r_id").toString());
								int now_id = Integer.parseInt(request.getAttribute("now_id").toString());
							%>
							
							<%for (int i = 0; i < messageList.size(); i++) {%>
							
								<%if (messageList.get(i).getSend_id() == r_id) {%>
								<div class="message-item">
									<%=messageList.get(i).getContent()%>
									<small class="message-item-date text-muted"><%=messageList.get(i).getTime()%></small>
								</div>
								<%}%>
								
								<%if (messageList.get(i).getSend_id() == now_id) {%>
								<div class="message-item outgoing-message">
									<%=messageList.get(i).getContent()%>
									<small class="message-item-date text-muted"><%=messageList.get(i).getTime()%>
									<%=messageList.get(i).getState()%></small>
								</div>
								<%}%>
							<%}%>
								<!-- 111111111111111111111111 -->

							</div>
						</div>
						<div class="chat-body-footer">
							<form class="d-flex align-items-center" action="staff_S_mes">
								<input type="text" class="form-control" placeholder=""
									name="content">
								<div class="d-flex">
									<button type="submit" class="ml-3 btn btn-primary btn-floating">
										<i class="fa fa-send"></i>
									</button>
									<!-- <div class="dropup">
										<button type="button" data-toggle="dropdown"
											class="ml-3 btn btn-success btn-floating">
											<i class="fa fa-plus"></i>
										</button>
										<div class="dropdown-menu dropdown-menu-right">
											<div class="dropdown-menu-body">
												<ul>
													<li><a class="dropdown-item" href="#"> <i
															class="icon fa fa-picture-o"></i> Image
													</a></li>
													<li><a class="dropdown-item" href="#"> <i
															class="icon fa fa-video-camera"></i> Video
													</a></li>
												</ul>
											</div>
										</div>
									</div> -->
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- there!---------------------------------------------------------------------------------------------------------------- -->


	</div>

	</main>
	<!-- end::main content -->

	<!-- begin::global scripts -->
	<script src="assets/vendors/bundle.js"></script>
	<!-- end::global scripts -->

	<!-- begin::charts -->
	<script src="assets/vendors/charts/chartjs/chart.min.js"></script>
	<script src="assets/vendors/charts/peity/jquery.peity.min.js"></script>
	<script src="assets/js/examples/charts/chartjs.js"></script>
	<script src="assets/js/examples/charts/peity.js"></script>
	<!-- end::charts -->

	<!-- begin::daterangepicker -->
	<script src="assets/vendors/datepicker/daterangepicker.js"></script>
	<!-- end::daterangepicker -->

	<!-- begin::dashboard -->
	<script src="assets/js/examples/dashboard.js"></script>
	<!-- end::dashboard -->

	<!-- begin::vamp -->
	<script src="assets/vendors/vmap/jquery.vmap.min.js"></script>
	<script src="assets/vendors/vmap/maps/jquery.vmap.usa.js"></script>
	<script src="assets/js/examples/vmap.js"></script>
	<!-- end::vamp -->

	<!-- begin::custom scripts -->
	<!-- <script src="assets/js/custom.js"></script> -->
	<script src="assets/js/app.js"></script>
	<!-- end::custom scripts -->

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery-3.3.1.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>