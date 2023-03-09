package advJDBC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_Clob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection connection = DbConnection.getConnection())			//try with resource
		{
			connection.setAutoCommit(false);
			BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Core JAVA\\CoreJavaCoding\\src\\advJDBC\\info.txt"));
			/*
			String query = "insert into clobtable values(?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setClob(2, bufferedReader);
			if(preparedStatement.executeUpdate() > 0) {
				connection.commit();
				System.out.println("Row inserted");
			}
			else
			{
				connection.rollback();
				System.out.println("error");
			}
			*/
			String query1 = "select * from clobtable;";
			Statement statement =  connection.createStatement();
			ResultSet resultSet= statement.executeQuery(query1);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
