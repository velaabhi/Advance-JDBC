package advJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Connection con = ConnectionPooling.getConnection();
			try {
				Statement statement = con.createStatement();
				con.setAutoCommit(false);
				statement.addBatch("insert into student values (5,'Neeraj','Guitar')");
				statement.addBatch("insert into student values (6,'Sneha','Cajon')");
				statement.addBatch("insert into student values (7,'Ganesh','Mech')");

				int ar[] = statement.executeBatch();
				System.out.println(ar.length);
				if(ar.length == 3)
				{
					con.commit();
					System.out.println("3 Rows inserted  successfully");
				}
				else
				{
					con.rollback();
					System.out.println("Rollback");
					
				}					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
