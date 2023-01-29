package com.gec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//用于获取数据库链接的工具类
public class DataSourceTool {

	// 提供信息
	// --url jdbc:mysql://ip地址:mysql端口号/数据库名?请求参数
	private final static String url = "jdbc:mysql://localhost:3306/management?useUnicode=true&characterEncoding=utf8";
	// --user
	private final static String user = "root";
	// --password
	private final static String password = "";

	// 使用静态初始化块来加载驱动
	static {
		// 1、加载MySQL的驱动类 --反射
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 提供获取数据库链接的静态方法
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回null
		return null;
	}

	// 提供关闭数据库链接的静态方法
	public static void closeConnection(Connection con) {
		// 当con不为空的时候去关闭链接
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
