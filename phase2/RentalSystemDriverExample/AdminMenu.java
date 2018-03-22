import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AdminMenu {

	RentalSystem system;
	Scanner in;
	//LocalDateTime dateRented = LocalDateTime.parse(dateStr, formatter);
	
	public AdminMenu(RentalSystem system) {
		this.system = system;
	}
	
	public void run() {
		System.out.println("Welcome to the movie administration system");
		
		commandPrompt();
	}
	
	public void commandPrompt() {
		
		in = new Scanner(System.in);
		
		while(true){
			
			printCommands();
			
			char command = in.next().charAt(0);
			
			boolean isValidCommand = validateAdminCommand(command);
			
			while(isValidCommand == false) {
				System.out.println("Invalid command.");
				printCommands();
				
				command = in.next().charAt(0);
				isValidCommand = validateAdminCommand(command);
			}
			
			if (command == 'Q' || command == 'q') {
				System.out.println("bye.");
				in.close();
				return;
			}
			
			executeCommand(command);
		}
		
	}
	
	public boolean validateAdminCommand(char command) { 
		switch(command) {
		case 'L': return true;
		case 'C': return true;
		case 'M': return true;
		case 'N': return true;
		case 'Q': return true;
		case 'l': return true;
		case 'c': return true;
		case 'm': return true;
		case 'n': return true;
		case 'q': return true;
		default : return false;
		}
	}
	
	public void executeCommand(char c) {
		switch(c) {
		case 'L': listForDateCommand(); break;
		case 'C': sortedRentalsByCustIDCommand(); break;
		case 'M': sortedRentalsByMovIDCommand(); break;
		case 'N': numTimesCustHasRentedMoviesCommand(); break;
		case 'l': listForDateCommand(); break;
		case 'c': sortedRentalsByCustIDCommand(); break;
		case 'm': sortedRentalsByMovIDCommand(); break;
		case 'n': numTimesCustHasRentedMoviesCommand(); break;
		default : return;
		}
		
	}
	
	public void listForDateCommand() {
		
		System.out.println("Please enter a date in the format MM/DD/YYYY");
		
		String dateStr = in.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		LocalDate dateRented = LocalDate.parse(dateStr, formatter);
		
		system.listMoviesRentedOnDate(dateRented);
	}
	
	public void sortedRentalsByCustIDCommand() {
		
		system.sortedRentalsByCustIDCommand();
	}
	
	public void sortedRentalsByMovIDCommand() {
		
		system.sortedRentalsByMovieIDCommand();
		
	}
	
	public void numTimesCustHasRentedMoviesCommand() {
		
		System.out.println("Please enter a customer Id");
		
		int custId = in.nextInt();
		
		system.numberOfRentalsByCustomer(custId);
	}
	
	
	public void printCommands() {
		System.out.println();
		System.out.println("Please enter a command");
		System.out.println("L: list all rentals for a given date");
		System.out.println("C: list all rentals sorted by customerID");
		System.out.println("M: list all rentals sorted by movieID");
		System.out.println("N: list number of times a customer has rented movies");
		System.out.println("Q: quit");
		System.out.println(">>>>>>");
		
	}
}
