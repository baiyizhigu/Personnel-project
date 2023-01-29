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

//Staffģ���ҵ���ʵ����[ҵ������dao��]
public class StaffServiceImpl implements StaffService {

	// ��ȡdao�Ķ��󣬵������ݿ��������
	private static StaffDao dao = new StaffDao();

	// ��¼
	@Override
	public Staff queryByAccess(String staff_name, String staff_password) {
		return dao.queryByAccess(staff_name, staff_password);
	}

	// ���Ų�ѯ�ܼ�¼��
	@Override
	public int queryAllCount_dep(String search) {
		return dao.queryAllCount_dep(search);
	}

	// ���Ų�ѯ
	@Override
	public List<Department> staff_Q_dep(PageModel page, String search) {
		return dao.staff_Q_dep(page, search);
	}

	// ְλ��ѯ�ܼ�¼��
	@Override
	public int queryAllCount_pos(String search) {
		return dao.queryAllCount_pos(search);
	}

	// ְλ��ѯ
	@Override
	public List<Positions> staff_Q_pos(PageModel page, String search) {
		return dao.staff_Q_pos(page, search);
	}

	// �����ѯ�ܼ�¼��
	@Override
	public int queryAllCount_not(String search) {
		return dao.queryAllCount_not(search);
	}

	// �����ѯ
	@Override
	public List<Notice> staff_Q_not(PageModel page, String search) {
		return dao.staff_Q_not(page, search);
	}

	// Ա����ѯ�ܼ�¼��
	@Override
	public int queryAllCount_sta(String search) {
		return dao.queryAllCount_sta(search);
	}

	// Ա����ѯ
	@Override
	public List<Staff> staff_Q_sta(PageModel page, String search) {
		return dao.staff_Q_sta(page, search);
	}

	// �޸Ĳ�ѯ
	@Override
	public Staff querynow(int now_id) {
		return dao.querynow(now_id);
	}

	// �޸�
	@Override
	public boolean sta_update(Staff sta_ud) {
		return dao.sta_update(sta_ud);
	}

	// �ļ������ϴ��ļ�
	@Override
	public boolean staff_Up_sta(File sta_file) {
		return dao.staff_Up_sta(sta_file);
	}

	// �ļ���ѯ�ܼ�¼��
	@Override
	public int queryAllCount_file(String search) {
		return dao.queryAllCount_file(search);
	}

	// �ļ���ѯ
	@Override
	public List<File> staff_QD_file(PageModel page, String search) {
		return dao.staff_QD_file(page, search);
	}

	// �����ļ���ѯ�ܼ�¼��
	@Override
	public int queryAllCount_personalfile(String search, int now_id) {
		return dao.queryAllCount_personalfile(search, now_id);
	}

	// ��ѯ�����ļ�
	@Override
	public List<File> staff_D_file(PageModel page, String search, int now_id) {
		return dao.staff_D_file(page, search, now_id);
	}

	// ����idɾ�������ļ�
	@Override
	public boolean staff_De_file(int file_id) {
		return dao.staff_De_file(file_id);
	}

	// ��ѯ����
	@Override
	public List<Staff> staff_Q_alls(String search) {
		return dao.staff_Q_alls(search);
	}

	// ����id��ѯ��Ϣ
	@Override
	public List<Message> staff_Q_mes(int now_id, int r_id) {
		return dao.staff_Q_mes(now_id, r_id);
	}

	// ����id������
	@Override
	public Staff r_name(int r_id) {
		return dao.r_name(r_id);
	}

	// ����id�����Ѷ�
	@Override
	public boolean staff_Se_red(int r_id, int now_id) {
		return dao.staff_Se_red(r_id, now_id);
	}

	// ������Ϣ
	@Override
	public boolean staff_S_mes(Message message) {
		return dao.staff_S_mes(message);
	}

	// ����Ϣ����
	@Override
	public List staff_Q_new(int now_id) {
		return dao.staff_Q_new(now_id);
	}

	// ���֤����
	@Override
	public int Q_card(String card, int now_id) {
		return dao.Q_card(card, now_id);
	}

	//�ֻ�����
	@Override
	public int Q_phone(String phone, int now_id) {
		return dao.Q_phone(phone, now_id);
	}

}
