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

//adminģ���ҵ���ʵ����[ҵ������dao��]
public class AdminServiceImpl implements AdminService {

	// ��ȡdao�Ķ��󣬵������ݿ��������
	private static AdminDao dao = new AdminDao();

	// ��¼
	@Override
	public Admin queryByAccess(String staff_name, String staff_password) {
		return dao.queryByAccess(staff_name, staff_password);
	}

	// ���Ų�ѯ�ܼ�¼��
	@Override
	public int queryAllCount_dep(String search) {
		return dao.queryAllCount_dep(search);
	}

	// ���Ų�ѯ
	@Override
	public List<Department> admin_Q_dep(PageModel page, String search) {
		return dao.admin_Q_dep(page, search);
	}

	// ְλ��ѯ�ܼ�¼��
	@Override
	public int queryAllCount_pos(String search) {
		return dao.queryAllCount_pos(search);
	}

	// ְλ��ѯ
	@Override
	public List<Positions> admin_Q_pos(PageModel page, String search) {
		return dao.admin_Q_pos(page, search);
	}

	// �����ѯ�ܼ�¼��
	@Override
	public int queryAllCount_not(String search) {
		return dao.queryAllCount_not(search);
	}

	// �����ѯ
	@Override
	public List<Notice> admin_Q_not(PageModel page, String search) {
		return dao.admin_Q_not(page, search);
	}

	// ����Ա��ѯ�ܼ�¼��
	@Override
	public int queryAllCount_adm(String search) {
		return dao.queryAllCount_adm(search);
	}

	// ����Ա��ѯ
	@Override
	public List<Admin> admin_Q_adm(PageModel page, String search) {
		return dao.admin_Q_adm(page, search);
	}

	// Ա����ѯ�ܼ�¼��
	@Override
	public int queryAllCount_sta(String search) {
		return dao.queryAllCount_sta(search);
	}

	// Ա����ѯ
	@Override
	public List<Staff> admin_Q_sta(PageModel page, String search) {
		return dao.admin_Q_sta(page, search);
	}

	// �ļ���ѯ�ܼ�¼��
	@Override
	public int queryAllCount_file(String search) {
		return dao.queryAllCount_file(search);
	}

	// �ļ���ѯ
	@Override
	public List<File> admin_QD_file(PageModel page, String search) {
		return dao.admin_QD_file(page, search);
	}

	// ����idɾ������Ա
	@Override
	public boolean admin_D_adm(int adm_id) {
		return dao.admin_D_adm(adm_id);
	}

	// ����id��ѯ�޸Ĺ���Ա
	@Override
	public Admin admin_QU_adm(int adm_id) {
		return dao.admin_QU_adm(adm_id);
	}

	// �޸�
	@Override
	public boolean adm_update(Admin admin) {
		return dao.adm_update(admin);
	}

	// ����
	@Override
	public boolean adm_A_adm(Admin admin) {
		return dao.adm_A_adm(admin);
	}

	// ����idɾ������
	@Override
	public boolean admin_D_dep(int dep_id) {
		return dao.admin_D_dep(dep_id);
	}

	// ����id��ѯ�޸Ĳ���
	@Override
	public Department admin_QU_dep(int dep_id) {
		return dao.admin_QU_dep(dep_id);
	}

	// �޸Ĳ�����Ϣ
	@Override
	public boolean dep_update(Department department) {
		return dao.dep_update(department);
	}

	// ���Ӳ���
	@Override
	public boolean adm_A_dep(Department department) {
		return dao.adm_A_dep(department);
	}

	// ����idɾ��ְλ
	@Override
	public boolean admin_D_pos(int pos_id) {
		return dao.admin_D_pos(pos_id);
	}

	// ����id��ѯ�޸�ְλ
	@Override
	public Positions admin_QU_pos(int pos_id) {
		return dao.admin_QU_pos(pos_id);
	}

	// �޸�ְλ��Ϣ
	@Override
	public boolean pos_update(Positions positions) {
		return dao.pos_update(positions);
	}

	// ����ְλ
	@Override
	public boolean adm_A_pos(Positions positions) {
		return dao.adm_A_pos(positions);
	}

	// ����idɾ������
	@Override
	public boolean admin_D_not(int not_id) {
		return dao.admin_D_not(not_id);
	}

	// ����id��ѯ�޸Ĺ���
	@Override
	public Notice admin_QU_not(int not_id) {
		return dao.admin_QU_not(not_id);
	}

	// �޸�ְλ��Ϣ
	@Override
	public boolean not_update(Notice notice) {
		return dao.not_update(notice);
	}

	// ���ӹ���
	@Override
	public boolean adm_A_not(Notice notice) {
		return dao.adm_A_not(notice);
	}

	// ����idɾ��Ա��
	@Override
	public boolean admin_D_sta(int sta_id) {
		return dao.admin_D_sta(sta_id);
	}

	// ����id��ѯ�޸�Ա��
	@Override
	public Staff admin_QU_sta(int sta_id) {
		return dao.admin_QU_sta(sta_id);
	}

	// �޸�Ա����Ϣ
	@Override
	public boolean sta_update(Staff staff) {
		return dao.sta_update(staff);
	}

	// ����Ա��
	@Override
	public boolean adm_A_sta(Staff staff) {
		return dao.adm_A_sta(staff);
	}

	// ����idɾ���ļ�
	@Override
	public boolean admin_De_file(int file_id) {
		return dao.admin_De_file(file_id);
	}

	// �ϴ��ļ�
	@Override
	public boolean admin_Up_file(File adm_file) {
		return dao.admin_Up_file(adm_file);
	}

	// ����Ա������֤����
	@Override
	public int Q_card(String card) {
		return dao.Q_card(card);
	}

	// ����Ա���ֻ�����
	@Override
	public int Q_phone(String phone) {
		return dao.Q_phone(phone);
	}

	// �޸�Ա������֤����
	@Override
	public int UQ_card(String card, int old_id) {
		return dao.UQ_card(card, old_id);
	}

	// �޸�Ա���ֻ�����
	@Override
	public int UQ_phone(String phone, int old_id) {
		return dao.UQ_phone(phone, old_id);
	}

	// ����Ա����ѯ����
	@Override
	public List<String> admin_AQ_sta() {
		return dao.admin_AQ_sta();
	}

	// ���ݲ������鲿��id
	@Override
	public int querydep_id(String depname) {
		return dao.querydep_id(depname);
	}

	// ���ݲ���id��������ְλ
	@Override
	public List<String> querypos_name(int dep_id) {
		return dao.querypos_name(dep_id);
	}

	// ����ְλ����ְλid
	@Override
	public int querypos_id(String DeptJob) {
		return dao.querypos_id(DeptJob);
	}

	// ���ݲ���id�鲿����
	@Override
	public String querydep_name(int department_id) {
		return dao.querydep_name(department_id);
	}

}