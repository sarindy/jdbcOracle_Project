package dy.databaseTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dy.ConnectionManager.ConnectionManager;

public class objID {
	private String nextID = null;
	private String objName = null;
	private String idText = null;
	private String selectSQl = null;
	private ResultSet rs=null;
	
	private boolean isEmpty = false;

	public String getNextID() {
		return nextID;
	}

	public void setNextID(String nextID) {
		this.nextID = nextID;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public void getObjID() {

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepareStatement = null;
		try {

			selectSQl = "select code from id_code where description = ?";
			prepareStatement = conn.prepareStatement(selectSQl);
			prepareStatement.setString(1, this.objName);// 1 is the index of the
														// parameter and
														// custAcctid is the
														// parameter
			 rs = prepareStatement.executeQuery();

			while (rs.next()) {
				this.idText = rs.getString(1).toUpperCase();
				this.isEmpty = true;

			}
			if (this.isEmpty == true) {
				switch (this.objName.toUpperCase()) {
				case "COUNTRY":
					selectSQl = "select next value for country_id_seq";
					break;
				case "CUSTOMER":
					selectSQl = "select next value for customer_id_seq";
					break;
				default:
					selectSQl = "";
					break;
				}

				prepareStatement = conn.prepareStatement(selectSQl);
				rs = prepareStatement.executeQuery();
				while (rs.next()) {
					this.setNextID(this.idText + rs.getInt(1));
				}
			}else{
				System.out.println("NO RESULT");
			}

			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	public objID(String objIdSeq) {
		super();
		this.objName = objIdSeq;
	}

}
