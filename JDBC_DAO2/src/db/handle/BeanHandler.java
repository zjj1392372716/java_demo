package db.handle;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集处理接口的实现类
 * @author apple
 *
 * @param <T>
 * 
 */
public class BeanHandler<T> implements IResultSetHandle <T>{
	public Class<T> classType;
	public BeanHandler (Class<T> classType) {
		this.classType = classType;
	}
	
	/**
	 * 处理结果集返回结果
	 * 返回一个对象
	 */
	@Override
	public T handle(ResultSet rs) {
		try {
			if(rs.next()) {
				try {
					// 实例化一个对象
					T obj = this.classType.newInstance();
					// 获取BeanInfo 对象
					BeanInfo bf = Introspector.getBeanInfo(this.classType, Object.class);
					// 获取BeanClass 类的属性和方法
					PropertyDescriptor[] pds = bf.getPropertyDescriptors();

					for (PropertyDescriptor pd : pds) {
						Object val = rs.getObject(pd.getName());
						//¸使用set方法，设置属性值
						pd.getWriteMethod().invoke(obj, val);
					}
					return obj;
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
