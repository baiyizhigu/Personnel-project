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
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.Staff;
import com.gec.utils.DataSourceTool;

public class AdminDao {
	// ��¼
	public Admin queryByAccess(String staff_name, String staff_password) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from admin where name=? and password=?;";
		System.out.println(sql);
		try {
			// �ر��Զ��ύ
			con.setAutoCommit(false);
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, staff_name);
			statement.setString(2, staff_password);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			// �ύ����
			con.commit();
			// �����Զ��ύ
			con.setAutoCommit(true);
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String head = result.getString("head");
				String role = result.getString("role");
				// ʹ���������з�װ
				Admin admin = new Admin(id, name, head, role);
				// �����󷵻�
				return admin;
			}
		} catch (SQLException e) {
			// ����ع�
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
	public List<Department> admin_Q_dep(PageModel page, String search) {
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
	public List<Positions> admin_Q_pos(PageModel page, String search) {
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
	public List<Notice> admin_Q_not(PageModel page, String search) {
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

	// ����Ա��ѯ�ܼ�¼��
	public int queryAllCount_adm(String search) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from admin where name like ?;";
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

	// ����Ա��ѯ
	public List<Admin> admin_Q_adm(PageModel page, String search) {
		// ����һ���������ڴ������
		List<Admin> adminList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from admin where name like ? limit ?,?;";
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
				String password = result.getString("password");
				String head = result.getString("head");
				String time = result.getString("time");
				String role = result.getString("role");
				// ʹ���������з�װ
				Admin admin = new Admin(id, name, password, head, time, role);
				// ����������list��
				adminList.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return adminList;
	}

	// Ա����ѯ�ܼ�¼��
	public int queryAllCount_sta(String search) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from (select staff.id,staff.name,staff.password,staff.card,staff.sex,staff.head,positions.name as pos_name,department.name as dep_name,staff.phone,staff.time from staff,positions,department where staff.position_id=positions.id and staff.department_id=department.id)tab where name like ?;";
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
	public List<Staff> admin_Q_sta(PageModel page, String search) {
		// ����һ���������ڴ������
		List<Staff> adm_staffList = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from (select staff.id,staff.name,staff.password,staff.card,staff.sex,staff.head,positions.name as pos_name,department.name as dep_name,staff.phone,staff.time from staff,positions,department where staff.position_id=positions.id and staff.department_id=department.id)tab where name like ? limit ?,?;";
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
				String password = result.getString("password");
				String card = result.getString("card");
				String sex = result.getString("sex");
				String head = result.getString("head");
				String pos_name = result.getString("pos_name");
				String dep_name = result.getString("dep_name");
				String phone = result.getString("phone");
				String time = result.getString("time");
				// ʹ���������з�װ
				Staff staff = new Staff(id, name, password, card, sex, head, pos_name, dep_name, phone, time);
				// ����������list��
				adm_staffList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return adm_staffList;
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
	public List<File> admin_QD_file(PageModel page, String search) {
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

	// ����idɾ������Ա
	public boolean admin_D_adm(int adm_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "delete from admin where id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, adm_id);
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

	// ����id��ѯ�޸Ĺ���Ա
	public Admin admin_QU_adm(int adm_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from admin where id=?;";
		System.out.println(sql);
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, adm_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String password = result.getString("password");
				String head = result.getString("head");
				String role = result.getString("role");
				// ʹ���������з�װ
				Admin admin = new Admin(id, name, password, head, role);
				// �����󷵻�
				return admin;
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

	// �޸Ĺ���Ա
	public boolean adm_update(Admin admin) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql;

		if (admin.getHead() != null && !admin.getHead().equals("")) {
			sql = "update admin set id=?,name=?,password=?,role=?,head=? where id=?;";
		} else {
			sql = "update admin set id=?,name=?,password=?,role=? where id=?;";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, admin.getId());
			statement.setString(2, admin.getName());
			statement.setString(3, admin.getPassword());
			statement.setString(4, admin.getRole());
			// �ж��Ƿ���ͼƬ
			if (admin.getHead() != null && !admin.getHead().equals("")) {
				statement.setString(5, admin.getHead());
				statement.setInt(6, admin.getOld_id());
			} else {
				statement.setInt(5, admin.getOld_id());
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

	// ���ӹ���Ա
	public boolean adm_A_adm(Admin admin) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into admin(name,password,head,time,role) values(?,?,?,?,?);";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, admin.getName());
			statement.setString(2, admin.getPassword());
			// �ж��Ƿ���ͼƬ
			if (admin.getHead() != null && !admin.getHead().equals("")) {
				statement.setString(3, admin.getHead());
			} else {
				statement.setString(3, "m.jpg");
			}
			statement.setString(4, admin.getTime());
			statement.setString(5, admin.getRole());

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

	// ����idɾ������
	public boolean admin_D_dep(int dep_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "delete from department where id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, dep_id);
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

	// ����id��ѯ�޸Ĳ���
	public Department admin_QU_dep(int dep_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from department where id=?;";
		System.out.println(sql);
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, dep_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				String describer = result.getString("describer");
				// ʹ���������з�װ
				Department department = new Department(id, name, describer);
				// �����󷵻�
				return department;
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

	// �޸Ĳ���
	public boolean dep_update(Department department) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "update department set id=?,name=?,describer=? where id=?";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, department.getId());
			statement.setString(2, department.getName());
			statement.setString(3, department.getDescriber());
			statement.setInt(4, department.getOld_id());
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

	// ���Ӳ���
	public boolean adm_A_dep(Department department) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into department(name,describer) values(?,?);";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, department.getName());
			statement.setString(2, department.getDescriber());
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

	// ����idɾ��ְλ
	public boolean admin_D_pos(int pos_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "delete from positions where id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, pos_id);
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

	// ����id��ѯ�޸�ְλ
	public Positions admin_QU_pos(int pos_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from positions where id=?;";
		System.out.println(sql);
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, pos_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String name = result.getString("name");
				int department_id = result.getInt("department_id");
				String describer = result.getString("describer");
				// ʹ���������з�װ
				Positions positions = new Positions(id, name, department_id, describer);
				// �����󷵻�
				return positions;
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

	// �޸Ĳ���
	public boolean pos_update(Positions positions) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "update positions set id=?,name=?,department_id=?,describer=? where id=?";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, positions.getId());
			statement.setString(2, positions.getName());
			statement.setInt(3, positions.getDepartment_id());
			statement.setString(4, positions.getDescriber());
			statement.setInt(5, positions.getOld_id());
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

	// ����ְλ
	public boolean adm_A_pos(Positions positions) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into positions(name,department_id,describer) values(?,?,?);";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, positions.getName());
			statement.setInt(2, positions.getDepartment_id());
			statement.setString(3, positions.getDescriber());
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

	// ����idɾ������
	public boolean admin_D_not(int not_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "delete from notice where id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, not_id);
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

	// ����id��ѯ�޸Ĺ���
	public Notice admin_QU_not(int not_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from notice where id=?;";
		System.out.println(sql);
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, not_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				int id = result.getInt("id");
				String title = result.getString("title");
				String content = result.getString("content");
				int admin_id = result.getInt("admin_id");
				// ʹ���������з�װ
				Notice notice = new Notice(id, title, content, admin_id);
				// �����󷵻�
				return notice;
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

	// �޸Ĺ���
	public boolean not_update(Notice notice) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "update notice set id=?,title=?,content=?,admin_id=?,time=? where id=?";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, notice.getId());
			statement.setString(2, notice.getTitle());
			statement.setString(3, notice.getContent());
			statement.setInt(4, notice.getAdmin_id());
			statement.setString(5, notice.getTime());
			statement.setInt(6, notice.getOld_id());
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

	// ���ӹ���
	public boolean adm_A_not(Notice notice) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into notice(title,content,admin_id,time) values(?,?,?,?);";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, notice.getTitle());
			statement.setString(2, notice.getContent());
			statement.setInt(3, notice.getAdmin_id());
			statement.setString(4, notice.getTime());
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

	// ����idɾ��Ա��
	public boolean admin_D_sta(int sta_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "delete from staff where id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, sta_id);
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

	// ����id��ѯ�޸�Ա��
	public Staff admin_QU_sta(int sta_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from staff where id=?;";
		System.out.println(sql);
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, sta_id);
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
				int position_id = result.getInt("position_id");
				int department_id = result.getInt("department_id");
				String phone = result.getString("phone");
				// ʹ���������з�װ
				Staff staff = new Staff(id, name, password, card, sex, head, position_id, department_id, phone);
				// �����󷵻�
				return staff;
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

	// �޸�Ա��
	public boolean sta_update(Staff staff) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql;

		if (staff.getHead() != null && !staff.getHead().equals("")) {
			sql = "update staff set id=?,name=?,password=?,card=?,sex=?,position_id=?,department_id=?,phone=?,head=? where id=?;";
		} else {
			sql = "update staff set id=?,name=?,password=?,card=?,sex=?,position_id=?,department_id=?,phone=? where id=?;";
		}
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, staff.getId());
			statement.setString(2, staff.getName());
			statement.setString(3, staff.getPassword());
			statement.setString(4, staff.getCard());
			statement.setString(5, staff.getSex());
			statement.setInt(6, staff.getPosition_id());
			statement.setInt(7, staff.getDepartment_id());
			statement.setString(8, staff.getPhone());
			// �ж��Ƿ���ͼƬ
			if (staff.getHead() != null && !staff.getHead().equals("")) {
				statement.setString(9, staff.getHead());
				statement.setInt(10, staff.getOld_id());
			} else {
				statement.setInt(9, staff.getOld_id());
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

	// ����Ա��
	public boolean adm_A_sta(Staff staff) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into staff(name,password,card,sex,position_id,department_id,phone,time,head) values(?,?,?,?,?,?,?,?,?);";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, staff.getName());
			statement.setString(2, staff.getPassword());
			statement.setString(3, staff.getCard());
			statement.setString(4, staff.getSex());
			statement.setInt(5, staff.getPosition_id());
			statement.setInt(6, staff.getDepartment_id());
			statement.setString(7, staff.getPhone());
			statement.setString(8, staff.getTime());
			// �ж��Ƿ���ͼƬ
			if (staff.getHead() != null && !staff.getHead().equals("")) {
				statement.setString(9, staff.getHead());
			} else {
				statement.setString(9, "m.jpg");
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

	// ����idɾ��Ա��
	public boolean admin_De_file(int file_id) {
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

	// �ļ������ϴ��ļ�
	public boolean admin_Up_file(File adm_file) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "insert into file(title,name,upload_id,time,identity) values(?,?,?,?,?);";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, adm_file.getTitle());
			statement.setString(2, adm_file.getName());
			statement.setInt(3, adm_file.getUpload_id());
			statement.setString(4, adm_file.getTime());
			statement.setString(5, adm_file.getIdentity());
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

	// ����Ա������֤����
	public int Q_card(String card) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from staff where card=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, card);
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

	// ����Ա���ֻ�����
	public int Q_phone(String phone) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from staff where phone=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, phone);
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

	// �޸�Ա������֤����
	public int UQ_card(String card, int old_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from staff where card=? and id!=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, card);
			statement.setInt(2, old_id);
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

	// �޸�Ա���ֻ�����
	public int UQ_phone(String phone, int old_id) {
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select count(*) from staff where phone=? and id!=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, phone);
			statement.setInt(2, old_id);
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

	// ���ӹ���Ա��ѯ����
	public List<String> admin_AQ_sta() {
		// ����һ���������ڴ������
		List<String> depname = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select * from department;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				String name = result.getString("name");
				// ����������list��
				depname.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return depname;
	}

	// ���ݲ������鲿��id
	public int querydep_id(String depname) {
		int dep_id = 0;
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select id from department where name=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, depname);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				dep_id = result.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return dep_id;
	}

	// ���ݲ���id��������ְλ
	public List<String> querypos_name(int dep_id) {
		// ����һ���������ڴ������
		List<String> pos_name = new ArrayList<>();
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select name from positions where department_id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, dep_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				String name = result.getString("name");
				// ����������list��
				pos_name.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return pos_name;
	}

	// ����ְλ����ְλid
	public int querypos_id(String DeptJob) {
		int pos_id = 0;
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select id from positions where name=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, DeptJob);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				pos_id = result.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return pos_id;
	}

	// ���ݲ���id�鲿����
	public String querydep_name(int department_id) {
		String name = null;
		// 1����ȡ���ݿ�����
		Connection con = DataSourceTool.getConnection();
		// 2������sql���
		String sql = "select name from department where id=?;";
		try {
			// 3����ȡsql������
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, department_id);
			// 4��ִ��sql��ѯ���
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				// ��ȡ����
				name = result.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5���ر�����
			DataSourceTool.closeConnection(con);
		}
		// Ĭ�Ϸ���userList
		return name;
	}
}