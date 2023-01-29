package com.gec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//���ڻ�ȡ���ݿ����ӵĹ�����
public class DataSourceTool {

	// �ṩ��Ϣ
	// --url jdbc:mysql://ip��ַ:mysql�˿ں�/���ݿ���?�������
	private final static String url = "jdbc:mysql://localhost:3306/management?useUnicode=true&characterEncoding=utf8";
	// --user
	private final static String user = "root";
	// --password
	private final static String password = "";

	// ʹ�þ�̬��ʼ��������������
	static {
		// 1������MySQL�������� --����
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// �ṩ��ȡ���ݿ����ӵľ�̬����
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ����null
		return null;
	}

	// �ṩ�ر����ݿ����ӵľ�̬����
	public static void closeConnection(Connection con) {
		// ��con��Ϊ�յ�ʱ��ȥ�ر�����
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
