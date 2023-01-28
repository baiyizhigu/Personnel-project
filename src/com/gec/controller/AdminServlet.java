package com.gec.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gec.entity.Admin;
import com.gec.entity.Department;
import com.gec.entity.File;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.ResultData;
import com.gec.entity.Staff;
import com.gec.service.AdminService;
import com.gec.service.impl.AdminServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(urlPatterns = { "/AdminLogin", "/admin_Q_dep", "/admin_Q_pos", "/admin_Q_not", "/admin_Q_adm",
		"/admin_Q_sta", "/admin_QD_file", "/admin_Do_file", "/admin_UD_adm", "/admin_D_adm", "/admin_QU_adm",
		"/admin_U_adm", "/admin_A_adm", "/admin_UD_dep", "/admin_D_dep", "/admin_QU_dep", "/admin_U_dep",
		"/admin_A_dep", "/admin_UD_pos", "/admin_D_pos", "/admin_QU_pos", "/admin_U_pos", "/admin_A_pos",
		"/admin_UD_not", "/admin_D_not", "/admin_QU_not", "/admin_U_not", "/admin_A_not", "/admin_UD_sta",
		"/admin_D_sta", "/admin_QU_sta", "/admin_U_sta", "/admin_A_sta", "/admin_D_file", "/admin_De_file",
		"/admin_Up_file", "/admin_AQ_sta", "/FindDeptJob", "/admin_UQu_sta" })
