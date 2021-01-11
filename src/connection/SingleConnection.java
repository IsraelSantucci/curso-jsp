package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
	private static String banco = "jdbc:mariadb://localhost:3306/curso-jsp?autoReconnect=true";
	//private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user= "root";
	private static String password = "";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	public SingleConnection() {
		conectar();
	}
	private static void conectar() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
						   
			//Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(banco,user,password);
			connection.setAutoCommit(false);
			System.out.println("Conectado com sussesso");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch( SQLException e){
			throw new RuntimeException("Problemas ao conectar ao banco de dados");
		}
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
