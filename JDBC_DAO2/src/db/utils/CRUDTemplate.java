package db.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.handle.IResultSetHandle;

/**
 * CRUD操作模版
 * @author apple
 *
 */
public class CRUDTemplate {
	/**
	 * 更新操作公共方法
	 * @param sql      预编译sql语句
	 * @param params   参数数组
	 * @return
	 */
	public static int _executeUpdate(String sql, Object...params) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			// 连接数据库
			conn = JDBCUtils.getConnection();	
			// 创建预编译
			ps = conn.prepareStatement(sql);
			// 设置参数
			for(int i= 0 ; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			
			// 执行更新
			return ps.executeUpdate(); // 返回更新的行数
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, null);
		}
		return -1; // 如果更新失败，返回-1
	}
	
	/**
	 * 查询 公共方法
	 * @param sql  sql预编译语句
	 * @param rh   结果集处理的实现对象
	 * @param params  要给sql语句传入的参数
	 * @return		返回一个结果集
	 */
	public static <T>T _executeQuery(String sql, IResultSetHandle<T> rh, Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {

			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			return rh.handle(rs); // 处理结果集

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return null;
	}
}
