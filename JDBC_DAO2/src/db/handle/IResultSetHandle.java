package db.handle;

import java.sql.ResultSet;
import java.util.List;

/**
 * 结果集处理接口
 * @author apple
 *
 */
public interface IResultSetHandle<T>{
	/**
	 * 处理结果集
	 * @param rs  传入结果集
	 * @return    返回List集合
	 */
	T handle(ResultSet rs);
}
	