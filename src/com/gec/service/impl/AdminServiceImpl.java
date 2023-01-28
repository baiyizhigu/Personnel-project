package com.gec.service.impl;

import java.util.List;

import com.gec.dao.AdminDao;
import com.gec.entity.Admin;
import com.gec.entity.Department;
import com.gec.entity.File;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.Staff;
import com.gec.service.AdminService;

//admin模块的业务层实现类[业务层调用dao层]
public class AdminServiceImpl implements AdminService {

	// 获取dao的对象，调用数据库操作方法
	private static AdminDao dao = new AdminDao();

	// 登录
	@Override
	public Admin queryByAccess(String staff_name, String staff_password) {
		return dao.queryByAccess(staff_name, staff_password);
	}

	// 部门查询总记录数
	@Override
	public int queryAllCount_dep(String search) {
		return dao.queryAllCount_dep(search);
	}

	// 部门查询
	@Override
	public List<Department> admin_Q_dep(PageModel page, String search) {
		return dao.admin_Q_dep(page, search);
	}

	// 职位查询总记录数
	@Override
	public int queryAllCount_pos(String search) {
		return dao.queryAllCount_pos(search);
	}

	// 职位查询
	@Override
	public List<Positions> admin_Q_pos(PageModel page, String search) {
		return dao.admin_Q_pos(page, search);
	}

	// 公告查询总记录数
	@Override
	public int queryAllCount_not(String search) {
		return dao.queryAllCount_not(search);
	}

	// 公告查询
	@Override
	public List<Notice> admin_Q_not(PageModel page, String search) {
		return dao.admin_Q_not(page, search);
	}

	// 管理员查询总记录数
	@Override
	public int queryAllCount_adm(String search) {
		return dao.queryAllCount_adm(search);
	}

	// 管理员查询
	@Override
	public List<Admin> admin_Q_adm(PageModel page, String search) {
		return dao.admin_Q_adm(page, search);
	}

	// 员工查询总记录数
	@Override
	public int queryAllCount_sta(String search) {
		return dao.queryAllCount_sta(search);
	}

	// 员工查询
	@Override
	public List<Staff> admin_Q_sta(PageModel page, String search) {
		return dao.admin_Q_sta(page, search);
	}

	// 文件查询总记录数
	@Override
	public int queryAllCount_file(String search) {
		return dao.queryAllCount_file(search);
	}

	// 文件查询
	@Override
	public List<File> admin_QD_file(PageModel page, String search) {
		return dao.admin_QD_file(page, search);
	}

	// 根据id删除管理员
	@Override
	public boolean admin_D_adm(int adm_id) {
		return dao.admin_D_adm(adm_id);
	}

	// 根据id查询修改管理员
	@Override
	public Admin admin_QU_adm(int adm_id) {
		return dao.admin_QU_adm(adm_id);
	}

	// 修改
	@Override
	public boolean adm_update(Admin admin) {
		return dao.adm_update(admin);
	}

	// 添加
	@Override
	public boolean adm_A_adm(Admin admin) {
		return dao.adm_A_adm(admin);
	}

	// 根据id删除部门
	@Override
	public boolean admin_D_dep(int dep_id) {
		return dao.admin_D_dep(dep_id);
	}

	// 根据id查询修改部门
	@Override
	public Department admin_QU_dep(int dep_id) {
		return dao.admin_QU_dep(dep_id);
	}

	// 修改部门信息
	@Override
	public boolean dep_update(Department department) {
		return dao.dep_update(department);
	}

	// 添加部门
	@Override
	public boolean adm_A_dep(Department department) {
		return dao.adm_A_dep(department);
	}

	// 根据id删除职位
	@Override
	public boolean admin_D_pos(int pos_id) {
		return dao.admin_D_pos(pos_id);
	}

	// 根据id查询修改职位
	@Override
	public Positions admin_QU_pos(int pos_id) {
		return dao.admin_QU_pos(pos_id);
	}

	// 修改职位信息
	@Override
	public boolean pos_update(Positions positions) {
		return dao.pos_update(positions);
	}

	// 添加职位
	@Override
	public boolean adm_A_pos(Positions positions) {
		return dao.adm_A_pos(positions);
	}

	// 根据id删除公告
	@Override
	public boolean admin_D_not(int not_id) {
		return dao.admin_D_not(not_id);
	}

	// 根据id查询修改公告
	@Override
	public Notice admin_QU_not(int not_id) {
		return dao.admin_QU_not(not_id);
	}

	// 修改职位信息
	@Override
	public boolean not_update(Notice notice) {
		return dao.not_update(notice);
	}

	// 添加公告
	@Override
	public boolean adm_A_not(Notice notice) {
		return dao.adm_A_not(notice);
	}

	// 根据id删除员工
	@Override
	public boolean admin_D_sta(int sta_id) {
		return dao.admin_D_sta(sta_id);
	}

	// 根据id查询修改员工
	@Override
	public Staff admin_QU_sta(int sta_id) {
		return dao.admin_QU_sta(sta_id);
	}

	// 修改员工信息
	@Override
	public boolean sta_update(Staff staff) {
		return dao.sta_update(staff);
	}

	// 添加员工
	@Override
	public boolean adm_A_sta(Staff staff) {
		return dao.adm_A_sta(staff);
	}

	// 根据id删除文件
	@Override
	public boolean admin_De_file(int file_id) {
		return dao.admin_De_file(file_id);
	}

	// 上传文件
	@Override
	public boolean admin_Up_file(File adm_file) {
		return dao.admin_Up_file(adm_file);
	}

	// 添加员工身份证查重
	@Override
	public int Q_card(String card) {
		return dao.Q_card(card);
	}

	// 添加员工手机查重
	@Override
	public int Q_phone(String phone) {
		return dao.Q_phone(phone);
	}

	// 修改员工身份证查重
	@Override
	public int UQ_card(String card, int old_id) {
		return dao.UQ_card(card, old_id);
	}

	// 修改员工手机查重
	@Override
	public int UQ_phone(String phone, int old_id) {
		return dao.UQ_phone(phone, old_id);
	}

	// 添加员工查询部门
	@Override
	public List<String> admin_AQ_sta() {
		return dao.admin_AQ_sta();
	}

	// 根据部门名查部门id
	@Override
	public int querydep_id(String depname) {
		return dao.querydep_id(depname);
	}

	// 根据部门id查下属的职位
	@Override
	public List<String> querypos_name(int dep_id) {
		return dao.querypos_name(dep_id);
	}

	// 根据职位名查职位id
	@Override
	public int querypos_id(String DeptJob) {
		return dao.querypos_id(DeptJob);
	}

	// 根据部门id查部门名
	@Override
	public String querydep_name(int department_id) {
		return dao.querydep_name(department_id);
	}

}
