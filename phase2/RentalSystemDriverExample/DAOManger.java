import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DAOManger {

	private static RentalListDAO DAORentalList;
	private static CustomerListDAO DAOCustomerList;
	private static MovieListDAO DAOMovieList;
	
	private DAOManger() {
		System.out.print("this works");
		
		try {
			create();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void create() throws IOException {
		
		FileInputStream in = new FileInputStream("dao.properties"); 
		Properties defaultProps = new Properties();
		defaultProps.load(in);
		in.close();
		
		DAORentalList = RentalListDAOFactory.getDAOFactory(defaultProps.getProperty("rentaltype"), defaultProps.getProperty("rentalfilepath"));
		DAOCustomerList = CustomerListDAOFactory.getDAOFactory(defaultProps.getProperty("customerstype"), defaultProps.getProperty("customerfilepath"));
		DAOMovieList = MovieListDAOFactory.getDAOFactory(defaultProps.getProperty("movietype"), defaultProps.getProperty("moviefilepath"));
	}
	
	public static RentalListDAO getRentalListDAO(){
		if(DAORentalList == null) {
			try {
				create();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return DAORentalList;
	}
	
	public static CustomerListDAO getCustomerListDAO(){
		if(DAOCustomerList == null) {
			try {
				create();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return DAOCustomerList;
	}

	public static MovieListDAO getMovieListDAO(){
		if(DAOMovieList == null) {
			try {
				create();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return DAOMovieList;
	}
}

