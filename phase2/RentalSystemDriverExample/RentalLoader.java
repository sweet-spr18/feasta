import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class RentalLoader {

	
	RentalSystem system;
	AdminMenu AdMenu;
	CustomerMenu menu;
	
	public RentalLoader(String filesType) {

		
		CustomerList customers = loadCustomers(filesType);
		MovieList movies = loadMovies(filesType);
		RentalList rentals = loadRentalRecords(filesType);
		system = new RentalSystem(customers, rentals, movies);
		
		menu = new CustomerMenu(system);

		AdMenu = new AdminMenu(system);
		
		AdMenu.system.setCustId("5");
		menu.system.setCustId("5");
	}
	
	private static MovieList loadMovies(String filesType) {
		MovieList movies = new MovieList();
		Scanner fileIn;
		try {
			fileIn = new Scanner(new File(filesType + "movies.txt"));


			while (fileIn.hasNextLine())
			{

				String line = fileIn.nextLine();

				Movie movie = processMovieInputLine(line);

				movies.add(movie);
			}
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error reading movie file");
			e.printStackTrace();
		}

		return movies;
	}

	private static Movie processMovieInputLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("\\|");
		String id = lineScanner.next();
		String title = lineScanner.next();	 
		String category = lineScanner.next();
		String rating = lineScanner.next();
		Movie movie = new Movie(id, title, category, rating);

		lineScanner.close();
		return movie;
	}

	private static RentalList loadRentalRecords(String filesType) {
		RentalList rentalList = new RentalList();
		Scanner fileIn;
		try {
			fileIn = new Scanner(new File(filesType + "rentals.txt"));

			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();

				Rental ren = processRentalInputLine(line); 

				rentalList.add(ren);
			}

			fileIn.close();

		} catch (FileNotFoundException e) {
			System.err.println("error reading customer file");
			e.printStackTrace();
		}

		return rentalList;
	}

	private static Rental processRentalInputLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("\\|");
		String id = lineScanner.next();
		String custId = lineScanner.next();
		String movieId = lineScanner.next();
		LocalDateTime dateTimeRented = LocalDateTime.parse(lineScanner.next());	 
		String title = lineScanner.next();
		String hasBeenViewed = lineScanner.next();

		Rental ren = new Rental(id, custId, movieId, dateTimeRented, title, hasBeenViewed);

		lineScanner.close();
		return ren;
	}

	private static Customer processCustomerInputLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("\\|");
		String id = lineScanner.next();
		String fname = lineScanner.next();	 
		String lname = lineScanner.next();

		Customer cust = new Customer(lname, fname, id);

		lineScanner.close();
		return cust;
	}

	private static CustomerList loadCustomers(String filesType) {
		CustomerList custList = new CustomerList();
		Scanner fileIn;
		try {
			fileIn = new Scanner(new File(filesType + "customers.txt"));

			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();

				Customer cust = processCustomerInputLine(line);

				custList.add(cust);
			}

			fileIn.close();

		} catch (FileNotFoundException e) {
			System.err.println("error reading customer file");
			e.printStackTrace();
		}

		return custList;
	}
}
