package com.mkit.website.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtil {
	
	

	/**
	 * 1.这个类不能被继承 所以应该是final类型 2.驱动类只加载一次 classforname 3.对外只提供方法,并不实例化对象
	 * 构造方法变成私有的 单例---静态static方法 4.领域对象设置为私有类型,防止其他的人调用 易于以后维护和升级
	 */
	private static String dirver ="com.mysql.jdbc.Driver";					//驱动字符串
	private static String url = "jdbc:mysql://localhost:3306/artdb"; 			// 链接字符串
	private static String userName = "root";
	private static String passWord = "root";

	/**
	 * 这个类没有实例,没有构造函数
	 * 通过类去调用方法 
	 */
	
	
	/**
	 * 注册驱动
	 */
	static {
		try {
			Class.forName(dirver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 建立连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userName, passWord);
	}
	
	
	/**
	 * 关闭连接
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}



