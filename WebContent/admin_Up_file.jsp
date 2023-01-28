<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 加入tablib的声明 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
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

		<div class="row">
			<div class="card col-md-12">
				<div class="card-body">
					<h3 class="card-title">文件上传</h3>
					<form action="admin_Up_file" enctype="multipart/form-data"
						method="post">
						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-4">
								<div style="height: 30px;">
									<span>请输入文件标题：</span>
								</div>
								<div class="form-group">
									<input class="form-control form-control-lg" type="text"
										name="title">
								</div>
							</div>
							<div class="col-md-2">
								<div style="height: 30px;">
									<span>请输入上传人编号：</span>
								</div>
								<div class="form-group">
									<input class="form-control form-control-lg" type="text"
										name="upload_id">
								</div>
							</div>
							<div class="col-md-2">
								<div style="height: 30px;">
									<span>请输入身份：</span>
								</div>
								<div class="form-group">
									<input class="form-control form-control-lg" type="text"
										name="identity" placeholder="请输入sta/adm">
								</div>
							</div>
							<div style="padding-top: 30px;">
								<input type="file" name="filePart">
							</div>
						</div>
						<!-- <div style="height: 20px;"></div> -->
						<div class="row">
							<div class="col-md-3"></div>
							<div>
								<p style="color: red">${file_message}</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-5"></div>
							<div>
								<button type="submit" class="btn btn-primary" onclick="addFun()">开始上传</button>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- there!---------------------------------------------------------------------------------------------------------------- -->
		<!-- <script type="text/javascript">
			function addFun() {
				alert('上传成功！');
			}
		</script> -->

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