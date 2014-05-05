package dy.DatabaseDesign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dy.ConnectionManager.ConnectionManager;
import dy.Model.AccountNumFormat;
import dy.Model.CustomerDetail;

public class CustomerDataAccessor {
	private static final String NAMES = "NAMES";
	private static final String CUST_ACCT_ID = "CUSTACCTID";
	private static final String NBC_CODE = "NBC_CODE";
	private static final String ACCT_NUM = "ACCT_NUM";
	private static final String BRANCH_ID = "BRANCH_ID";
	private static final String ACCT_TYPE = "CUST_ACCT_TYPE_ID";
	private static final String ACCT_CHK = "CHKSUM";
	private static final String OPEN_DATE = "OPEN_DATE";
	
	public List<CustomerDetail> getCustomerDetail(int custAcctid){
		List<CustomerDetail> arrayList=new ArrayList<CustomerDetail>();
		
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement prepareStatement=null;
		String selectSQL="SELECT NAMES,CUSTACCTID,NBC_CODE,ACCT_NUM,BRANCH_ID,CUST_ACCT_TYPE_ID,CHKSUM,OPEN_DATE FROM CUST_ACCT WHERE CUSTACCTID = ?";
		try {
			prepareStatement=conn.prepareStatement(selectSQL);
			prepareStatement.setInt(1,  custAcctid);
			ResultSet rs=prepareStatement.executeQuery();
			
			
			while (rs.next()){
				AccountNumFormat acctFormat= new AccountNumFormat(rs.getString(NBC_CODE), rs.getString(BRANCH_ID), rs.getString(ACCT_TYPE), rs.getString(ACCT_NUM), rs.getString(ACCT_CHK));
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
				CustomerDetail row=new CustomerDetail();
				row.setCustName(rs.getString(NAMES));
				row.setCustAcct(acctFormat.toString());
				row.setOpenDate(formatter.format(rs.getDate(OPEN_DATE)));
				System.out.println(rs.getString(NAMES));
				System.out.println(acctFormat.toString());
				System.out.println(formatter.format(rs.getDate(OPEN_DATE)));
				arrayList.add(row);
				
				
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return arrayList;
		
	}

}
