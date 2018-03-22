
public class RentalListDAOFactory {
	
	RentalListDAOFactory factory;
	
	private RentalListDAOFactory() {
		factory = new RentalListDAOFactory();
	}
	
	public static RentalListDAO getDAOFactory(String type, String filePath) {
		if(type.equals("jsonfile")) {
			return new RentalListJSONFileDAO(filePath);
		} else if(type.equals("textfile")) {	
			return new RentalListTEXTFileDAO(filePath);
		}
		return null;
	}
}
