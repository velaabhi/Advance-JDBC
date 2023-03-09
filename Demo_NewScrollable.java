package advJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo_NewScrollable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //to register the driver dynamically
			System.out.println("Driver loaded");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("Connection Established");
			
		//1. Displaying whole table
			String query = "select * from student;";
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData metaData = resultSet.getMetaData();
			System.out.println("Displaying whole table");
			System.out.println(metaData.getColumnLabel(1)+"\t"+metaData.getColumnLabel(2)+"\t\t"+metaData.getColumnLabel(3));
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3));
			}
			
		//2. Going to specific row - resultSet.absolute(row index);
			resultSet.absolute(2);
			System.out.println("\nCursor is at current row");
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3));
			
		//3. Updating a row - resultSet.update_Datatype(col index, value); and resultSet.updateRow();
			resultSet.updateString(2, "RupeshV");
			resultSet.updateString(3, "Auto Tester");
			resultSet.updateRow();
			System.out.println("\nRow is updated");
			System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3));
		
			/*
		//4. Inserting new row - resultSet.moveToInsertRow(), update_datatype() and insertRow()
			resultSet.moveToInsertRow();
			resultSet.updateInt(1,6);
			resultSet.updateString(2, "Priya");
			resultSet.updateString(3, "DyCol");
			resultSet.insertRow();
			System.out.println("\nRow Inserted");
			resultSet.absolute(0);
			System.out.println(metaData.getColumnLabel(1)+"\t"+metaData.getColumnLabel(2)+"\t\t"+metaData.getColumnLabel(3));
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3));
			}
			
			
		//5.Deleting a row - 
			resultSet.absolute(5);
			resultSet.deleteRow();
			System.out.println("Row is deleted");
			*/
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

	}

}
