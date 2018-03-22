import java.util.Scanner;

public class CustomerMenu {

	RentalSystem system;
	Scanner in;
	String custId;

	public CustomerMenu(RentalSystem system) {
		this.system = system;
		this.in = new Scanner(System.in);
	}

	public void run() {

		customerPrompt();

		printAllMovies();

		commandPrompt();

	}

	public void customerPrompt() {
		in = new Scanner(System.in);
		System.out.println("Please enter your customer number");

		custId = in.next();
		boolean isValidCustId = system.validateCustId(custId);

		while (isValidCustId == false) {
			System.out.println("Incorrect customer number.");

			System.out.println("Please enter your customer number");

			custId = in.next();
			isValidCustId = system.validateCustId(custId);
		}

		system.setCustId(custId);

		System.out.println("Hello, " + system.getCustomers().getFnameForCustomer(custId));

	}

	public void commandPrompt() {

		while (true) {

			printCommands();

			char command = in.next().charAt(0);

			boolean isValidCommand = validateCommand(command);

			while (isValidCommand == false) {
				System.out.println("Invalid command.");
				printCommands();

				command = in.next().charAt(0);
				isValidCommand = validateCommand(command);
			}

			if (command == 'Q' || command == 'q') {
				System.out.println("bye.");
				in.close();
				return;
			}

			executeCommand(command);
		}

	}

	public boolean validateCommand(char command) {

		switch (command) {
		case 'R':
			return true;
		case 'r':
			return true;
		case 'V':
			return true;
		case 'v':
			return true;
		case 'L':
			return true;
		case 'l':
			return true;
		case 'Q':
			return true;
		case 'q':
			return true;
		default:
			return false;
		}

	}

	public void printAllMovies() {
		system.printAllMovies();
	}

	public void printCommands() {
		System.out.println(" ");
		System.out.println("Please enter a command");
		System.out.println("R: rent a movie to be watched now or later");
		System.out.println("V: watch a movie");
		System.out.println("L: list my rentals");
		System.out.println("Q: quit");
		System.out.println(">>>>>>");

	}

	public void executeCommand(char c) {
		switch (c) {
		case 'R':
			rentCommand();
			break;
		case 'r':
			rentCommand();
			break;
		case 'V':
			viewCommand();
			break;
		case 'v':
			viewCommand();
			break;
		case 'L':
			system.listCommand(custId);
			break;
		case 'l':
			system.listCommand(custId);
			break;
		default:
			return;
		}

	}

	public void viewCommand() {
		System.out.println("Enter the movie id");

		String id = in.next();

		boolean isValidId = system.validateId(id);

		while (isValidId == false) {
			System.out.println("Movie can not be rented.");

			System.out.println("Enter the movie id");
			id = in.next();
			isValidId = system.validateId(id);
		}
		system.viewCommand(id);
	}

	public void rentCommand() {
		System.out.println("Enter the movie id");

		String movieId = in.next();

		boolean isValidId = system.validateId(movieId);

		while (isValidId == false) {
			System.out.println("Movie can not be rented.");

			System.out.println("Enter the movie id");
			movieId = in.next();
			isValidId = system.validateId(movieId);
		}

		system.rentCommand(movieId);
	}

}
