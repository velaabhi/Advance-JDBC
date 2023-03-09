package advJDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_Blob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection connection = DbConnection.getConnection())			//try with resource
		{
			FileInputStream fileInputStream = new FileInputStream("D:\\Core JAVA\\CoreJavaCoding\\src\\advJDBC\\indiaFlag.jpg");
			String query = "insert into blobtable values(?,?);";
/*			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			preparedStatement.setBlob(2, fileInputStream); 		//to persist img into db
			int i = preparedStatement.executeUpdate();
			if(i>0)
			{
				System.out.println("Row inserted");
			}
			else
			{
				System.out.println("Error ");
			}
*/			
			String query1 = "select * from blobtable;";
			Statement statement =  connection.createStatement();
			ResultSet resultSet= statement.executeQuery(query1);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" - "+resultSet.get(2));
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
