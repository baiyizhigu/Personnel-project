package com.gec.service;

import java.util.List;

import com.gec.entity.Admin;
import com.gec.entity.Department;
import com.gec.entity.File;
import com.gec.entity.Notice;
import com.gec.entity.PageModel;
import com.gec.entity.Positions;
import com.gec.entity.Staff;

//Adminģ���ҵ���ӿڡ����
public interface AdminService {

	// �����û���������--���е�¼��ѯ����������
	public Admin queryByAccess(String staff_name, String staff_password);

	// ���Ų�ѯ�ܼ�¼��
	public int queryAllCount_dep(String search);

	// ���Ų�ѯ
	public List<Department> admin_Q_dep(PageModel page, String search);

	// ְλ��ѯ�ܼ�¼��
	public int queryAllCount_pos(String search);

	// ְλ��ѯ
	public List<Positions> admin_Q_pos(PageModel page, String search);

	// �����ѯ�ܼ�¼��
	public int queryAllCount_not(String search);

	// �����ѯ
	public List<Notice> admin_Q_not(PageModel page, String search);

	// ����Ա��ѯ�ܼ�¼��
	public int queryAllCount_adm(String search);

	// ����Ա��ѯ
	public List<Admin> admin_Q_adm(PageModel page, String search);

	// Ա����ѯ�ܼ�¼��
	public int queryAllCount_sta(String search);

	// Ա����ѯ
	public List<Staff> admin_Q_sta(PageModel page, String search);

	// �ļ���ѯ�ܼ�¼��
	public int queryAllCount_file(String search);

	// �ļ���ѯ
	public List<File> admin_QD_file(PageModel page, String search);

	// ����idɾ������Ա
	public boolean admin_D_adm(int adm_id);

	// ����id��ѯ�޸Ĺ���Ա
	public Admin admin_QU_adm(int adm_id);

	// �޸Ĺ���Ա
	public boolean adm_update(Admin admin);

	// ��ӹ���Ա
	public boolean adm_A_adm(Admin admin);

	// ����idɾ������
	public boolean admin_D_dep(int dep_id);

	// ����id��ѯ�޸Ĺ���Ա
	public Department admin_QU_dep(int dep_id);

	// �޸Ĳ���
	public boolean dep_update(Department department);

	// ��Ӳ���
	public boolean adm_A_dep(Department department);

	// ����idɾ��ְλ
	public boolean admin_D_pos(int pos_id);

	// ����id��ѯ�޸�ְλ
	public Positions admin_QU_pos(int pos_id);

	// �޸�ְλ
	public boolean pos_update(Positions positions);

	// ���ְλ
	public boolean adm_A_pos(Positions positions);

	// ����idɾ������
	public boolean admin_D_not(int not_id);

	// ����id��ѯ�޸Ĺ���
	public Notice admin_QU_not(int not_id);

	// �޸Ĺ���
	public boolean not_update(Notice notice);

	// ��ӹ���
	public boolean adm_A_not(Notice notice);

	// ����idɾ��Ա��
	public boolean admin_D_sta(int sta_id);

	// ����id��ѯ�޸�Ա��
	public Staff admin_QU_sta(int sta_id);

	// �޸�Ա��
	public boolean sta_update(Staff staff);

	// ��ӹ���Ա
	public boolean adm_A_sta(Staff staff);

	// ����idɾ���ļ�
	public boolean admin_De_file(int file_id);

	// �ļ������ϴ��ļ�
	public boolean admin_Up_file(File adm_file);

	// ���Ա�����֤����
	public int Q_card(String card);

	// ���Ա���ֻ�����
	public int Q_phone(String phone);

	// �޸�Ա�����֤����
	public int UQ_card(String card, int old_id);

	// �޸�Ա���ֻ�����
	public int UQ_phone(String phone, int old_id);

	// ���Ա����ѯ����
	public List<String> admin_AQ_sta();
	
	//���ݲ������鲿��id
	public int querydep_id(String depname);
	
	// ���ݲ���id��������ְλ
	public List<String> querypos_name(int dep_id);
	
	// ����ְλ����ְλid
	public int querypos_id(String DeptJob);
	
	// ���ݲ���id�鲿����
	public String querydep_name(int department_id);
}
