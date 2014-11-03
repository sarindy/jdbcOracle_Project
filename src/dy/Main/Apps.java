package dy.Main;

import dy.databaseTools.objID;

public class Apps {

	public static void main(String[] args) {
		//CustomerDataAccessor customerDataAccessor=new CustomerDataAccessor();
		//customerDataAccessor.getCustomerDetail(31113);
		
		objID objid = new objID("country");
		objid.getObjID();
		System.out.println(objid.getNextID());;

	}

}
