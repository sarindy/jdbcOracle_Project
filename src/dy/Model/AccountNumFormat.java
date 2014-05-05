package dy.Model;

public class AccountNumFormat {
	private String nbcCode=null;
	private String brCode=null;
	private String acctType=null;
	private String acctNum=null;
	private String chkSum=null;
	
	
	
	
	public AccountNumFormat(String nbcCode, String brCode, String acctType,
			String acctNum, String chkSum) {
		super();
		this.nbcCode = nbcCode;
		this.brCode = brCode;
		this.acctType = acctType;
		this.acctNum = acctNum;
		this.chkSum = chkSum;
	}
	
	@Override
	public String toString() {
		return  nbcCode + "-" + brCode
				+ "-" + acctType + "-" + acctNum
				+ "-" + chkSum ;
	}
	public String getNbcCode() {
		return nbcCode;
	}
	public void setNbcCode(String nbcCode) {
		this.nbcCode = nbcCode;
	}
	public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public String getChkSum() {
		return chkSum;
	}
	public void setChkSum(String chkSum) {
		this.chkSum = chkSum;
	}
	
	

}
