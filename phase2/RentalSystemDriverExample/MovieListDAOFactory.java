public class MovieListDAOFactory {

	MovieListDAOFactory factory;
	
	private MovieListDAOFactory() {
		factory = new MovieListDAOFactory();
	}
	
	public static MovieListDAO getDAOFactory(String type, String filePath) {
		if(type.equals("jsonfile")) {
			return new MovieListJSONFileDAO(filePath);
		} else if(type.equals("textfile")) {	
			return new MovieListTEXTFileDAO(filePath);
		}
		return null;
	
	}
}
