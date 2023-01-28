<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录页面</title>

    <!-- begin::global styles -->
    <link rel="stylesheet" href="assets/vendors/bundle.css" type="text/css">
    <!-- end::global styles -->

    <!-- begin::custom styles -->
    <link rel="stylesheet" href="assets/css/app.css" type="text/css">
    <!-- end::custom styles -->

</head>
<body class="bg-white h-100-vh p-t-0">

<!-- begin::page loader-->
<div class="page-loader">
    <div class="spinner-border"></div>
    <span>Loading ...</span>
</div>
<!-- end::page loader -->

<div class="p-b-50 d-block d-lg-none"></div>

<div class="container h-100-vh">
    <div class="row align-items-md-center h-100-vh">
        <div class="col-lg-6 d-none d-lg-block">
            <img class="img-fluid" src="assets/media/svg/login.svg" alt="...">
        </div>
        <div class="col-lg-4 offset-lg-1">
            <div class="d-flex align-items-center m-b-20">
                <img src="assets/media/image/dark-logo.png" class="m-r-15" width="40" alt="">
                <h3 class="m-0">欢迎使用人事管理系统</h3>
            </div>
            <p>当前为管理员系统，请登录</p>
            <form class="form-login" action="AdminLogin" method="post">
                <div class="form-group mb-4">
                    <input type="text" value="${login_name}" name="name" class="form-control" placeholder="请输入用户名">
                </div>
                <div class="form-group mb-4">
                    <input type="password"  value="${login_password}" name="password" class="form-control" placeholder="请输入用户密码">
                </div>
                <button class="btn btn-primary btn-lg btn-block btn-uppercase mb-4" type="submit">登录</button>
                <!-- <div class="d-flex justify-content-between align-items-center mb-4">
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Keep me signed in</label>
                    </div>
                    <a href="#" class="auth-link text-black">Forgot password?</a>
                </div> -->
                <div style="text-align:center">
                <p style="color: red">${message}</p>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-4">                    
                        <a href="http://localhost:8080/Personnel_Management/" class="btn btn-outline-facebook btn-block">
                            <i class="m-r-5"></i> 员工登录
                        </a>
                    </div>
                    <div class="col-md-6 mb-4">
                        <a href="" class="btn btn-outline-google btn-block">
                            <i class="m-r-5"></i> 管理员登录
                        </a>
                    </div>
                </div>
                <!-- <div class="text-center">
                    Don't have an account? <a href="register.html" class="text-primary">Create</a>
                </div> -->
            </form>
        </div>
    </div>
</div>

<!-- begin::global scripts -->
<script src="assets/vendors/bundle.js"></script>
<!-- end::global scripts -->

<!-- begin::custom scripts -->
<script src="assets/js/app.js"></script>
<!-- end::custom scripts -->

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>