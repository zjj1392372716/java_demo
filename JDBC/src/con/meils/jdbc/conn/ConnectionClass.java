package con.meils.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		// 加载驱动
		// 把com.mysql.jdbc.Driver这份字节码加载进JVM
		// 当一份字节码加载进JVM的时候，就会执行字节码文件中的静态代码块
		// 这里加载该字节码之后会实例化一个驱动器
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/mytest";
		String username = "root";
		String password = "zjj19970517";
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println(connection); // 如果有输出，表明连接成功
	}

}