@MultipartConfig
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int now_id;
	String role;
	int depart_id;
	// 获取业务层的对象，调用业务操作方法
	private static AdminService service = new AdminServiceImpl();

	// 请求处理方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 给请求对象设置编码集
		request.setCharacterEncoding("UTF-8");
		// 设置响应的类型及字符集编码
		response.setContentType("text/json;charset=utf-8");
		// 获取请求path
		String path = request.getServletPath();
		System.out.println(path);
		// 判断
		if (path.equals("/AdminLogin")) {
			AdminLogin(request, response);
		} else if (path.equals("/admin_Q_dep")) {
			admin_Q_dep(request, response);
		} else if (path.equals("/admin_Q_pos")) {
			admin_Q_pos(request, response);
		} else if (path.equals("/admin_Q_not")) {
			admin_Q_not(request, response);
		} else if (path.equals("/admin_Q_adm")) {
			admin_Q_adm(request, response);
		} else if (path.equals("/admin_Q_sta")) {
			admin_Q_sta(request, response);
		} else if (path.equals("/admin_QD_file")) {
			admin_QD_file(request, response);
		} else if (path.equals("/admin_Do_file")) {
			admin_Do_file(request, response);
		} else if (path.equals("/admin_UD_adm")) {
			admin_UD_adm(request, response);
		} else if (path.equals("/admin_D_adm")) {
			admin_D_adm(request, response);
		} else if (path.equals("/admin_QU_adm")) {
			admin_QU_adm(request, response);
		} else if (path.equals("/admin_U_adm")) {
			admin_U_adm(request, response);
		} else if (path.equals("/admin_A_adm")) {
			admin_A_adm(request, response);
		} else if (path.equals("/admin_UD_dep")) {
			admin_UD_dep(request, response);
		} else if (path.equals("/admin_D_dep")) {
			admin_D_dep(request, response);
		} else if (path.equals("/admin_QU_dep")) {
			admin_QU_dep(request, response);
		} else if (path.equals("/admin_U_dep")) {
			admin_U_dep(request, response);
		} else if (path.equals("/admin_A_dep")) {
			admin_A_dep(request, response);
		} else if (path.equals("/admin_UD_pos")) {
			admin_UD_pos(request, response);
		} else if (path.equals("/admin_D_pos")) {
			admin_D_pos(request, response);
		} else if (path.equals("/admin_QU_pos")) {
			admin_QU_pos(request, response);
		} else if (path.equals("/admin_U_pos")) {
			admin_U_pos(request, response);
		} else if (path.equals("/admin_A_pos")) {
			admin_A_pos(request, response);
		} else if (path.equals("/admin_UD_not")) {
			admin_UD_not(request, response);
		} else if (path.equals("/admin_D_not")) {
			admin_D_not(request, response);
		} else if (path.equals("/admin_QU_not")) {
			admin_QU_not(request, response);
		} else if (path.equals("/admin_U_not")) {
			admin_U_not(request, response);
		} else if (path.equals("/admin_A_not")) {
			admin_A_not(request, response);
		} else if (path.equals("/admin_UD_sta")) {
			admin_UD_sta(request, response);
		} else if (path.equals("/admin_D_sta")) {
			admin_D_sta(request, response);
		} else if (path.equals("/admin_QU_sta")) {
			admin_QU_sta(request, response);
		} else if (path.equals("/admin_U_sta")) {
			admin_U_sta(request, response);
		} else if (path.equals("/admin_A_sta")) {
			admin_A_sta(request, response);
		} else if (path.equals("/admin_D_file")) {
			admin_D_file(request, response);
		} else if (path.equals("/admin_De_file")) {
			admin_De_file(request, response);
		} else if (path.equals("/admin_Up_file")) {
			admin_Up_file(request, response);
		} else if (path.equals("/admin_AQ_sta")) {
			admin_AQ_sta(request, response);
		} else if (path.equals("/FindDeptJob")) {
			FindDeptJob(request, response);
		} else if (path.equals("/admin_UQu_sta")) {
			admin_UQu_sta(request, response);
		}
	}

	// 登录-------------------------------------------
	protected void AdminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取key-value
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin loginAdmin = service.queryByAccess(name, password);
		// 2、判断--校验结果
		if (loginAdmin != null) {// 登录成功
			now_id = loginAdmin.getId();
			// 登录成功将数据保存在session
			request.getSession().setAttribute("now_login", loginAdmin);
			// 管理员身份
			request.getSession().setAttribute("roles", "admin");
			// 超级/普通
			request.getSession().setAttribute("role", loginAdmin.getRole());
			// 跳转
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "用户名或密码错误！");
			request.setAttribute("login_name", name);
			request.setAttribute("login_password", password);
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
	}

	// 部门查询-------------------------------------------
	protected void admin_Q_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 1、获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_dep(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Department> departmentList = service.admin_Q_dep(page, search);
		// 2、保存--跳转
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_dep.jsp").forward(request, response);
	}

	// 职位查询-------------------------------------------
	protected void admin_Q_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_pos(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Positions> positionsList = service.admin_Q_pos(page, search);
		// 2、保存--跳转
		request.setAttribute("positionsList", positionsList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_pos.jsp").forward(request, response);
	}

	// 公告查询-------------------------------------------
	protected void admin_Q_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_not(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Notice> noticeList = service.admin_Q_not(page, search);
		// 2、保存--跳转
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_not.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 管理员查询-------------------------------------------
	protected void admin_Q_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_adm(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Admin> adminList = service.admin_Q_adm(page, search);
		// 2、保存--跳转
		request.setAttribute("adminList", adminList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_adm.jsp").forward(request, response);
	}

	// 员工查询-------------------------------------------
	protected void admin_Q_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_sta(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Staff> adm_staffList = service.admin_Q_sta(page, search);
		// 2、保存--跳转
		request.setAttribute("adm_staffList", adm_staffList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_sta.jsp").forward(request, response);
	}

	// 文件查询下载-------------------------------------------
	protected void admin_QD_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_file(search));
		// 调用查询方法获取结果[模糊+分页]
		List<File> fileList = service.admin_QD_file(page, search);
		// 2、保存--跳转
		request.setAttribute("fileList", fileList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_QD_file.jsp").forward(request, response);
	}

	// 文件下载
	protected void admin_Do_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取文件名
		String filename = request.getParameter("name");// 获取文件名
		// --设置响应头
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		// --构建文件输出路径、获取输入流
		String path = "D:\\yueqian\\作业\\第二阶段项目\\file\\" + filename;
		// 获取流，封装为缓冲流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		// 从响应对象中构建输出流
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[8192];
		int len = 0;
		// 3、io流的操作
		while ((len = bis.read(buff)) != -1) {
			// 写出
			bos.write(buff, 0, len);
			// 刷新
			bos.flush();
		}
		// 最后关闭流
		bis.close();
		bos.close();
	}

	// 修改删除管理员-------------------------------------------
	protected void admin_UD_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_adm(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Admin> adminList = service.admin_Q_adm(page, search);
		// 2、保存--跳转
		request.setAttribute("adminList", adminList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_adm.jsp").forward(request, response);
	}

	// 根据id删除管理员
	protected void admin_D_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取管理员id
		String str_id = request.getParameter("id");// 获取文件id
		// 转换
		int adm_id = Integer.parseInt(str_id);
		// 数据库操作
		boolean result = service.admin_D_adm(adm_id);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("admin_UD_adm").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "删除失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_UD_adm").forward(request, response);
		}
	}

	// 根据id查询修改管理员-------------------------------------------
	protected void admin_QU_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取key-value
		String str_id = request.getParameter("id");
		// 转换
		int adm_id = Integer.parseInt(str_id);
		// 数据库操作
		Admin admin = service.admin_QU_adm(adm_id);
		// 2、判断--校验结果
		if (admin != null) {// 登录成功
			// 登录成功将数据保存在session
			request.getSession().setAttribute("now_admin", admin);
			// 跳转
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "查询失败！");
			// 跳转回到查询页面
			request.getRequestDispatcher("admin_UD_adm.jsp").forward(request, response);
		}
	}

	// 添加管理员-------------------------------------------
	protected void admin_A_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String A_role = request.getParameter("role");
		// 数据保留
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("A_role", A_role);
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 封装数据
		Admin admin = new Admin(name, password, sdf.format(date), role);
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "用户名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
			// 结束
			return;
		}
		// 用户密码不为空的逻辑判断
		if (password == null || password.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("pas_message", "用户密码不能为空");
			// 跳转回到注册页面
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
			// 结束
			return;
		}
		// 文件上传的操作
		String image = upLoad(request);
		admin.setHead(image);
		// 数据库操作
		boolean result = service.adm_A_adm(admin);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "添加成功！");
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "添加失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
		}
	}

	// 修改管理员信息文件上传的处理方法
	protected String upLoad(HttpServletRequest request) throws ServletException, IOException {
		// 1、设置请求的字符集编码为UTF-8
		// 2、获取文件区域，通过request的getPart方法来进行获取
		Part part = request.getPart("filePart");
		if (part == null) {
			return null;
		}
		// 3、获取头部信息，通过头部信息字符串的截取来获取fileName
		String disposition = part.getHeader("Content-Disposition");
		// System.out.println(disposition);
		// --截取字符串将文件名提取出来
		String fileName = disposition.substring(disposition.indexOf("filename=\"") + 10, disposition.lastIndexOf("\""));
		// System.out.println(fileName);
		// 判断不为空
		if (fileName.equals("")) {
			return null;
		}
		// 4、定义一个文件路径用于存放文件
		String path = "D:\\yueqian\\作业\\第二阶段项目\\file";
		// 5、获取来自网络端上传的文件，以流的形式来获取 ：输入流 创建输出流
		BufferedInputStream bis = new BufferedInputStream(part.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "\\" + fileName));
		// 6、定义字节缓冲数据，用于缓冲输入流的数据
		byte[] buff = new byte[8 * 1024];
		// 7、定义一个int变量，用于存放单次读取数据的字节个数
		int len = 0;
		// 8、循环读写操作
		while ((len = bis.read(buff)) != -1) {// 读取
			// 写出数据
			bos.write(buff, 0, len);
			// 刷新
			bos.flush();
		}
		// 9、关闭流、返回name
		bis.close();
		bos.close();
		return fileName;
	}

	// 修改管理员信息-------------------------------------------
	protected void admin_U_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String name = request.getParameter("U_name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		// 保留数据
		request.setAttribute("str_id", str_id);
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("role", role);
		// 编号不能为空的逻辑判断
		if (str_id == null || str_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
			// 结束
			return;
		}
		int old_id = Integer.parseInt(o_id);
		int id = Integer.parseInt(str_id);
		// 封装数据
		Admin admin = new Admin(id, name, password, role, old_id);
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "用户名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
			// 结束
			return;
		}
		// 用户密码不为空的逻辑判断
		if (password == null || password.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("pas_message", "用户密码不能为空");
			// 跳转回到注册页面
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
			// 结束
			return;
		}
		// 文件上传的操作
		String image = upLoad(request);
		admin.setHead(image);
		// 数据库操作
		boolean result = service.adm_update(admin);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "修改成功");
			request.getRequestDispatcher("admin_QU_adm").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "该编号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
		}
	}

	// 修改删除部门-------------------------------------------
	protected void admin_UD_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_dep(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Department> depList = service.admin_Q_dep(page, search);
		// 2、保存--跳转
		request.setAttribute("depList", depList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_dep.jsp").forward(request, response);
	}

	// 根据id删除部门
	protected void admin_D_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取管理员id
		String str_id = request.getParameter("id");// 获取文件id
		// 转换
		int dep_id = Integer.parseInt(str_id);
		// 数据库操作
		boolean result = service.admin_D_dep(dep_id);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("admin_UD_dep").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "删除失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_UD_dep").forward(request, response);
		}
	}

	// 根据id查询修改部门-------------------------------------------
	protected void admin_QU_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取key-value
		String str_id = request.getParameter("id");
		// 转换
		int dep_id = Integer.parseInt(str_id);
		// 数据库操作
		Department department = service.admin_QU_dep(dep_id);
		// 2、判断--校验结果
		if (department != null) {// 登录成功
			// 登录成功将数据保存在session
			request.getSession().setAttribute("department", department);
			// 跳转
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "查询失败！");
			// 跳转回到查询页面
			request.getRequestDispatcher("admin_UD_dep.jsp").forward(request, response);
		}
	}

	// 修改部门信息-------------------------------------------
	protected void admin_U_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		// 部门编号不能为空的逻辑判断
		if (str_id == null || str_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "部门编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
			// 结束
			return;
		}
		int old_id = Integer.parseInt(o_id);
		int id = Integer.parseInt(str_id);
		// 封装数据
		Department department = new Department(id, name, describer, old_id);
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "部门名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
			// 结束
			return;
		}
		// 数据库操作
		boolean result = service.dep_update(department);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "修改成功");
			request.getRequestDispatcher("admin_QU_dep").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "该编号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
		}
	}

	// 添加部门-------------------------------------------
	protected void admin_A_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		// 数据保留
		request.setAttribute("name", name);
		request.setAttribute("describer", describer);
		// 封装数据
		Department department = new Department(name, describer);
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "部门名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_dep.jsp").forward(request, response);
			// 结束
			return;
		}
		// 数据库操作
		boolean result = service.adm_A_dep(department);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "添加成功！");
			request.getRequestDispatcher("admin_A_dep.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "添加失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_dep.jsp").forward(request, response);
		}
	}

	// 修改删除职位-------------------------------------------
	protected void admin_UD_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_pos(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Positions> posList = service.admin_Q_pos(page, search);
		// 2、保存--跳转
		request.setAttribute("posList", posList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_pos.jsp").forward(request, response);
	}

	// 根据id删除职位
	protected void admin_D_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取管理员id
		String str_id = request.getParameter("id");// 获取文件id
		// 转换
		int pos_id = Integer.parseInt(str_id);
		// 数据库操作
		boolean result = service.admin_D_pos(pos_id);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("admin_UD_pos").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "删除失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_UD_pos").forward(request, response);
		}
	}

	// 根据id查询修改职位-------------------------------------------
	protected void admin_QU_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取key-value
		String str_id = request.getParameter("id");
		// 转换
		int pos_id = Integer.parseInt(str_id);
		// 数据库操作
		Positions positions = service.admin_QU_pos(pos_id);
		// 2、判断--校验结果
		if (positions != null) {// 登录成功
			// 登录成功将数据保存在session
			request.getSession().setAttribute("positions", positions);
			// 跳转
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "查询失败！");
			// 跳转回到查询页面
			request.getRequestDispatcher("admin_UD_pos.jsp").forward(request, response);
		}
	}

	// 修改职位信息-------------------------------------------
	protected void admin_U_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		String d_id = request.getParameter("dep_id");
		// 用户名不能为空的逻辑判断
		if (d_id == null || d_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("dep_message", "所属部门编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
			// 结束
			return;
		}
		// 用户名不能为空的逻辑判断
		if (str_id == null || str_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
			// 结束
			return;
		}
		int id = Integer.parseInt(str_id);
		int old_id = Integer.parseInt(o_id);
		int dep_id = Integer.parseInt(d_id);
		// 封装数据
		Positions positions = new Positions(id, name, dep_id, describer, old_id);
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "职位名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
			// 结束
			return;
		}
		// 数据库操作
		boolean result = service.pos_update(positions);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "修改成功");
			request.getRequestDispatcher("admin_QU_pos").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "该编号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
		}
	}

	// 添加职位-------------------------------------------
	protected void admin_A_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		request.setAttribute("name", name);
		request.setAttribute("describer", describer);
		String str_id = request.getParameter("department_id");
		// 部门编号不能为空的逻辑判断
		if (str_id == null || str_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("dep_message", "部门编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
			// 结束
			return;
		}
		int department_id = Integer.parseInt(str_id);
		request.setAttribute("department_id", department_id);

		// 封装数据
		Positions positions = new Positions(name, department_id, describer);
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "职位名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
			// 结束
			return;
		}

		// 数据库操作
		boolean result = service.adm_A_pos(positions);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "添加成功！");
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "添加失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
		}
	}

	// 修改删除公告-------------------------------------------
	protected void admin_UD_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_not(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Notice> noticeList = service.admin_Q_not(page, search);
		// 2、保存--跳转
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_not.jsp").forward(request, response);
	}

	// 根据id删除公告
	protected void admin_D_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取管理员id
		String str_id = request.getParameter("id");// 获取文件id
		// 转换
		int not_id = Integer.parseInt(str_id);
		// 数据库操作
		boolean result = service.admin_D_not(not_id);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("admin_UD_not").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "删除失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_UD_not").forward(request, response);
		}
	}

	// 根据id查询修改公告-------------------------------------------
	protected void admin_QU_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取key-value
		String str_id = request.getParameter("id");
		// 转换
		int not_id = Integer.parseInt(str_id);
		// 数据库操作
		Notice notice = service.admin_QU_not(not_id);
		// 2、判断--校验结果
		if (notice != null) {// 登录成功
			// 登录成功将数据保存在session
			request.getSession().setAttribute("notice", notice);
			// 跳转
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "查询失败！");
			// 跳转回到查询页面
			request.getRequestDispatcher("admin_UD_not.jsp").forward(request, response);
		}
	}

	// 修改公告信息-------------------------------------------
	protected void admin_U_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String a_id = request.getParameter("admin_id");
		// 用户名不能为空的逻辑判断
		if (a_id == null || a_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("a_message", "发布人编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
			// 结束
			return;
		}
		// 用户名不能为空的逻辑判断
		if (str_id == null || str_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
			// 结束
			return;
		}
		int id = Integer.parseInt(str_id);
		int old_id = Integer.parseInt(o_id);
		int admin_id = Integer.parseInt(a_id);
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 封装数据
		Notice notice = new Notice(id, title, content, admin_id, sdf.format(date), old_id);
		// 用户名不能为空的逻辑判断
		if (title == null || title.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "标题不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
			// 结束
			return;
		}
		// 数据库操作
		boolean result = service.not_update(notice);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "修改成功");
			request.getRequestDispatcher("admin_QU_not").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "该编号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
		}
	}

	// 添加公告-------------------------------------------
	protected void admin_A_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String str_id = request.getParameter("admin_id");
		// 数据保留
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("str_id", str_id);
		// 用户名不能为空的逻辑判断
		if (str_id == null || str_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("str_message", "发布人编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
			// 结束
			return;
		}
		int admin_id = Integer.parseInt(str_id);
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 封装数据
		Notice notice = new Notice(title, content, admin_id, sdf.format(date));
		// 用户名不能为空的逻辑判断
		if (title == null || title.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("title_message", "标题不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
			// 结束
			return;
		}
		// 数据库操作
		boolean result = service.adm_A_not(notice);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "发布成功");
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "添加失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
		}
	}

	// 修改删除员工-------------------------------------------
	protected void admin_UD_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_sta(search));
		// 调用查询方法获取结果[模糊+分页]
		List<Staff> staffList = service.admin_Q_sta(page, search);
		// 2、保存--跳转
		request.setAttribute("staffList", staffList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_sta.jsp").forward(request, response);
	}

	// 根据id删除员工
	protected void admin_D_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取管理员id
		String str_id = request.getParameter("id");// 获取文件id
		// 转换
		int sta_id = Integer.parseInt(str_id);
		// 数据库操作
		boolean result = service.admin_D_sta(sta_id);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("admin_UD_sta").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "删除失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_UD_sta").forward(request, response);
		}
	}

	// 根据id查询修改员工-------------------------------------------
	protected void admin_QU_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取key-value
		String str_id = request.getParameter("id");
		// 转换
		int sta_id = Integer.parseInt(str_id);
		// 数据库操作
		Staff staff = service.admin_QU_sta(sta_id);
		// 2、判断--校验结果
		if (staff != null) {// 登录成功
			// 调用查询部门方法
			List<String> depname = admin_UQ_sta(request, response);
			// 登录成功将数据保存在session
			request.setAttribute("depname", depname);
			request.getSession().setAttribute("staff", staff);
			// 跳转
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "查询失败！");
			// 跳转回到查询页面
			request.getRequestDispatcher("admin_UD_sta.jsp").forward(request, response);
		}
	}

	// 修改员工查询部门-------------------------------------------
	protected List<String> admin_UQ_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用查询方法获取结果[模糊+分页]
		List<String> depname = service.admin_AQ_sta();
		return depname;
	}

	// 修改员工查询部门-------------------------------------------
	protected void admin_UQu_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用查询方法获取结果[模糊+分页]
		List<String> depname = service.admin_AQ_sta();
		request.setAttribute("depname", depname);
		request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
	}

	// 修改员工信息-------------------------------------------
	protected void admin_U_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String card = request.getParameter("card");
		String sex = request.getParameter("sex");
		/*
		 * String pos_id = request.getParameter("position_id"); String dep_id =
		 * request.getParameter("department_id");
		 */
		String depname = request.getParameter("depname");
		String DeptJob = request.getParameter("DeptJob");
		String phone = request.getParameter("phone");
		// id不能为空的逻辑判断
		if (str_id == null || str_id.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "编号不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 职位id不能为空的逻辑判断
		if (DeptJob == null || DeptJob.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("pos_message", "职位不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_UQu_sta").forward(request, response);
			// 结束
			return;
		}
		// 部门id不能为空的逻辑判断
		if (depname == null || depname.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("dep_message", "部门不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		int id = Integer.parseInt(str_id);
		/*
		 * int position_id = Integer.parseInt(pos_id); int department_id =
		 * Integer.parseInt(dep_id);
		 */
		int old_id = Integer.parseInt(o_id);
		// 根据职位名查职位id
		int position_id = service.querypos_id(DeptJob);
		// 封装数据
		Staff staff = new Staff(id, name, password, card, sex, position_id, depart_id, phone, old_id);
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "用户名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 密码不能为空的逻辑判断
		if (password == null || password.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("pas_message", "用户密码不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// 结束
			return;
		} // 身份证查重
		int Q_card = service.UQ_card(card, old_id);
		if (Q_card > 0) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("card_message", "该身份证已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 手机查重
		int Q_phone = service.UQ_phone(phone, old_id);
		if (Q_phone > 0) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("phone_message", "该手机号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 文件上传的操作
		String image = upLoad(request);
		staff.setHead(image);
		// 数据库操作
		boolean result = service.sta_update(staff);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "修改成功");
			request.getRequestDispatcher("admin_QU_sta").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("id_message", "该编号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
		}
	}

	// 添加员工查询部门-------------------------------------------
	protected void admin_AQ_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用查询方法获取结果[模糊+分页]
		List<String> depname = service.admin_AQ_sta();
		// 2、保存--跳转
		request.setAttribute("depname", depname);
		request.getRequestDispatcher("admin_A_sta.jsp").forward(request, response);
	}

	// 根据部门名查询该部门的所有职位
	protected void FindDeptJob(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取关键字(部门名称)
		String depname = request.getParameter("depname");
		// 根据部门名查部门id
		depart_id = service.querydep_id(depname);
		// 根据部门id查下属的职位
		List<String> jobs = service.querypos_name(depart_id);
		// 响应
		if (jobs != null && !jobs.isEmpty()) {
			// 4.创建响应的对象
			ResultData result = new ResultData(true);
			result.getDatas().put("jobs", jobs);
			// 5.将对象转换为json字符串
			Gson gson = new Gson();
			String json = gson.toJson(result);
			// 6.写出json信息
			response.getWriter().append(json);
		} else {
			// 7.创建响应的对象
			ResultData result = new ResultData(false);
			result.getDatas().put("message", "目前该部门没有职位");
			// 8.将对象转换为json字符串
			Gson gson = new Gson();
			String json = gson.toJson(result);
			// 9.写出json信息
			response.getWriter().print(json);
		}
	}

	// 添加员工-------------------------------------------
	protected void admin_A_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String card = request.getParameter("card");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		/*
		 * String pos_id = request.getParameter("position_id"); String dep_id =
		 * request.getParameter("department_id");
		 */
		String depname = request.getParameter("depname");
		String DeptJob = request.getParameter("DeptJob");
		// 数据保留
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("card", card);
		request.setAttribute("sex", sex);
		request.setAttribute("phone", phone);
		/*
		 * request.setAttribute("pos_id", pos_id); request.setAttribute("dep_id",
		 * dep_id);
		 */
		request.setAttribute("depname", depname);
		request.setAttribute("DeptJob", DeptJob);
		// 部门不能为空的逻辑判断
		if (depname == null || depname.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("dep_message", "部门不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// 结束
			return;
		}
		/*
		 * // 职位不能为空的逻辑判断 if (DeptJob == null || DeptJob.equals("")) { //
		 * 将错误信息保存在容器中【属性作用域】 request.setAttribute("pos_message", "职位不能为空"); // 跳转回到修改页面
		 * request.getRequestDispatcher("admin_AQ_sta").forward(request, response); //
		 * 结束 return; }
		 */
		/*
		 * int position_id = Integer.parseInt(pos_id); int department_id =
		 * Integer.parseInt(dep_id);
		 */
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 根据职位名查职位id
		int position_id = service.querypos_id(DeptJob);
		// 封装数据
		Staff staff = new Staff(name, password, card, sex, position_id, depart_id, phone, sdf.format(date));
		// 身份证查重
		int Q_card = service.Q_card(card);
		if (Q_card > 0) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("card_message", "该身份证已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// 结束
			return;
		}
		// 手机查重
		int Q_phone = service.Q_phone(phone);
		if (Q_phone > 0) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("phone_message", "该手机号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// 结束
			return;
		}
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "用户名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// 结束
			return;
		}
		// 用户密码不为空的逻辑判断
		if (password == null || password.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("pas_message", "用户密码不能为空");
			// 跳转回到注册页面
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// 结束
			return;
		}
		// 文件上传的操作
		String image = upLoad(request);
		staff.setHead(image);
		// 数据库操作
		boolean result = service.adm_A_sta(staff);
		// 4、响应
		if (result) {
			request.removeAttribute("name");
			request.removeAttribute("password");
			request.removeAttribute("card");
			request.removeAttribute("sex");
			request.removeAttribute("phone");
			request.removeAttribute("depname");
			request.removeAttribute("DeptJob");
			request.setAttribute("suc_message", "添加成功");
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "添加失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
		}
	}

	// 删除文件-------------------------------------------
	protected void admin_D_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页页码
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 获取关键字
		String search = request.getParameter("name");
		// 构建分页模型对象
		PageModel page = new PageModel(no, service.queryAllCount_file(search));
		// 调用查询方法获取结果[模糊+分页]
		List<File> file_D_List = service.admin_QD_file(page, search);
		// 2、保存--跳转
		request.setAttribute("file_D_List", file_D_List);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_D_file.jsp").forward(request, response);
	}

	// 根据id删除文件
	protected void admin_De_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取管理员id
		String str_id = request.getParameter("id");// 获取文件id
		// 转换
		int file_id = Integer.parseInt(str_id);
		// 数据库操作
		boolean result = service.admin_De_file(file_id);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("admin_D_file").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "删除失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_D_file").forward(request, response);
		}
	}

	// 上传文件
	protected void admin_Up_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String str_id = request.getParameter("upload_id");
		// 转换
		int upload_id = Integer.parseInt(str_id);
		String title = request.getParameter("title");
		String identity = request.getParameter("identity");
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 封装对象
		File adm_file = new File(title, upload_id, sdf.format(date), identity);
		// 文件上传的操作
		String name = upLoad(request);
		if (name == null || name.equals("")) {
			request.setAttribute("file_message", "请选择文件！");
			request.getRequestDispatcher("admin_Up_file.jsp").forward(request, response);
			return;
		}
		adm_file.setName(name);
		// 数据库操作
		boolean result = service.admin_Up_file(adm_file);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("admin_Up_file.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "上传失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("admin_Up_file.jsp").forward(request, response);
		}
	}

}
