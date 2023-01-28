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
	// ��ȡҵ���Ķ��󣬵���ҵ���������
	private static StaffService service = new StaffServiceImpl();

	// ��������
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

	// ��¼-------------------------------------------
	protected void StaffLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1����ȡkey-value
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Staff loginStaff = service.queryByAccess(name, password);
		// 2���ж�--У����
		if (loginStaff != null) {// ��¼�ɹ�
			now_id = loginStaff.getId();
			// ��¼�ɹ������ݱ�����session
			request.getSession().setAttribute("now_login", loginStaff);
			// Ա�����
			request.getSession().setAttribute("roles", "staff");
			// ��ת
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "�û������������");
			request.setAttribute("login_name", name);
			request.setAttribute("login_password", password);
			request.getRequestDispatcher("staff_login.jsp").forward(request, response);
		}
	}

	// ���Ų�ѯ-------------------------------------------
	protected void staff_Q_dep(HttpServletRequest request, HttpServletResponse response)
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
		List<Department> departmentList = service.staff_Q_dep(page, search);
		// 2������--��ת
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_dep.jsp").forward(request, response);
	}

	// ְλ��ѯ-------------------------------------------
	protected void staff_Q_pos(HttpServletRequest request, HttpServletResponse response)
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
		List<Positions> positionsList = service.staff_Q_pos(page, search);
		// 2������--��ת
		request.setAttribute("positionsList", positionsList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_pos.jsp").forward(request, response);
	}

	// �����ѯ-------------------------------------------
	protected void staff_Q_not(HttpServletRequest request, HttpServletResponse response)
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
		List<Notice> noticeList = service.staff_Q_not(page, search);
		// 2������--��ת
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_not.jsp").forward(request, response);
	}

	// Ա����ѯ-------------------------------------------
	protected void staff_Q_sta(HttpServletRequest request, HttpServletResponse response)
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
		List<Staff> staffList = service.staff_Q_sta(page, search);
		// 2������--��ת
		request.setAttribute("staffList", staffList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_Q_sta.jsp").forward(request, response);
	}

	// �޸ĸ�����Ϣ-------------------------------------------
	protected void staff_U_sta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String card = request.getParameter("card");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		// ��װ����
		Staff sta_ud = new Staff(now_id, name, password, card, phone, sex);
		// ���֤����
		int Q_card = service.Q_card(card, now_id);
		if (Q_card > 0) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("card_message", "�����֤�Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// �ֻ�����
		int Q_phone = service.Q_phone(phone, now_id);
		if (Q_phone > 0) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("phone_message", "���ֻ����Ѵ��ڣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// �û�������Ϊ�յ��߼��ж�
		if (name == null || name.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("name_message", "�û�������Ϊ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// �û����벻Ϊ�յ��߼��ж�
		if (password == null || password.equals("")) {
			// ��������Ϣ�����������С�����������
			request.setAttribute("pas_message", "�û����벻��Ϊ��");
			// ��ת�ص�ע��ҳ��
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
			// ����
			return;
		}
		// �ļ��ϴ��Ĳ���
		String image = upLoad(request);
		sta_ud.setHead(image);
		// ���ݿ����
		boolean result = service.sta_update(sta_ud);
		// 4����Ӧ
		if (result) {
			// ���²�ѯ
			request.setAttribute("suc_message", "�޸ĳɹ���");
			Staff now_Staff = service.querynow(now_id);
			request.getSession().setAttribute("now_login", now_Staff);
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "�޸�ʧ��");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_U_sta.jsp").forward(request, response);
		}
	}

	// �޸ĸ�����Ϣ�ļ��ϴ��Ĵ�����
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

	// �ϴ��ļ�
	protected void staff_Up_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String title = request.getParameter("title");
		// ��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sta = "sta";
		// ��װ����
		File sta_file = new File(title, now_id, sdf.format(date), sta);
		// �ļ��ϴ��Ĳ���
		String name = upLoad(request);
		if (name == null || name.equals("")) {
			request.setAttribute("file_message", "��ѡ���ļ���");
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
			return;
		}
		if (title == null || title.equals("")) {
			request.setAttribute("file_message", "��������⣡");
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
			return;
		}
		sta_file.setName(name);
		// ���ݿ����
		boolean result = service.staff_Up_sta(sta_file);
		// 4����Ӧ
		if (result) {
			request.setAttribute("suc_message", "�ϴ��ɹ���");
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "�ϴ�ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_Up_file.jsp").forward(request, response);
		}
	}

	// �ļ���ѯ����-------------------------------------------
	protected void staff_QD_file(HttpServletRequest request, HttpServletResponse response)
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
		List<File> fileList = service.staff_QD_file(page, search);
		// 2������--��ת
		request.setAttribute("fileList", fileList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_QD_file.jsp").forward(request, response);
	}

	// �ļ�����
	protected void staff_Do_file(HttpServletRequest request, HttpServletResponse response)
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

	// ɾ�������ļ�-------------------------------------------
	protected void staff_D_file(HttpServletRequest request, HttpServletResponse response)
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
		PageModel page = new PageModel(no, service.queryAllCount_personalfile(search, now_id));
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<File> personalfileList = service.staff_D_file(page, search, now_id);
		// 2������--��ת
		request.setAttribute("personalfileList", personalfileList);
		request.setAttribute("pageInfo", page);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_D_file.jsp").forward(request, response);
	}

	// ����idɾ�������ļ�
	protected void staff_De_file(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --��ȡ�ļ�id
		String str_id = request.getParameter("id");// ��ȡ�ļ�id
		// ת��
		int file_id = Integer.parseInt(str_id);
		// ���ݿ����
		boolean result = service.staff_De_file(file_id);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("staff_D_file").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "�ϴ�ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_D_file").forward(request, response);
		}
	}

	// ��ѯ����-------------------------------------------
	protected void staff_Q_alls(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�ؼ���
		String search = request.getParameter("search");
		// ���ò�ѯ������ȡ���[ģ��+��ҳ]
		List<Staff> staffList = service.staff_Q_alls(search);
		List idList = service.staff_Q_new(now_id);
		// 2������--��ת
		request.getSession().setAttribute("idList", idList);
		request.getSession().setAttribute("staffList", staffList);
		request.getSession().setAttribute("name", search);
		request.getRequestDispatcher("staff_empty.jsp").forward(request, response);
	}

	// ����id��ѯ��Ϣ-------------------------------------------
	protected void staff_Q_mes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�ؼ���
		String str_id = request.getParameter("r_id");
		String search = request.getParameter("search");
		// ת��
		r_id = Integer.parseInt(str_id);
		// ����Ϣ
		Staff staff = service.r_name(r_id);
		// ������
		String r_name = staff.getName();
		// �����Ѷ�
		boolean result = service.staff_Se_red(r_id, now_id);
		List<Message> messageList = service.staff_Q_mes(now_id, r_id);
		List<Staff> staffList = service.staff_Q_alls(search);
		// 2������--��ת
		request.setAttribute("r_name", r_name);
		request.setAttribute("messageList", messageList);
		request.setAttribute("r_id", r_id);
		request.setAttribute("now_id", now_id);
		request.setAttribute("staffList", staffList);
		request.setAttribute("name", search);
		request.getRequestDispatcher("staff_mes.jsp").forward(request, response);
	}

	// ������Ϣ-------------------------------------------
	protected void staff_S_mes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String content = request.getParameter("content");
		// ��ȡ��ǰʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ��װ����
		Message message = new Message(now_id, content, r_id, sdf.format(date));
		// �û�������Ϊ�յ��߼��ж�
		if (content == null || content.equals("")) {
			// ��������Ϣ�����������С�����������
			request.getServletContext().setAttribute("non_message", "���ܷ��Ϳ���Ϣ");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_Q_message").forward(request, response);
			// ����
			return;
		}
		// ���ݿ����
		boolean result = service.staff_S_mes(message);
		// 4����Ӧ
		if (result) {
			request.getRequestDispatcher("staff_Q_message").forward(request, response);
		} else {
			// ��������Ϣ�����������С�����������
			request.setAttribute("message", "���ʧ�ܣ�");
			// ��ת�ص��޸�ҳ��
			request.getRequestDispatcher("staff_Q_message").forward(request, response);
		}
	}

	// ����id��ѯ��Ϣ-------------------------------------------
	protected void staff_Q_message(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����Ϣ
		Staff staff = service.r_name(r_id);
		// ������
		String r_name = staff.getName();
		List<Message> messageList = service.staff_Q_mes(now_id, r_id);
		// 2������--��ת
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
