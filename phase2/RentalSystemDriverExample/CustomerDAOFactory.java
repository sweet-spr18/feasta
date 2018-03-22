public class CustomerDAOFactory {
	CustomerDAOFactory factory;
	
	private CustomerDAOFactory() {
		factory = new CustomerDAOFactory();
	}
	
	public static CustomerListDAO getDAOFactory(String type, String filePath) {
		if(type.equals("JSON")) {
			return new CustomerListJSONFileDAO(filePath);
		} else if(type.equals("Text")) {	
			return new CustomerListTEXTFileDAO(filePath);
		}
		return null;
	}
}
