package dy.Main;

import dy.DatabaseDesign.CustomerDataAccessor;

public class Apps {

	public static void main(String[] args) {
		CustomerDataAccessor customerDataAccessor=new CustomerDataAccessor();
		customerDataAccessor.getCustomerDetail(31113);

	}

}
