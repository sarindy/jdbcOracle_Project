package dy.Main;

import dy.databaseTools.factoryID.IDFactory;
import dy.databaseTools.factoryID.objID;

public class Apps {

	public static void main(String[] args) {

		// Factory Pattern
		IDFactory idFactory = new IDFactory();
		objID generateID = idFactory.getFactory("customer");
		if(generateID==null){
			System.out.println("No");
		}else {
			System.out.println(generateID.getID());
		}

		

	}

}
