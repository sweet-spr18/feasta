import java.util.Scanner;

public class RentalSystemDriver {


	public static void main(String[] args) throws DAOException {
		AdminMenu AdMenu;
		CustomerMenu menu;
		
		CustomerListDAO customersDAO = DAOManger.getCustomerListDAO();
		CustomerList customers = customersDAO.read();
	    customers.printAllCustomers();
	    
	    MovieListDAO moviesDAO = DAOManger.getMovieListDAO();
	    MovieList movies = moviesDAO.read();
	    
	    RentalListDAO rentalsDAO = DAOManger.getRentalListDAO();
	    RentalList rentals = rentalsDAO.read();
	    
	    RentalSystem system = new RentalSystem(customers, rentals, movies);
	    System.out.println("What type of user are you? Type c for customer or a for administrator");
	    Scanner in = new Scanner(System.in);
	    char type = in.nextLine().charAt(0);
	    if (type == 'c' || type == 'C')
	    {
	        menu = new CustomerMenu(system);
	        menu.run();
	    }
	    else if (type == 'a' || type == 'A')
	    {
	    	AdMenu = new AdminMenu(system);
	    	AdMenu.run();
	    }
        in.close();
	}

}
