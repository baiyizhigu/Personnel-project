/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.20
 * Generated at: 2022-09-28 02:17:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class admin_005fU_005fadm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/yueqian/作业/第二阶段项目/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Personnel_Management/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1663657070368L));
    _jspx_dependants.put("jar:file:/D:/yueqian/作业/第二阶段项目/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Personnel_Management/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153356282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!-- 加入tablib的声明 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("<meta name=\"keyword\"\r\n");
      out.write("\tcontent=\"Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina\">\r\n");
      out.write("<title>Gramos - Admin Dashboard</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap core CSS -->\r\n");
      out.write("<link href=\"assets/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- begin::global styles -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/vendors/bundle.css\" type=\"text/css\">\r\n");
      out.write("<!-- end::global styles -->\r\n");
      out.write("\r\n");
      out.write("<!-- begin::datepicker -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"assets/vendors/datepicker/daterangepicker.css\">\r\n");
      out.write("<!-- begin::datepicker -->\r\n");
      out.write("\r\n");
      out.write("<!-- begin::vmap -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/vendors/vmap/jqvmap.min.css\">\r\n");
      out.write("<!-- begin::vmap -->\r\n");
      out.write("\r\n");
      out.write("<!-- begin::custom styles -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/app.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/custom.css\" type=\"text/css\">\r\n");
      out.write("<!-- end::custom styles -->\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::page loader-->\r\n");
      out.write("\t<div class=\"page-loader\">\r\n");
      out.write("\t\t<div class=\"spinner-border\"></div>\r\n");
      out.write("\t\t<span>Loading ...</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- end::page loader -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::sidebar -->\r\n");
      out.write("\t<div class=\"sidebar\">\r\n");
      out.write("\t\t<ul class=\"nav nav-pills nav-justified m-b-30\" id=\"pills-tab\"\r\n");
      out.write("\t\t\trole=\"tablist\">\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" id=\"notifications-tab\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"pill\" href=\"#notifications\" role=\"tab\"\r\n");
      out.write("\t\t\t\taria-controls=\"notifications\" aria-selected=\"false\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fa fa-bell\"></i>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" id=\"settings-tab\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"pill\" href=\"#settings\" role=\"tab\"\r\n");
      out.write("\t\t\t\taria-controls=\"settings\" aria-selected=\"false\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"ti-settings\"></i>\r\n");
      out.write("\t\t\t</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 导入左侧菜单 -->\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<!-- end::side menu -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::navbar -->\r\n");
      out.write("\t<nav class=\"navbar\">\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"header-logo\">\r\n");
      out.write("\t\t\t<a href=\"#\"> <img src=\"assets/media/image/light-logo.png\"\r\n");
      out.write("\t\t\t\talt=\"...\"> <span class=\"logo-text d-none d-lg-block\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_login.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"header-body\">\r\n");
      out.write("\t\t\t<ul class=\"navbar-nav\">\r\n");
      out.write("\t\t\t\t<li class=\"nav-item dropdown d-none d-lg-block\">\r\n");
      out.write("\t\t\t\t\t<!-- <a href=\"#\"\r\n");
      out.write("\t\t\t\t\tclass=\"nav-link\" data-toggle=\"dropdown\"> <i\r\n");
      out.write("\t\t\t\t\t\tclass=\"fa fa-th-large\"></i>\r\n");
      out.write("\t\t\t\t</a> -->\r\n");
      out.write("\t\t\t\t\t<div class=\"dropdown-menu dropdown-menu-big dropdown-menu-nav-grid\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-menu-title\">Quick menu</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-menu-body\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"nav-grid\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"nav-grid-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"nav-grid-item\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-address-book-o\"></i> <span>App</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a> <a href=\"#\" class=\"nav-grid-item\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-envelope-o\"></i> <span>Mail</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"nav-grid-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"#\" class=\"nav-grid-item\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-sticky-note\"></i> <span>Chat</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a> <a href=\"#\" class=\"nav-grid-item\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-dashboard\"></i> <span>Dashboard</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<ul class=\"navbar-nav\">\r\n");
      out.write("\t\t\t\t<li class=\"nav-item\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\tclass=\"d-lg-none d-sm-block nav-link search-panel-open\"> <i\r\n");
      out.write("\t\t\t\t\t\tclass=\"fa fa-search\"></i>\r\n");
      out.write("\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item dropdown\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"dropdown\"> <img style=\"width: 35px; height: 35px;\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"rounded-circle\" src=\"/image/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_login.head}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" alt=\"...\">\r\n");
      out.write("\t\t\t\t\t\t</figure>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- <div class=\"dropdown-divider\"></div> -->\r\n");
      out.write("\t\t\t\t\t\t<a href=\"http://localhost:8080/Personnel_Management/\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"text-danger dropdown-item\">Logout</a>\r\n");
      out.write("\t\t\t\t\t</div></li>\r\n");
      out.write("\t\t\t\t<li class=\"nav-item d-lg-none d-sm-block\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\tclass=\"nav-link side-menu-open\"> <i class=\"ti-menu\"></i>\r\n");
      out.write("\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<!-- end::navbar -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::main content -->\r\n");
      out.write("\t<main class=\"main-content\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- here!---------------------------------------------------------------------------------------------------- -->\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"card col-md-12\">\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t<h3 class=\"card-title\">信息修改</h3>\r\n");
      out.write("\t\t\t\t\t<form action=\"admin_U_adm\" enctype=\"multipart/form-data\"\r\n");
      out.write("\t\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-1\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<figure class=\"\"> <img src=\"/image/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_admin.head}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"rounded-circle\" style=\"height: 80px; width: 80px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</figure>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"file\" name=\"filePart\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-1\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div style=\"height: 30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>编号：</span>");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"form-control form-control-lg\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_admin.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"form-control form-control-lg\" type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"old_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_admin.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div style=\"height: 30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>名称：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"U_name\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_admin.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-1\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div style=\"height: 30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>密码：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"form-control form-control-sm\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_admin.password}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div style=\"height: 30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>身份：</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"form-control form-control-sm\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=\"role\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${now_admin.role}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-4\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name_message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pas_message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${id_message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p style=\"color: green\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${suc_message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">提交修改</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- there!---------------------------------------------------------------------------------------------------------------- -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</main>\r\n");
      out.write("\t<!-- end::main content -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::global scripts -->\r\n");
      out.write("\t<script src=\"assets/vendors/bundle.js\"></script>\r\n");
      out.write("\t<!-- end::global scripts -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::charts -->\r\n");
      out.write("\t<script src=\"assets/vendors/charts/chartjs/chart.min.js\"></script>\r\n");
      out.write("\t<script src=\"assets/vendors/charts/peity/jquery.peity.min.js\"></script>\r\n");
      out.write("\t<script src=\"assets/js/examples/charts/chartjs.js\"></script>\r\n");
      out.write("\t<script src=\"assets/js/examples/charts/peity.js\"></script>\r\n");
      out.write("\t<!-- end::charts -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::daterangepicker -->\r\n");
      out.write("\t<script src=\"assets/vendors/datepicker/daterangepicker.js\"></script>\r\n");
      out.write("\t<!-- end::daterangepicker -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::dashboard -->\r\n");
      out.write("\t<script src=\"assets/js/examples/dashboard.js\"></script>\r\n");
      out.write("\t<!-- end::dashboard -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::vamp -->\r\n");
      out.write("\t<script src=\"assets/vendors/vmap/jquery.vmap.min.js\"></script>\r\n");
      out.write("\t<script src=\"assets/vendors/vmap/maps/jquery.vmap.usa.js\"></script>\r\n");
      out.write("\t<script src=\"assets/js/examples/vmap.js\"></script>\r\n");
      out.write("\t<!-- end::vamp -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- begin::custom scripts -->\r\n");
      out.write("\t<!-- <script src=\"assets/js/custom.js\"></script> -->\r\n");
      out.write("\t<script src=\"assets/js/app.js\"></script>\r\n");
      out.write("\t<!-- end::custom scripts -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- js placed at the end of the document so the pages load faster -->\r\n");
      out.write("\t<script src=\"assets/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /admin_U_adm.jsp(72,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roles == 'staff'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "staff_menu.jsp", out, false);
          out.write('\r');
          out.write('\n');
          out.write('	');
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /admin_U_adm.jsp(76,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roles == 'admin'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t");
          org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin_menu.jsp", out, false);
          out.write('\r');
          out.write('\n');
          out.write('	');
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
