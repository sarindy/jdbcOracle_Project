package dy.databaseTools.factoryID;


public class IDFactory {
	public objID getFactory(String idType) {
		if (idType == null) {
			return null;
		}
		if (idType.equalsIgnoreCase("country")) {
			return new CountryID();
		}
		if (idType.equalsIgnoreCase("customer")) {
			return new CustomerID();
		}

		return null;

	}

}
