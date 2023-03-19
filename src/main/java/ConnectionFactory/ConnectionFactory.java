package ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 產生連線的工廠。<br>
 * 擁有靜態的取得連線物件的方法，不須new即可使用。
 * 
 */
public class ConnectionFactory {

	/**
	 * 使用JNDI尋找DataSource，取得連線物件後回傳。<br>
	 * 
	 * @return Connection 連線物件
	 */
	public static Connection getConnection() {
		
		try {
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/MSSQL");
		Connection conn = ds.getConnection();
		return conn;
		}catch (javax.naming.NameNotFoundException e){
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
