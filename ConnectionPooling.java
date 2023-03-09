package advJDBC;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionPooling {
		public static Connection getConnection(){
			Connection connection = null;
			try {
					MysqlDataSource dataSource = new MysqlDataSource();
					dataSource.setURL("jdbc:mysql://localhost:3306/test");
					dataSource.setUser("root");
					dataSource.setPassword("root");
					connection = dataSource.getConnection();
					System.out.println("Connection established");
					return connection;	
					} 
			catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
		}
	}
		
	
	
	




