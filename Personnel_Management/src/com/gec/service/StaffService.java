package com.gec.service;

import java.util.List;

import com.gec.entity.Admin;
import com.gec.entity.Department;
import com.gec.entity.File;
import com.gec.entity.Message;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.Staff;

//Staff模块的业务层接口【解耦】
public interface StaffService {

	// 根据用户名和密码--进行登录查询并返回数据
	public Staff queryByAccess(String staff_name, String staff_password);

	// 部门查询总记录数
	public int queryAllCount_dep(String search);

	// 部门查询
	public List<Department> staff_Q_dep(PageModel page, String search);

	// 职位查询总记录数
	public int queryAllCount_pos(String search);

	// 职位查询
	public List<Positions> staff_Q_pos(PageModel page, String search);

	// 公告查询总记录数
	public int queryAllCount_not(String search);

	// 公告查询
	public List<Notice> staff_Q_not(PageModel page, String search);

	// 员工查询总记录数
	public int queryAllCount_sta(String search);

	// 员工查询
	public List<Staff> staff_Q_sta(PageModel page, String search);

	// 修改查询
	public Staff querynow(int now_id);

	// 修改
	public boolean sta_update(Staff sta_ud);

	// 文件中心上传文件
	public boolean staff_Up_sta(File sta_file);

	// 文件查询总记录数
	public int queryAllCount_file(String search);

	// 文件查询
	public List<File> staff_QD_file(PageModel page, String search);

	// 个人文件查询总记录数
	public int queryAllCount_personalfile(String search, int now_id);

	// 查询个人文件
	public List<File> staff_D_file(PageModel page, String search, int now_id);

	// 根据id删除具体文件
	public boolean staff_De_file(int file_id);

	// 查询所有
	public List<Staff> staff_Q_alls(String search);

	// 根据id查询信息
	public List<Message> staff_Q_mes(int now_id, int r_id);

	// 根据id查名字
	public Staff r_name(int r_id);

	// 根据id设置已读
	public boolean staff_Se_red(int r_id, int now_id);

	// 发送消息
	public boolean staff_S_mes(Message message);

	// 新消息提醒
	public List staff_Q_new(int now_id);

	// 身份证查重
	public int Q_card(String card, int now_id);
	
	// 手机查重
	public int Q_phone(String phone, int now_id);
}
