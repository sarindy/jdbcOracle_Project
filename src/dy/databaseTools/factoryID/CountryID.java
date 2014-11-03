package dy.databaseTools.factoryID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dy.ConnectionManager.ConnectionManager;

public class CountryID implements objID{
	
	private String generatedID=null;
	private String idText=null;
	private boolean isEmpty=false;

	@Override
	public String getID() {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepareStatement = null;
		try {

			String selectSQl = "select code from id_code where description = 'COUNTRY'";
			prepareStatement = conn.prepareStatement(selectSQl);
			ResultSet rs = prepareStatement.executeQuery();

			while (rs.next()) {
				idText = rs.getString(1).toUpperCase();
				isEmpty = true;

			}
			if (isEmpty == true) {
				

				prepareStatement = conn.prepareStatement("select next value for country_id_seq");
				rs = prepareStatement.executeQuery();
				while (rs.next()) {
					setGeneratedID(idText + rs.getInt(1));
				}
			}else{
				System.out.println("NO RESULT");
			}

			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return generatedID;
	}

	public String getGeneratedID() {
		return generatedID;
	}

	public void setGeneratedID(String generatedID) {
		this.generatedID = generatedID;
	}
	
	
	
	

	
	

}
