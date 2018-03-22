import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author amota511
 *
 */
public class RentalSystem {

	private CustomerList customers; 
	private RentalList rentals; 
	private MovieList movies;
	private String custId;
	/**
	 * @param customers
	 * @param rentals
	 * @param movies
	 */
	public RentalSystem(CustomerList customers, RentalList rentals, MovieList movies) {
		this.customers = customers;
		this.rentals = rentals;
		this.movies = movies;
	}
	
	/**
	 * @return the custId
	 */
	public final String getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public final void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * @return the customers
	 */
	public final CustomerList getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public final void setCustomers(CustomerList customers) {
		this.customers = customers;
	}

	/**
	 * @return the rentals
	 */
	public final RentalList getRentals() {
		return rentals;
	}

	/**
	 * @param rentals the rentals to set
	 */
	public final void setRentals(RentalList rentals) {
		this.rentals = rentals;
	}

	/**
	 * @return the movies
	 */
	public final MovieList getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public final void setMovies(MovieList movies) {
		this.movies = movies;
	}

	public boolean validateCustId(String custId) {
		
		return customers.validateCustId(custId);
		
	}

	public void printAllMovies() {
		System.out.println();
		movies.printAllMovies();
	}


	public void rentCommand(String movieId){
		
		if(rentals.customerRentedMoviePrev(custId, movieId)){
			System.out.println("Movie already rented.");
		} else {
			rentals.rentMovie(custId, movieId, movies);
		}
		
	}
	
	public ArrayList<Rental> listMoviesRentedOnDate(LocalDate dateRented){
		
		ArrayList<Rental> rentalsOnDate = new ArrayList<Rental>(rentals.listMoviesRentedOnDate(dateRented));
		
		for(Rental r : rentalsOnDate) {
			System.out.println(r);
		}
		
		return rentalsOnDate;
	}
	
	public ArrayList<Rental> sortedRentalsByCustIDCommand() {
		
		ArrayList<Rental> sortedRentalsByCustID = new ArrayList<Rental>(rentals.rentalsSortedByCustID());
		
		System.out.println("Printing rentals in order sorted by Customer Id");

		for(Rental r : sortedRentalsByCustID) {
			System.out.println(r);
		}
		
		return sortedRentalsByCustID;
		
	}
	
	public ArrayList<Rental> sortedRentalsByMovieIDCommand() {
		
		
		ArrayList<Rental> sortedRentalsByMovieID = new ArrayList<Rental>(rentals.rentalsSortedByMovieID());
		
		System.out.println("Printing rentals in order sorted by Movie Id");

		for(Rental r : sortedRentalsByMovieID) {
			System.out.println(r);
		}
		
		return sortedRentalsByMovieID;
	}
	
	public int numberOfRentalsByCustomer(int custId) {
		
		 return rentals.numberOfRentalsForCustomer(custId);
	}

	public boolean validateId(String id) {
		return movies.validateId(id);
	}

	public void viewCommand(String movieId){
		
		rentals.watchMovie(custId, movieId);
		
	}
	
	public void listCommand(String custId){
		rentals.printAllRentalsforCust(custId);
	}
	
}
