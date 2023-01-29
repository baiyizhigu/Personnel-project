package com.gec.service.impl;

import java.util.List;

import com.gec.dao.StaffDao;
import com.gec.entity.Department;
import com.gec.entity.File;
import com.gec.entity.Message;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.Staff;
import com.gec.service.StaffService;

//Staff模块的业务层实现类[业务层调用dao层]
public class StaffServiceImpl implements StaffService {

	// 获取dao的对象，调用数据库操作方法
	private static StaffDao dao = new StaffDao();

	// 登录
	@Override
	public Staff queryByAccess(String staff_name, String staff_password) {
		return dao.queryByAccess(staff_name, staff_password);
	}

	// 部门查询总记录数
	@Override
	public int queryAllCount_dep(String search) {
		return dao.queryAllCount_dep(search);
	}

	// 部门查询
	@Override
	public List<Department> staff_Q_dep(PageModel page, String search) {
		return dao.staff_Q_dep(page, search);
	}

	// 职位查询总记录数
	@Override
	public int queryAllCount_pos(String search) {
		return dao.queryAllCount_pos(search);
	}

	// 职位查询
	@Override
	public List<Positions> staff_Q_pos(PageModel page, String search) {
		return dao.staff_Q_pos(page, search);
	}

	// 公告查询总记录数
	@Override
	public int queryAllCount_not(String search) {
		return dao.queryAllCount_not(search);
	}

	// 公告查询
	@Override
	public List<Notice> staff_Q_not(PageModel page, String search) {
		return dao.staff_Q_not(page, search);
	}

	// 员工查询总记录数
	@Override
	public int queryAllCount_sta(String search) {
		return dao.queryAllCount_sta(search);
	}

	// 员工查询
	@Override
	public List<Staff> staff_Q_sta(PageModel page, String search) {
		return dao.staff_Q_sta(page, search);
	}

	// 修改查询
	@Override
	public Staff querynow(int now_id) {
		return dao.querynow(now_id);
	}

	// 修改
	@Override
	public boolean sta_update(Staff sta_ud) {
		return dao.sta_update(sta_ud);
	}

	// 文件中心上传文件
	@Override
	public boolean staff_Up_sta(File sta_file) {
		return dao.staff_Up_sta(sta_file);
	}

	// 文件查询总记录数
	@Override
	public int queryAllCount_file(String search) {
		return dao.queryAllCount_file(search);
	}

	// 文件查询
	@Override
	public List<File> staff_QD_file(PageModel page, String search) {
		return dao.staff_QD_file(page, search);
	}

	// 个人文件查询总记录数
	@Override
	public int queryAllCount_personalfile(String search, int now_id) {
		return dao.queryAllCount_personalfile(search, now_id);
	}

	// 查询个人文件
	@Override
	public List<File> staff_D_file(PageModel page, String search, int now_id) {
		return dao.staff_D_file(page, search, now_id);
	}

	// 根据id删除具体文件
	@Override
	public boolean staff_De_file(int file_id) {
		return dao.staff_De_file(file_id);
	}

	// 查询所有
	@Override
	public List<Staff> staff_Q_alls(String search) {
		return dao.staff_Q_alls(search);
	}

	// 根据id查询信息
	@Override
	public List<Message> staff_Q_mes(int now_id, int r_id) {
		return dao.staff_Q_mes(now_id, r_id);
	}

	// 根据id查名字
	@Override
	public Staff r_name(int r_id) {
		return dao.r_name(r_id);
	}

	// 根据id设置已读
	@Override
	public boolean staff_Se_red(int r_id, int now_id) {
		return dao.staff_Se_red(r_id, now_id);
	}

	// 发送消息
	@Override
	public boolean staff_S_mes(Message message) {
		return dao.staff_S_mes(message);
	}

	// 新消息提醒
	@Override
	public List staff_Q_new(int now_id) {
		return dao.staff_Q_new(now_id);
	}

	// 身份证查重
	@Override
	public int Q_card(String card, int now_id) {
		return dao.Q_card(card, now_id);
	}

	//手机查重
	@Override
	public int Q_phone(String phone, int now_id) {
		return dao.Q_phone(phone, now_id);
	}

}
