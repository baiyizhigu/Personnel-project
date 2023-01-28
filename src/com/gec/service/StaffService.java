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

//Staffģ���ҵ���ӿڡ����
public interface StaffService {

	// �����û���������--���е�¼��ѯ����������
	public Staff queryByAccess(String staff_name, String staff_password);

	// ���Ų�ѯ�ܼ�¼��
	public int queryAllCount_dep(String search);

	// ���Ų�ѯ
	public List<Department> staff_Q_dep(PageModel page, String search);

	// ְλ��ѯ�ܼ�¼��
	public int queryAllCount_pos(String search);

	// ְλ��ѯ
	public List<Positions> staff_Q_pos(PageModel page, String search);

	// �����ѯ�ܼ�¼��
	public int queryAllCount_not(String search);

	// �����ѯ
	public List<Notice> staff_Q_not(PageModel page, String search);

	// Ա����ѯ�ܼ�¼��
	public int queryAllCount_sta(String search);

	// Ա����ѯ
	public List<Staff> staff_Q_sta(PageModel page, String search);

	// �޸Ĳ�ѯ
	public Staff querynow(int now_id);

	// �޸�
	public boolean sta_update(Staff sta_ud);

	// �ļ������ϴ��ļ�
	public boolean staff_Up_sta(File sta_file);

	// �ļ���ѯ�ܼ�¼��
	public int queryAllCount_file(String search);

	// �ļ���ѯ
	public List<File> staff_QD_file(PageModel page, String search);

	// �����ļ���ѯ�ܼ�¼��
	public int queryAllCount_personalfile(String search, int now_id);

	// ��ѯ�����ļ�
	public List<File> staff_D_file(PageModel page, String search, int now_id);

	// ����idɾ�������ļ�
	public boolean staff_De_file(int file_id);

	// ��ѯ����
	public List<Staff> staff_Q_alls(String search);

	// ����id��ѯ��Ϣ
	public List<Message> staff_Q_mes(int now_id, int r_id);

	// ����id������
	public Staff r_name(int r_id);

	// ����id�����Ѷ�
	public boolean staff_Se_red(int r_id, int now_id);

	// ������Ϣ
	public boolean staff_S_mes(Message message);

	// ����Ϣ����
	public List staff_Q_new(int now_id);

	// ���֤����
	public int Q_card(String card, int now_id);
	
	// �ֻ�����
	public int Q_phone(String phone, int now_id);
}
