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
	// ��ȡҵ���Ķ��󣬵���ҵ���������
	private static AdminService service = new AdminServiceImpl();

	// ����������
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������������ñ��뼯
		request.setCharacterEncoding("UTF-8");
		// ������Ӧ�����ͼ��ַ�������
		response.setContentType("text/json;charset=utf-8");
		// ��ȡ����path
		String path = request.getServletPath();
		System.out.println(path);
		// �ж�
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

	// ��¼-------------------------------------------
	protected void AdminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡkey-value
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin loginAdmin = service.queryByAccess(name, password);
		// 2���ж�--У����
		if (loginAdmin != null) {// ��¼�ɹ�
			now_id = loginAdmin.getId();
			// ��¼�ɹ������ݱ�����session
			request.getSession().setAttribute("now_login", loginAdmin);
			// ����Ա����
			request.getSession().setAttribute("roles", "admin");
			// ����/��ͨ
			request.getSession().setAttribute("role", loginAdmin.getRole());
			// ��ת
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "�û������������");
			request.setAttribute("login_name", name);
			request.setAttribute("login_password", password);
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}
	}

	// ���Ų�ѯ-------------------------------------------
	protected void admin_Q_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// 1����ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_dep(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Department> departmentList = service.admin_Q_dep(page, search);
		// 2������--��ת
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_dep.jsp").forward(request, response);
	}

	// ְλ��ѯ-------------------------------------------
	protected void admin_Q_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_pos(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Positions> positionsList = service.admin_Q_pos(page, search);
		// 2������--��ת
		request.setAttribute("positionsList", positionsList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_pos.jsp").forward(request, response);
	}

	// �����ѯ-------------------------------------------
	protected void admin_Q_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_not(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Notice> noticeList = service.admin_Q_not(page, search);
		// 2������--��ת
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_not.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// ����Ա��ѯ-------------------------------------------
	protected void admin_Q_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_adm(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Admin> adminList = service.admin_Q_adm(page, search);
		// 2������--��ת
		request.setAttribute("adminList", adminList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_adm.jsp").forward(request, response);
	}

	// Ա����ѯ-------------------------------------------
	protected void admin_Q_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_sta(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Staff> adm_staffList = service.admin_Q_sta(page, search);
		// 2������--��ת
		request.setAttribute("adm_staffList", adm_staffList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_Q_sta.jsp").forward(request, response);
	}

	// �ļ���ѯ����-------------------------------------------
	protected void admin_QD_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_file(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<File> fileList = service.admin_QD_file(page, search);
		// 2������--��ת
		request.setAttribute("fileList", fileList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_QD_file.jsp").forward(request, response);
	}

	// �ļ�����
	protected void admin_Do_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ�ļ���
		String filename = request.getParameter("name");// ��ȡ�ļ���
		// --������Ӧͷ
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		// --�����ļ����·������ȡ������
		String path = "D:\\yueqian\\��ҵ\\�ڶ��׶���Ŀ\\file\\" + filename;
		// ��ȡ������װΪ������
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		// ����Ӧ�����й��������
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[8192];
		int len = 0;
		// 3��io���Ĳ���
		while ((len = bis.read(buff)) != -1) {
			// д��
			bos.write(buff, 0, len);
			// ˢ��
			bos.flush();
		}
		// ���ر���
		bis.close();
		bos.close();
	}

	// �޸�ɾ������Ա-------------------------------------------
	protected void admin_UD_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_adm(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Admin> adminList = service.admin_Q_adm(page, search);
		// 2������--��ת
		request.setAttribute("adminList", adminList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_adm.jsp").forward(request, response);
	}

	// ����idɾ������Ա
	protected void admin_D_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ����Աid
		String str_id = request.getParameter("id");// ��ȡ�ļ�id
		// ת��
		int adm_id = Integer.parseInt(str_id);
		// ���ݿ����
		boolean result = service.admin_D_adm(adm_id);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("admin_UD_adm").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "ɾ��ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_UD_adm").forward(request, response);
		}
	}

	// ����id��ѯ�޸Ĺ���Ա-------------------------------------------
	protected void admin_QU_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡkey-value
		String str_id = request.getParameter("id");
		// ת��
		int adm_id = Integer.parseInt(str_id);
		// ���ݿ����
		Admin admin = service.admin_QU_adm(adm_id);
		// 2���ж�--У����
		if (admin != null) {// ��¼�ɹ�
			// ��¼�ɹ������ݱ�����session
			request.getSession().setAttribute("now_admin", admin);
			// ��ת
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "��ѯʧ�ܣ�");
			// ��ת�ص���ѯҳ��
			request.getRequestDispatcher("admin_UD_adm.jsp").forward(request, response);
		}
	}

	// ���ӹ���Ա-------------------------------------------
	protected void admin_A_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String A_role = request.getParameter("role");
		// ���ݱ���
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("A_role", A_role);
		// ��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��װ����
		Admin admin = new Admin(name, password, sdf.format(date), role);
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "�û�������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
			// ����
			return;
		}
		// �û����벻Ϊ�յ��߼��ж�
		if (password == null || password.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("pas_message", "�û����벻��Ϊ��");
			// ��ת�ص�ע��ҳ��
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
			// ����
			return;
		}
		// �ļ��ϴ��Ĳ���
		String image = upLoad(request);
		admin.setHead(image);
		// ���ݿ����
		boolean result = service.adm_A_adm(admin);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "���ӳɹ���");
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "����ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_adm.jsp").forward(request, response);
		}
	}

	// �޸Ĺ���Ա��Ϣ�ļ��ϴ��Ĵ�������
	protected String upLoad(HttpServletRequest request) throws ServletException, IOException {
		// 1������������ַ�������ΪUTF-8
		// 2����ȡ�ļ�����ͨ��request��getPart���������л�ȡ
		Part part = request.getPart("filePart");
		if (part == null) {
			return null;
		}
		// 3����ȡͷ����Ϣ��ͨ��ͷ����Ϣ�ַ����Ľ�ȡ����ȡfileName
		String disposition = part.getHeader("Content-Disposition");
		// System.out.println(disposition);
		// --��ȡ�ַ������ļ�����ȡ����
		String fileName = disposition.substring(disposition.indexOf("filename=\"") + 10, disposition.lastIndexOf("\""));
		// System.out.println(fileName);
		// �жϲ�Ϊ��
		if (fileName.equals("")) {
			return null;
		}
		// 4������һ���ļ�·�����ڴ���ļ�
		String path = "D:\\yueqian\\��ҵ\\�ڶ��׶���Ŀ\\file";
		// 5����ȡ����������ϴ����ļ�����������ʽ����ȡ �������� ���������
		BufferedInputStream bis = new BufferedInputStream(part.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "\\" + fileName));
		// 6�������ֽڻ������ݣ����ڻ���������������
		byte[] buff = new byte[8 * 1024];
		// 7������һ��int���������ڴ�ŵ��ζ�ȡ���ݵ��ֽڸ���
		int len = 0;
		// 8��ѭ����д����
		while ((len = bis.read(buff)) != -1) {// ��ȡ
			// д������
			bos.write(buff, 0, len);
			// ˢ��
			bos.flush();
		}
		// 9���ر���������name
		bis.close();
		bos.close();
		return fileName;
	}

	// �޸Ĺ���Ա��Ϣ-------------------------------------------
	protected void admin_U_adm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String name = request.getParameter("U_name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		// ��������
		request.setAttribute("str_id", str_id);
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.setAttribute("role", role);
		// ��Ų���Ϊ�յ��߼��ж�
		if (str_id == null || str_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
			// ����
			return;
		}
		int old_id = Integer.parseInt(o_id);
		int id = Integer.parseInt(str_id);
		// ��װ����
		Admin admin = new Admin(id, name, password, role, old_id);
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "�û�������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
			// ����
			return;
		}
		// �û����벻Ϊ�յ��߼��ж�
		if (password == null || password.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("pas_message", "�û����벻��Ϊ��");
			// ��ת�ص�ע��ҳ��
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
			// ����
			return;
		}
		// �ļ��ϴ��Ĳ���
		String image = upLoad(request);
		admin.setHead(image);
		// ���ݿ����
		boolean result = service.adm_update(admin);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "�޸ĳɹ�");
			request.getRequestDispatcher("admin_QU_adm").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "�ñ���Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_adm.jsp").forward(request, response);
		}
	}

	// �޸�ɾ������-------------------------------------------
	protected void admin_UD_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_dep(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Department> depList = service.admin_Q_dep(page, search);
		// 2������--��ת
		request.setAttribute("depList", depList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_dep.jsp").forward(request, response);
	}

	// ����idɾ������
	protected void admin_D_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ����Աid
		String str_id = request.getParameter("id");// ��ȡ�ļ�id
		// ת��
		int dep_id = Integer.parseInt(str_id);
		// ���ݿ����
		boolean result = service.admin_D_dep(dep_id);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("admin_UD_dep").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "ɾ��ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_UD_dep").forward(request, response);
		}
	}

	// ����id��ѯ�޸Ĳ���-------------------------------------------
	protected void admin_QU_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡkey-value
		String str_id = request.getParameter("id");
		// ת��
		int dep_id = Integer.parseInt(str_id);
		// ���ݿ����
		Department department = service.admin_QU_dep(dep_id);
		// 2���ж�--У����
		if (department != null) {// ��¼�ɹ�
			// ��¼�ɹ������ݱ�����session
			request.getSession().setAttribute("department", department);
			// ��ת
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��ѯʧ�ܣ�");
			// ��ת�ص���ѯҳ��
			request.getRequestDispatcher("admin_UD_dep.jsp").forward(request, response);
		}
	}

	// �޸Ĳ�����Ϣ-------------------------------------------
	protected void admin_U_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		// ���ű�Ų���Ϊ�յ��߼��ж�
		if (str_id == null || str_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "���ű�Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
			// ����
			return;
		}
		int old_id = Integer.parseInt(o_id);
		int id = Integer.parseInt(str_id);
		// ��װ����
		Department department = new Department(id, name, describer, old_id);
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "����������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
			// ����
			return;
		}
		// ���ݿ����
		boolean result = service.dep_update(department);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "�޸ĳɹ�");
			request.getRequestDispatcher("admin_QU_dep").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "�ñ���Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_dep.jsp").forward(request, response);
		}
	}

	// ���Ӳ���-------------------------------------------
	protected void admin_A_dep(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		// ���ݱ���
		request.setAttribute("name", name);
		request.setAttribute("describer", describer);
		// ��װ����
		Department department = new Department(name, describer);
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "����������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_dep.jsp").forward(request, response);
			// ����
			return;
		}
		// ���ݿ����
		boolean result = service.adm_A_dep(department);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "���ӳɹ���");
			request.getRequestDispatcher("admin_A_dep.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "����ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_dep.jsp").forward(request, response);
		}
	}

	// �޸�ɾ��ְλ-------------------------------------------
	protected void admin_UD_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_pos(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Positions> posList = service.admin_Q_pos(page, search);
		// 2������--��ת
		request.setAttribute("posList", posList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_pos.jsp").forward(request, response);
	}

	// ����idɾ��ְλ
	protected void admin_D_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ����Աid
		String str_id = request.getParameter("id");// ��ȡ�ļ�id
		// ת��
		int pos_id = Integer.parseInt(str_id);
		// ���ݿ����
		boolean result = service.admin_D_pos(pos_id);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("admin_UD_pos").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "ɾ��ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_UD_pos").forward(request, response);
		}
	}

	// ����id��ѯ�޸�ְλ-------------------------------------------
	protected void admin_QU_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡkey-value
		String str_id = request.getParameter("id");
		// ת��
		int pos_id = Integer.parseInt(str_id);
		// ���ݿ����
		Positions positions = service.admin_QU_pos(pos_id);
		// 2���ж�--У����
		if (positions != null) {// ��¼�ɹ�
			// ��¼�ɹ������ݱ�����session
			request.getSession().setAttribute("positions", positions);
			// ��ת
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��ѯʧ�ܣ�");
			// ��ת�ص���ѯҳ��
			request.getRequestDispatcher("admin_UD_pos.jsp").forward(request, response);
		}
	}

	// �޸�ְλ��Ϣ-------------------------------------------
	protected void admin_U_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		String d_id = request.getParameter("dep_id");
		// �û�������Ϊ�յ��߼��ж�
		if (d_id == null || d_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("dep_message", "�������ű�Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
			// ����
			return;
		}
		// �û�������Ϊ�յ��߼��ж�
		if (str_id == null || str_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
			// ����
			return;
		}
		int id = Integer.parseInt(str_id);
		int old_id = Integer.parseInt(o_id);
		int dep_id = Integer.parseInt(d_id);
		// ��װ����
		Positions positions = new Positions(id, name, dep_id, describer, old_id);
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "ְλ������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
			// ����
			return;
		}
		// ���ݿ����
		boolean result = service.pos_update(positions);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "�޸ĳɹ�");
			request.getRequestDispatcher("admin_QU_pos").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "�ñ���Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_pos.jsp").forward(request, response);
		}
	}

	// ����ְλ-------------------------------------------
	protected void admin_A_pos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String name = request.getParameter("name");
		String describer = request.getParameter("describer");
		request.setAttribute("name", name);
		request.setAttribute("describer", describer);
		String str_id = request.getParameter("department_id");
		// ���ű�Ų���Ϊ�յ��߼��ж�
		if (str_id == null || str_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("dep_message", "���ű�Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
			// ����
			return;
		}
		int department_id = Integer.parseInt(str_id);
		request.setAttribute("department_id", department_id);

		// ��װ����
		Positions positions = new Positions(name, department_id, describer);
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "ְλ������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
			// ����
			return;
		}

		// ���ݿ����
		boolean result = service.adm_A_pos(positions);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "���ӳɹ���");
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "����ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_pos.jsp").forward(request, response);
		}
	}

	// �޸�ɾ������-------------------------------------------
	protected void admin_UD_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_not(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Notice> noticeList = service.admin_Q_not(page, search);
		// 2������--��ת
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_not.jsp").forward(request, response);
	}

	// ����idɾ������
	protected void admin_D_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ����Աid
		String str_id = request.getParameter("id");// ��ȡ�ļ�id
		// ת��
		int not_id = Integer.parseInt(str_id);
		// ���ݿ����
		boolean result = service.admin_D_not(not_id);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("admin_UD_not").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "ɾ��ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_UD_not").forward(request, response);
		}
	}

	// ����id��ѯ�޸Ĺ���-------------------------------------------
	protected void admin_QU_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡkey-value
		String str_id = request.getParameter("id");
		// ת��
		int not_id = Integer.parseInt(str_id);
		// ���ݿ����
		Notice notice = service.admin_QU_not(not_id);
		// 2���ж�--У����
		if (notice != null) {// ��¼�ɹ�
			// ��¼�ɹ������ݱ�����session
			request.getSession().setAttribute("notice", notice);
			// ��ת
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��ѯʧ�ܣ�");
			// ��ת�ص���ѯҳ��
			request.getRequestDispatcher("admin_UD_not.jsp").forward(request, response);
		}
	}

	// �޸Ĺ�����Ϣ-------------------------------------------
	protected void admin_U_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String o_id = request.getParameter("old_id");
		String str_id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String a_id = request.getParameter("admin_id");
		// �û�������Ϊ�յ��߼��ж�
		if (a_id == null || a_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("a_message", "�����˱�Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
			// ����
			return;
		}
		// �û�������Ϊ�յ��߼��ж�
		if (str_id == null || str_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
			// ����
			return;
		}
		int id = Integer.parseInt(str_id);
		int old_id = Integer.parseInt(o_id);
		int admin_id = Integer.parseInt(a_id);
		// ��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��װ����
		Notice notice = new Notice(id, title, content, admin_id, sdf.format(date), old_id);
		// �û�������Ϊ�յ��߼��ж�
		if (title == null || title.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "���ⲻ��Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
			// ����
			return;
		}
		// ���ݿ����
		boolean result = service.not_update(notice);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "�޸ĳɹ�");
			request.getRequestDispatcher("admin_QU_not").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "�ñ���Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_not.jsp").forward(request, response);
		}
	}

	// ���ӹ���-------------------------------------------
	protected void admin_A_not(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String str_id = request.getParameter("admin_id");
		// ���ݱ���
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("str_id", str_id);
		// �û�������Ϊ�յ��߼��ж�
		if (str_id == null || str_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("str_message", "�����˱�Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
			// ����
			return;
		}
		int admin_id = Integer.parseInt(str_id);
		// ��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��װ����
		Notice notice = new Notice(title, content, admin_id, sdf.format(date));
		// �û�������Ϊ�յ��߼��ж�
		if (title == null || title.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("title_message", "���ⲻ��Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
			// ����
			return;
		}
		// ���ݿ����
		boolean result = service.adm_A_not(notice);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "�����ɹ�");
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "����ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_A_not.jsp").forward(request, response);
		}
	}

	// �޸�ɾ��Ա��-------------------------------------------
	protected void admin_UD_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_sta(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Staff> staffList = service.admin_Q_sta(page, search);
		// 2������--��ת
		request.setAttribute("staffList", staffList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_UD_sta.jsp").forward(request, response);
	}

	// ����idɾ��Ա��
	protected void admin_D_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ����Աid
		String str_id = request.getParameter("id");// ��ȡ�ļ�id
		// ת��
		int sta_id = Integer.parseInt(str_id);
		// ���ݿ����
		boolean result = service.admin_D_sta(sta_id);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("admin_UD_sta").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "ɾ��ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_UD_sta").forward(request, response);
		}
	}

	// ����id��ѯ�޸�Ա��-------------------------------------------
	protected void admin_QU_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡkey-value
		String str_id = request.getParameter("id");
		// ת��
		int sta_id = Integer.parseInt(str_id);
		// ���ݿ����
		Staff staff = service.admin_QU_sta(sta_id);
		// 2���ж�--У����
		if (staff != null) {// ��¼�ɹ�
			// ���ò�ѯ���ŷ���
			List<String> depname = admin_UQ_sta(request, response);
			// ��¼�ɹ������ݱ�����session
			request.setAttribute("depname", depname);
			request.getSession().setAttribute("staff", staff);
			// ��ת
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��ѯʧ�ܣ�");
			// ��ת�ص���ѯҳ��
			request.getRequestDispatcher("admin_UD_sta.jsp").forward(request, response);
		}
	}

	// �޸�Ա����ѯ����-------------------------------------------
	protected List<String> admin_UQ_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<String> depname = service.admin_AQ_sta();
		return depname;
	}

	// �޸�Ա����ѯ����-------------------------------------------
	protected void admin_UQu_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<String> depname = service.admin_AQ_sta();
		request.setAttribute("depname", depname);
		request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
	}

	// �޸�Ա����Ϣ-------------------------------------------
	protected void admin_U_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
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
		// id����Ϊ�յ��߼��ж�
		if (str_id == null || str_id.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "��Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// ְλid����Ϊ�յ��߼��ж�
		if (DeptJob == null || DeptJob.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("pos_message", "ְλ����Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_UQu_sta").forward(request, response);
			// ����
			return;
		}
		// ����id����Ϊ�յ��߼��ж�
		if (depname == null || depname.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("dep_message", "���Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		int id = Integer.parseInt(str_id);
		/*
		 * int position_id = Integer.parseInt(pos_id); int department_id =
		 * Integer.parseInt(dep_id);
		 */
		int old_id = Integer.parseInt(o_id);
		// ����ְλ����ְλid
		int position_id = service.querypos_id(DeptJob);
		// ��װ����
		Staff staff = new Staff(id, name, password, card, sex, position_id, depart_id, phone, old_id);
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "�û�������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// ���벻��Ϊ�յ��߼��ж�
		if (password == null || password.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("pas_message", "�û����벻��Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// ����
			return;
		} // ����֤����
		int Q_card = service.UQ_card(card, old_id);
		if (Q_card > 0) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("card_message", "������֤�Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// �ֻ�����
		int Q_phone = service.UQ_phone(phone, old_id);
		if (Q_phone > 0) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("phone_message", "���ֻ����Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// �ļ��ϴ��Ĳ���
		String image = upLoad(request);
		staff.setHead(image);
		// ���ݿ����
		boolean result = service.sta_update(staff);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "�޸ĳɹ�");
			request.getRequestDispatcher("admin_QU_sta").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("id_message", "�ñ���Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_U_sta.jsp").forward(request, response);
		}
	}

	// ����Ա����ѯ����-------------------------------------------
	protected void admin_AQ_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<String> depname = service.admin_AQ_sta();
		// 2������--��ת
		request.setAttribute("depname", depname);
		request.getRequestDispatcher("admin_A_sta.jsp").forward(request, response);
	}

	// ���ݲ�������ѯ�ò��ŵ�����ְλ
	protected void FindDeptJob(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�ؼ���(��������)
		String depname = request.getParameter("depname");
		// ���ݲ������鲿��id
		depart_id = service.querydep_id(depname);
		// ���ݲ���id��������ְλ
		List<String> jobs = service.querypos_name(depart_id);
		// ��Ӧ
		if (jobs != null && !jobs.isEmpty()) {
			// 4.������Ӧ�Ķ���
			ResultData result = new ResultData(true);
			result.getDatas().put("jobs", jobs);
			// 5.������ת��Ϊjson�ַ���
			Gson gson = new Gson();
			String json = gson.toJson(result);
			// 6.д��json��Ϣ
			response.getWriter().append(json);
		} else {
			// 7.������Ӧ�Ķ���
			ResultData result = new ResultData(false);
			result.getDatas().put("message", "Ŀǰ�ò���û��ְλ");
			// 8.������ת��Ϊjson�ַ���
			Gson gson = new Gson();
			String json = gson.toJson(result);
			// 9.д��json��Ϣ
			response.getWriter().print(json);
		}
	}

	// ����Ա��-------------------------------------------
	protected void admin_A_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
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
		// ���ݱ���
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
		// ���Ų���Ϊ�յ��߼��ж�
		if (depname == null || depname.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("dep_message", "���Ų���Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// ����
			return;
		}
		/*
		 * // ְλ����Ϊ�յ��߼��ж� if (DeptJob == null || DeptJob.equals("")) { //
		 * ��������Ϣ�����������С����������� request.setAttribute("pos_message", "ְλ����Ϊ��"); // ��ת�ص��޸�ҳ��
		 * request.getRequestDispatcher("admin_AQ_sta").forward(request, response); //
		 * ���� return; }
		 */
		/*
		 * int position_id = Integer.parseInt(pos_id); int department_id =
		 * Integer.parseInt(dep_id);
		 */
		// ��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����ְλ����ְλid
		int position_id = service.querypos_id(DeptJob);
		// ��װ����
		Staff staff = new Staff(name, password, card, sex, position_id, depart_id, phone, sdf.format(date));
		// ����֤����
		int Q_card = service.Q_card(card);
		if (Q_card > 0) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("card_message", "������֤�Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// ����
			return;
		}
		// �ֻ�����
		int Q_phone = service.Q_phone(phone);
		if (Q_phone > 0) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("phone_message", "���ֻ����Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// ����
			return;
		}
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "�û�������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// ����
			return;
		}
		// �û����벻Ϊ�յ��߼��ж�
		if (password == null || password.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("pas_message", "�û����벻��Ϊ��");
			// ��ת�ص�ע��ҳ��
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
			// ����
			return;
		}
		// �ļ��ϴ��Ĳ���
		String image = upLoad(request);
		staff.setHead(image);
		// ���ݿ����
		boolean result = service.adm_A_sta(staff);
		// 4����Ӧ
		if (result) {
			request.removeAttribute("name");
			request.removeAttribute("password");
			request.removeAttribute("card");
			request.removeAttribute("sex");
			request.removeAttribute("phone");
			request.removeAttribute("depname");
			request.removeAttribute("DeptJob");
			request.setAttribute("suc_message", "���ӳɹ�");
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "����ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_AQ_sta").forward(request, response);
		}
	}

	// ɾ���ļ�-------------------------------------------
	protected void admin_D_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳҳ��
		int no = 1;
		String pageNo = request.getParameter("pageNo");
		if (pageNo != null && !pageNo.equals("")) {
			no = Integer.parseInt(pageNo);
		}
		// ��ȡ�ؼ���
		String search = request.getParameter("name");
		// ������ҳģ�Ͷ���
		PageModel page = new PageModel(no, service.queryAllCount_file(search));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<File> file_D_List = service.admin_QD_file(page, search);
		// 2������--��ת
		request.setAttribute("file_D_List", file_D_List);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("admin_D_file.jsp").forward(request, response);
	}

	// ����idɾ���ļ�
	protected void admin_De_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ����Աid
		String str_id = request.getParameter("id");// ��ȡ�ļ�id
		// ת��
		int file_id = Integer.parseInt(str_id);
		// ���ݿ����
		boolean result = service.admin_De_file(file_id);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("admin_D_file").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "ɾ��ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_D_file").forward(request, response);
		}
	}

	// �ϴ��ļ�
	protected void admin_Up_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String str_id = request.getParameter("upload_id");
		// ת��
		int upload_id = Integer.parseInt(str_id);
		String title = request.getParameter("title");
		String identity = request.getParameter("identity");
		// ��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��װ����
		File adm_file = new File(title, upload_id, sdf.format(date), identity);
		// �ļ��ϴ��Ĳ���
		String name = upLoad(request);
		if (name == null || name.equals("")) {
			request.setAttribute("file_message", "��ѡ���ļ���");
			request.getRequestDispatcher("admin_Up_file.jsp").forward(request, response);
			return;
		}
		adm_file.setName(name);
		// ���ݿ����
		boolean result = service.admin_Up_file(adm_file);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("admin_Up_file.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "�ϴ�ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("admin_Up_file.jsp").forward(request, response);
		}
	}

}