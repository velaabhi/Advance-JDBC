package advJDBC;

import java.sql.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DbConnection {
	public static Connection getConnection(){
		Connection connection = null;			//creating Connection obj outside try
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setURL("jdbc:mysql://localhost:3306/test");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			
			connection = dataSource.getConnection();
			System.out.println("Connection established");
			return connection;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
}
