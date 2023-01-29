package com.gec.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.gec.entity.Message;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.ResultData;
import com.gec.entity.Staff;
import com.gec.service.StaffService;
import com.gec.service.impl.StaffServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet(urlPatterns = { "/StaffLogin", "/staff_Q_dep", "/staff_Q_pos", "/staff_Q_not", "/staff_Q_sta",
		"/staff_U_sta", "/querynow", "/staff_Up_file", "/staff_QD_file", "/staff_Do_file", "/staff_D_file",
		"/staff_De_file", "/staff_Q_alls", "/staff_Q_mes", "/staff_S_mes", "/staff_Q_message" })
@MultipartConfig
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int now_id;
	int r_id;
	// 获取业务层的对象，调用业务操作方法
	private static StaffService service = new StaffServiceImpl();

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
		if (path.equals("/StaffLogin")) {
			StaffLogin(request, response);
		} else if (path.equals("/staff_Q_dep")) {
			staff_Q_dep(request, response);
		} else if (path.equals("/staff_Q_pos")) {
			staff_Q_pos(request, response);
		} else if (path.equals("/staff_Q_not")) {
			staff_Q_not(request, response);
		} else if (path.equals("/staff_Q_sta")) {
			staff_Q_sta(request, response);
		} else if (path.equals("/staff_U_sta")) {
			staff_U_sta(request, response);
		} else if (path.equals("/staff_Up_file")) {
			staff_Up_file(request, response);
		} else if (path.equals("/staff_QD_file")) {
			staff_QD_file(request, response);
		} else if (path.equals("/staff_Do_file")) {
			staff_Do_file(request, response);
		} else if (path.equals("/staff_D_file")) {
			staff_D_file(request, response);
		} else if (path.equals("/staff_De_file")) {
			staff_De_file(request, response);
		} else if (path.equals("/staff_Q_alls")) {
			staff_Q_alls(request, response);
		} else if (path.equals("/staff_Q_mes")) {
			staff_Q_mes(request, response);
		} else if (path.equals("/staff_S_mes")) {
			staff_S_mes(request, response);
		} else if (path.equals("/staff_Q_message")) {
			staff_Q_message(request, response);
		}
	}

	// 登录-------------------------------------------
	protected void StaffLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1、获取key-value
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Staff loginStaff = service.queryByAccess(name, password);
		// 2、判断--校验结果
		if (loginStaff != null) {// 登录成功
			now_id = loginStaff.getId();
			// 登录成功将数据保存在session
			request.getSession().setAttribute("now_login", loginStaff);
			// 员工身份
			request.getSession().setAttribute("roles", "staff");
			// 跳转
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "用户名或密码错误！");
			request.setAttribute("login_name", name);
			request.setAttribute("login_password", password);
			request.getRequestDispatcher("staff_login.jsp").forward(request, response);
		}
	}

	// 部门查询-------------------------------------------
	protected void staff_Q_dep(HttpServletRequest request, HttpServletResponse response)
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
		List<Department> departmentList = service.staff_Q_dep(page, search);
		// 2、保存--跳转
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_dep.jsp").forward(request, response);
	}

	// 职位查询-------------------------------------------
	protected void staff_Q_pos(HttpServletRequest request, HttpServletResponse response)
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
		List<Positions> positionsList = service.staff_Q_pos(page, search);
		// 2、保存--跳转
		request.setAttribute("positionsList", positionsList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_pos.jsp").forward(request, response);
	}

	// 公告查询-------------------------------------------
	protected void staff_Q_not(HttpServletRequest request, HttpServletResponse response)
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
		List<Notice> noticeList = service.staff_Q_not(page, search);
		// 2、保存--跳转
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_not.jsp").forward(request, response);
	}

	// 员工查询-------------------------------------------
	protected void staff_Q_sta(HttpServletRequest request, HttpServletResponse response)
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
		List<Staff> staffList = service.staff_Q_sta(page, search);
		// 2、保存--跳转
		request.setAttribute("staffList", staffList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_sta.jsp").forward(request, response);
	}

	// 修改个人信息-------------------------------------------
	protected void staff_U_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String card = request.getParameter("card");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		// 封装数据
		Staff sta_ud = new Staff(now_id, name, password, card, phone, sex);
		// 身份证查重
		int Q_card = service.Q_card(card, now_id);
		if (Q_card > 0) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("card_message", "该身份证已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 手机查重
		int Q_phone = service.Q_phone(phone, now_id);
		if (Q_phone > 0) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("phone_message", "该手机号已存在！");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 用户名不能为空的逻辑判断
		if (name == null || name.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("name_message", "用户名不能为空");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 用户密码不为空的逻辑判断
		if (password == null || password.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("pas_message", "用户密码不能为空");
			// 跳转回到注册页面
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// 结束
			return;
		}
		// 文件上传的操作
		String image = upLoad(request);
		sta_ud.setHead(image);
		// 数据库操作
		boolean result = service.sta_update(sta_ud);
		// 4、响应
		if (result) {
			// 重新查询
			request.setAttribute("suc_message", "修改成功！");
			Staff now_Staff = service.querynow(now_id);
			request.getSession().setAttribute("now_login", now_Staff);
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "修改失败");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
		}
	}

	// 修改个人信息文件上传的处理方法
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

	// 上传文件
	protected void staff_Up_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String title = request.getParameter("title");
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sta = "sta";
		// 封装对象
		File sta_file = new File(title, now_id, sdf.format(date), sta);
		// 文件上传的操作
		String name = upLoad(request);
		if (name == null || name.equals("")) {
			request.setAttribute("file_message", "请选择文件！");
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
			return;
		}
		if (title == null || title.equals("")) {
			request.setAttribute("file_message", "请输入标题！");
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
			return;
		}
		sta_file.setName(name);
		// 数据库操作
		boolean result = service.staff_Up_sta(sta_file);
		// 4、响应
		if (result) {
			request.setAttribute("suc_message", "上传成功！");
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "上传失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
		}
	}

	// 文件查询下载-------------------------------------------
	protected void staff_QD_file(HttpServletRequest request, HttpServletResponse response)
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
		List<File> fileList = service.staff_QD_file(page, search);
		// 2、保存--跳转
		request.setAttribute("fileList", fileList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_QD_file.jsp").forward(request, response);
	}

	// 文件下载
	protected void staff_Do_file(HttpServletRequest request, HttpServletResponse response)
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

	// 删除个人文件-------------------------------------------
	protected void staff_D_file(HttpServletRequest request, HttpServletResponse response)
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
		PageModel page = new PageModel(no, service.queryAllCount_personalfile(search, now_id));
		// 调用查询方法获取结果[模糊+分页]
		List<File> personalfileList = service.staff_D_file(page, search, now_id);
		// 2、保存--跳转
		request.setAttribute("personalfileList", personalfileList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_D_file.jsp").forward(request, response);
	}

	// 根据id删除具体文件
	protected void staff_De_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --获取文件id
		String str_id = request.getParameter("id");// 获取文件id
		// 转换
		int file_id = Integer.parseInt(str_id);
		// 数据库操作
		boolean result = service.staff_De_file(file_id);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("staff_D_file").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "上传失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_D_file").forward(request, response);
		}
	}

	// 查询所有-------------------------------------------
	protected void staff_Q_alls(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取关键字
		String search = request.getParameter("search");
		// 调用查询方法获取结果[模糊+分页]
		List<Staff> staffList = service.staff_Q_alls(search);
		List idList = service.staff_Q_new(now_id);
		// 2、保存--跳转
		request.getSession().setAttribute("idList", idList);
		request.getSession().setAttribute("staffList", staffList);
		request.getSession().setAttribute("name", search);
		request.getRequestDispatcher("staff_empty.jsp").forward(request, response);
	}

	// 根据id查询信息-------------------------------------------
	protected void staff_Q_mes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取关键字
		String str_id = request.getParameter("r_id");
		String search = request.getParameter("search");
		// 转换
		r_id = Integer.parseInt(str_id);
		// 查信息
		Staff staff = service.r_name(r_id);
		// 查名字
		String r_name = staff.getName();
		// 设置已读
		boolean result = service.staff_Se_red(r_id, now_id);
		List<Message> messageList = service.staff_Q_mes(now_id, r_id);
		List<Staff> staffList = service.staff_Q_alls(search);
		// 2、保存--跳转
		request.setAttribute("r_name", r_name);
		request.setAttribute("messageList", messageList);
		request.setAttribute("r_id", r_id);
		request.setAttribute("now_id", now_id);
		request.setAttribute("staffList", staffList);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_mes.jsp").forward(request, response);
	}

	// 发送信息-------------------------------------------
	protected void staff_S_mes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		String content = request.getParameter("content");
		// 获取当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 封装数据
		Message message = new Message(now_id, content, r_id, sdf.format(date));
		// 用户名不能为空的逻辑判断
		if (content == null || content.equals("")) {
			// 将错误信息保存在容器中【属性作用域】
			request.getServletContext().setAttribute("non_message", "不能发送空消息");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_Q_message").forward(request, response);
			// 结束
			return;
		}
		// 数据库操作
		boolean result = service.staff_S_mes(message);
		// 4、响应
		if (result) {
			request.getRequestDispatcher("staff_Q_message").forward(request, response);
		} else {
			// 将错误信息保存在容器中【属性作用域】
			request.setAttribute("message", "添加失败！");
			// 跳转回到修改页面
			request.getRequestDispatcher("staff_Q_message").forward(request, response);
		}
	}

	// 根据id查询信息-------------------------------------------
	protected void staff_Q_message(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 查信息
		Staff staff = service.r_name(r_id);
		// 查名字
		String r_name = staff.getName();
		List<Message> messageList = service.staff_Q_mes(now_id, r_id);
		// 2、保存--跳转
		request.setAttribute("r_name", r_name);
		request.setAttribute("messageList", messageList);
		request.setAttribute("r_id", r_id);
		request.setAttribute("now_id", now_id);
		request.getRequestDispatcher("staff_mes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
