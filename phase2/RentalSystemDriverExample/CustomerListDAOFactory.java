
public class CustomerListDAOFactory {

	CustomerListDAOFactory factory;
	
	private CustomerListDAOFactory() {
		factory = new CustomerListDAOFactory();
	}
	
	public static CustomerListDAO getDAOFactory(String type, String filePath) {
		if(type.equals("jsonfile")) {
			CustomerListJSONFileDAO cljson = new CustomerListJSONFileDAO(filePath);
			return cljson;
		} else if(type.equals("textfile")) {	
			
			return new CustomerListTEXTFileDAO(filePath);
		}
		return null;
	}
}
