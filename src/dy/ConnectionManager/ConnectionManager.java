package dy.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dy.Configuration.Configuration;

public class ConnectionManager {
	private static final String CONFIG_FILENAME = "/Connection-Config.xml";
	
	Configuration config=new Configuration("CONFIG_FILENAME");
	
	public static Connection getConnection(){
		ConnectionManager connection=new ConnectionManager();
		return connection.getDataSource();
	}
	
	private Connection getDataSource(){
        try{
        	Class.forName(config.getDbDriverName());
            try{
                Connection conn = DriverManager.getConnection(config.getDbUri(), config.getDbUserName(), config.getDbPassword());
                if (conn != null){
                    return conn;   
                }
            }catch(SQLException sqlEx){
                
            }
        }catch(ClassNotFoundException cnfEx){
            
        }
        return null;
    }
	
}
