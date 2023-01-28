package com.gec.service;

import java.util.List;

import com.gec.entity.Admin;
import com.gec.entity.Department;
import com.gec.entity.File;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.Staff;

//Admin模块的业务层接口【解耦】
public interface AdminService {

	// 根据用户名和密码--进行登录查询并返回数据
	public Admin queryByAccess(String staff_name, String staff_password);

	// 部门查询总记录数
	public int queryAllCount_dep(String search);

	// 部门查询
	public List<Department> admin_Q_dep(PageModel page, String search);

	// 职位查询总记录数
	public int queryAllCount_pos(String search);

	// 职位查询
	public List<Positions> admin_Q_pos(PageModel page, String search);

	// 公告查询总记录数
	public int queryAllCount_not(String search);

	// 公告查询
	public List<Notice> admin_Q_not(PageModel page, String search);

	// 管理员查询总记录数
	public int queryAllCount_adm(String search);

	// 管理员查询
	public List<Admin> admin_Q_adm(PageModel page, String search);

	// 员工查询总记录数
	public int queryAllCount_sta(String search);

	// 员工查询
	public List<Staff> admin_Q_sta(PageModel page, String search);

	// 文件查询总记录数
	public int queryAllCount_file(String search);

	// 文件查询
	public List<File> admin_QD_file(PageModel page, String search);

	// 根据id删除管理员
	public boolean admin_D_adm(int adm_id);

	// 根据id查询修改管理员
	public Admin admin_QU_adm(int adm_id);

	// 修改管理员
	public boolean adm_update(Admin admin);

	// 添加管理员
	public boolean adm_A_adm(Admin admin);

	// 根据id删除部门
	public boolean admin_D_dep(int dep_id);

	// 根据id查询修改管理员
	public Department admin_QU_dep(int dep_id);

	// 修改部门
	public boolean dep_update(Department department);

	// 添加部门
	public boolean adm_A_dep(Department department);

	// 根据id删除职位
	public boolean admin_D_pos(int pos_id);

	// 根据id查询修改职位
	public Positions admin_QU_pos(int pos_id);

	// 修改职位
	public boolean pos_update(Positions positions);

	// 添加职位
	public boolean adm_A_pos(Positions positions);

	// 根据id删除公告
	public boolean admin_D_not(int not_id);

	// 根据id查询修改公告
	public Notice admin_QU_not(int not_id);

	// 修改公告
	public boolean not_update(Notice notice);

	// 添加公告
	public boolean adm_A_not(Notice notice);

	// 根据id删除员工
	public boolean admin_D_sta(int sta_id);

	// 根据id查询修改员工
	public Staff admin_QU_sta(int sta_id);

	// 修改员工
	public boolean sta_update(Staff staff);

	// 添加管理员
	public boolean adm_A_sta(Staff staff);

	// 根据id删除文件
	public boolean admin_De_file(int file_id);

	// 文件中心上传文件
	public boolean admin_Up_file(File adm_file);

	// 添加员工身份证查重
	public int Q_card(String card);

	// 添加员工手机查重
	public int Q_phone(String phone);

	// 修改员工身份证查重
	public int UQ_card(String card, int old_id);

	// 修改员工手机查重
	public int UQ_phone(String phone, int old_id);

	// 添加员工查询部门
	public List<String> admin_AQ_sta();
	
	//根据部门名查部门id
	public int querydep_id(String depname);
	
	// 根据部门id查下属的职位
	public List<String> querypos_name(int dep_id);
	
	// 根据职位名查职位id
	public int querypos_id(String DeptJob);
	
	// 根据部门id查部门名
	public String querydep_name(int department_id);
}
