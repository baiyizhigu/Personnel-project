package com.gec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gec.entity.Admin;
import com.gec.entity.Department;
import com.gec.entity.File;
import com.gec.entity.Message;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.Staff;
import com.gec.utils.DataSourceTool;

public class StaffDao {
	// ��¼
	public Staff queryByAccess(String staff_name, String staff_password) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select staff.id,staff.name,staff.password,staff.card,staff.sex,staff.head,positions.name as pos_name,department.name as dep_name,staff.phone from staff,positions,department where staff.position_id=positions.id and staff.department_id=department.id)tab where name=? and password=?;";
		System.out.println(sql);
		try {
			//�ر��Զ��ύ
			con.setAutoCommit(false);
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, staff_name);
			statement.setString(2, staff_password);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			//�ύ����
			con.commit();
			//�����Զ��ύ
			con.setAutoCommit(true);
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String password = result.getString("password");
				String card = result.getString("card");
				String sex = result.getString("sex");
				String head = result.getString("head");
				String pos_name = result.getString("pos_name");
				String dep_name = result.getString("dep_name");
				String phone = result.getString("phone");
				// ʹ���������з�װ
				Staff now_Staff = new Staff(id, name, password, card, sex, head, pos_name, dep_name, phone);
				// �����󷵻�
				return now_Staff;
			}
		} catch (SQLException e) {
			//����ع�
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();			
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return null;
	}

	// ���Ų�ѯ�ܼ�¼��
	public int queryAllCount_dep(String search) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from department where name like ?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}

	// ���Ų�ѯ
	public List<Department> staff_Q_dep(PageModel page, String search) {
		// ����һ���������ڴ������
		List<Department> departmentList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from department where name like ? limit ?,?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// ��������
			statement.setInt(2, page.getIndex());
			statement.setInt(3, page.getNums());
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String describer = result.getString("describer");
				// ʹ���������з�װ
				Department dep = new Department(id, name, describer);
				// ����������list��
				departmentList.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return departmentList;
	}

	// ְλ��ѯ�ܼ�¼��
	public int queryAllCount_pos(String search) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from (select positions.id,positions.name as pos_name,department.name as dep_name,positions.describer from positions,department where positions.department_id=department.id)tab where pos_name like ?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}

	// ְλ��ѯ
	public List<Positions> staff_Q_pos(PageModel page, String search) {
		// ����һ���������ڴ������
		List<Positions> positionsList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select positions.id,positions.name as pos_name,department.name as dep_name,positions.describer from positions,department where positions.department_id=department.id)tab where pos_name like ? limit ?,?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// ��������
			statement.setInt(2, page.getIndex());
			statement.setInt(3, page.getNums());
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("pos_name");
				String dep_name = result.getString("dep_name");
				String describer = result.getString("describer");
				// ʹ���������з�װ
				Positions positions = new Positions(id, name, dep_name, describer);
				// ����������list��
				positionsList.add(positions);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return positionsList;
	}

	// �����ѯ�ܼ�¼��
	public int queryAllCount_not(String search) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from (select notice.id,notice.title,notice.content,admin.name,notice.time as not_time from notice,admin where notice.admin_id=admin.id)tab where title like ?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}

	// �����ѯ
	public List<Notice> staff_Q_not(PageModel page, String search) {
		// ����һ���������ڴ������
		List<Notice> noticeList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select notice.id,notice.title,notice.content,admin.name,notice.time from notice,admin where notice.admin_id=admin.id)tab where title like ? limit ?,?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// ��������
			statement.setInt(2, page.getIndex());
			statement.setInt(3, page.getNums());
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String title = result.getString("title");
				String content = result.getString("content");
				String name = result.getString("name");
				String time = result.getString("time");
				// ʹ���������з�װ
				Notice notice = new Notice(id, title, content, name, time);
				// ����������list��
				noticeList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return noticeList;
	}

	// Ա����ѯ�ܼ�¼��
	public int queryAllCount_sta(String search) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from (select staff.id,staff.name,staff.sex,staff.head,positions.name as pos_name,department.name as dep_name,staff.phone,staff.time from staff,positions,department where staff.position_id=positions.id and staff.department_id=department.id)tab where name like ?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}

	// Ա����ѯ
	public List<Staff> staff_Q_sta(PageModel page, String search) {
		// ����һ���������ڴ������
		List<Staff> staffList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select staff.id,staff.name,staff.sex,staff.head,positions.name as pos_name,department.name as dep_name,staff.phone,staff.time from staff,positions,department where staff.position_id=positions.id and staff.department_id=department.id)tab where name like ? limit ?,?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// ��������
			statement.setInt(2, page.getIndex());
			statement.setInt(3, page.getNums());
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String sex = result.getString("sex");
				String head = result.getString("head");
				String pos_name = result.getString("pos_name");
				String dep_name = result.getString("dep_name");
				String phone = result.getString("phone");
				String time = result.getString("time");
				// ʹ���������з�װ
				Staff staff = new Staff(id, name, sex, head, pos_name, dep_name, phone, time);
				// ����������list��
				staffList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return staffList;
	}

	// �޸Ĳ�ѯ
	public Staff querynow(int now_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select staff.id,staff.name,staff.password,staff.card,staff.sex,staff.head,positions.name as pos_name,department.name as dep_name,staff.phone from staff,positions,department where staff.position_id=positions.id and staff.department_id=department.id)tab where id=?;";
		System.out.println(sql);
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, now_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String password = result.getString("password");
				String card = result.getString("card");
				String sex = result.getString("sex");
				String head = result.getString("head");
				String pos_name = result.getString("pos_name");
				String dep_name = result.getString("dep_name");
				String phone = result.getString("phone");
				// ʹ���������з�װ
				Staff now_Staff = new Staff(id, name, password, card, sex, head, pos_name, dep_name, phone);
				// �����󷵻�
				return now_Staff;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return null;
	}

	// �޸�
	public boolean sta_update(Staff sta_ud) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql;

		if (sta_ud.getHead() != null && !sta_ud.getHead().equals("")) {
			sql = "update staff set name=?,password=?,card=?,phone=?,sex=?,head=? where id=?;";
		} else {
			sql = "update staff set name=?,password=?,card=?,phone=?,sex=? where id=?;";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, sta_ud.getName());
			statement.setString(2, sta_ud.getPassword());
			statement.setString(3, sta_ud.getCard());
			statement.setString(4, sta_ud.getPhone());
			statement.setString(5, sta_ud.getSex());
			// �ж��Ƿ���ͼƬ
			if (sta_ud.getHead() != null && !sta_ud.getHead().equals("")) {
				statement.setString(6, sta_ud.getHead());
				statement.setInt(7, sta_ud.getId());
			} else {
				statement.setInt(6, sta_ud.getId());
			}

			// 4��ִ��sql���
			int result = statement.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���false
		return false;
	}

	// �ļ������ϴ��ļ�
	public boolean staff_Up_sta(File sta_file) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into file(title,name,upload_id,time,identity) values(?,?,?,?,?);";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, sta_file.getTitle());
			statement.setString(2, sta_file.getName());
			statement.setInt(3, sta_file.getUpload_id());
			statement.setString(4, sta_file.getTime());
			statement.setString(5, sta_file.getIdentity());
			// 4��ִ��sql���
			int result = statement.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���false
		return false;
	}

	// �ļ���ѯ�ܼ�¼��
	public int queryAllCount_file(String search) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from (select file.id,file.title,file.name as file_name,staff.name,file.time from file,staff where file.upload_id=staff.id and file.identity='sta' union select file.id,file.title,file.name as file_name,admin.name,file.time from file,admin where file.upload_id=admin.id and file.identity='adm')tab where title like ?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}

	// �ļ���ѯ
	public List<File> staff_QD_file(PageModel page, String search) {
		// ����һ���������ڴ������
		List<File> fileList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select file.id,file.title,file.name as file_name,staff.name,file.time from file,staff where file.upload_id=staff.id and file.identity='sta' union select file.id,file.title,file.name as file_name,admin.name,file.time from file,admin where file.upload_id=admin.id and file.identity='adm')tab where title like ? limit ?,?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// ��������
			statement.setInt(2, page.getIndex());
			statement.setInt(3, page.getNums());
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String title = result.getString("title");
				String file_name = result.getString("file_name");
				String all_name = result.getString("name");
				String time = result.getString("time");
				// ʹ���������з�װ
				File file = new File(id, title, file_name, all_name, time);
				// ����������list��
				fileList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return fileList;
	}

	// �����ļ���ѯ�ܼ�¼��
	public int queryAllCount_personalfile(String search, int now_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from (select file.id,file.title,file.name as file_name,staff.name as sta_name,file.time from file,staff where file.upload_id=staff.id and upload_id=? and identity='sta')tab where title like ?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, now_id);
			statement.setString(2, "%" + search + "%");
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}

	// ��ѯ�����ļ�
	public List<File> staff_D_file(PageModel page, String search, int now_id) {
		// ����һ���������ڴ������
		List<File> fileList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select file.id,file.title,file.name as file_name,staff.name as sta_name,file.time from file,staff where file.upload_id=staff.id and upload_id=? and identity='sta')tab where title like ? limit ?,?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, now_id);
			statement.setString(2, "%" + search + "%");
			// ��������
			statement.setInt(3, page.getIndex());
			statement.setInt(4, page.getNums());
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String title = result.getString("title");
				String file_name = result.getString("file_name");
				String all_name = result.getString("sta_name");
				String time = result.getString("time");
				// ʹ���������з�װ
				File file = new File(id, title, file_name, all_name, time);
				// ����������list��
				fileList.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return fileList;
	}

	// ����idɾ�������ļ�
	public boolean staff_De_file(int file_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "delete from file where id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, file_id);
			// 4��ִ��sql���
			int result = statement.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���false
		return false;
	}

	// Ա����ѯ
	public List<Staff> staff_Q_alls(String search) {
		// ����һ���������ڴ������
		List<Staff> staffList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from staff where name like ?;";
		// �жϹؼ����Ƿ�Ϊ��
		if (search == null) {
			search = "";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String head = result.getString("head");
				// ʹ���������з�װ
				Staff staff = new Staff(id, name, head);
				// ����������list��
				staffList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return staffList;
	}

	// ����id��ѯ��Ϣ
	public List<Message> staff_Q_mes(int now_id, int r_id) {
		// ����һ���������ڴ������
		List<Message> messageList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select send_id,content,substring(time,12,5) as time,state from(select * from message where send_id=? and receive_id=? union select * from message where send_id=? and receive_id=? order by time asc)tab;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, now_id);
			statement.setInt(2, r_id);
			statement.setInt(3, r_id);
			statement.setInt(4, now_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int send_id = result.getInt("send_id");
				String content = result.getString("content");
				String time = result.getString("time");
				String state = result.getString("state");
				// ʹ���������з�װ
				Message message = new Message(send_id, content, time, state);
				// ����������list��
				messageList.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return messageList;
	}

	// ����id������
	public Staff r_name(int r_id) {
		Staff staff = new Staff();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select name from staff where id=?";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, r_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				String name = result.getString("name");
				// ʹ���������з�װ
				staff.setName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return staff;
	}

	// ����id�����Ѷ�
	public boolean staff_Se_red(int r_id, int now_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "update message set state='�Ѷ�' where send_id=? and receive_id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, r_id);
			statement.setInt(2, now_id);
			// 4��ִ��sql���
			int result = statement.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���false
		return false;
	}

	// ������Ϣ
	public boolean staff_S_mes(Message message) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into message(send_id,content,receive_id,time,state) values(?,?,?,?,'δ��');";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, message.getSend_id());
			statement.setString(2, message.getContent());
			statement.setInt(3, message.getReceive_id());
			statement.setString(4, message.getTime());
			// 4��ִ��sql���
			int result = statement.executeUpdate();
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���false
		return false;
	}

	// ����Ϣ����
	public List staff_Q_new(int now_id) {
		// ����һ���������ڴ������
		List idList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select send_id from message where receive_id=? and state='δ��';";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, now_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int int_id = result.getInt("send_id");
				/*// ת��
				String send_id = Integer.toString(int_id);*/
				// ����������list��
				idList.add(int_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return idList;
	}

	// ���֤����
	public int Q_card(String card, int now_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from staff where card=? and id!=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, card);
			statement.setInt(2, now_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}

	// �ֻ�����
	public int Q_phone(String phone, int now_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from staff where phone=? and id!=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, phone);
			statement.setInt(2, now_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				// ��ȡ����
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���null
		return 0;
	}
}
