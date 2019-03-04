package db.handle;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BeanListHandler<T> implements IResultSetHandle<List<T>>{

	private Class<T> classType;
	public BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}
	
	/**
	 * 查询
	 * 返回集合
	 */
	@Override
	public List<T> handle(ResultSet rs) {
		List<T> list = new ArrayList<>();
		try {
			while(rs.next()) {
				T obj = this.classType.newInstance();
				BeanInfo bf = Introspector.getBeanInfo(this.classType,Object.class);
				PropertyDescriptor[] pds = bf.getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					Object val = rs.getObject(pd.getName());
					pd.getWriteMethod().invoke(obj, val);
				}
				list.add(obj);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();;
		}
		
		
		return null;
	}

}
