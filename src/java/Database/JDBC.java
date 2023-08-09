/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC{
   public static Connection ConectSQLserver()throws SQLException{
        Connection connection = null;
       try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url = "jdbc:sqlserver://LAPTOP-4E92285A:1433;databaseName=quanlichitieu;encrypt=false";
           String uername ="sa";
           String password = "123456789";
           connection  = DriverManager.getConnection(url,uername,password);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return  connection; 
   }
   
   
   public static void closeconnect(Connection f) {
		try {
			if( f!= null) {
				f.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
