import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RentalSystemTest {

	RentalLoader origRenSys;
	RentalLoader testRenSys;
	
	@Before
	public void setUp() throws Exception {
		
		origRenSys = new RentalLoader("");
		testRenSys = new RentalLoader("/Users/amota511/git/cus1156fall2017project1motayne/Fall2017Project1/TestFiles/");
		
	}

	@Test
	public void testListMoviesRentedOnDate() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		LocalDate dateRented = LocalDate.parse("10/17/2017", formatter);
		
		ArrayList<Rental> origResult = origRenSys.system.listMoviesRentedOnDate(dateRented);
		ArrayList<Rental> testResult = testRenSys.system.listMoviesRentedOnDate(dateRented);
		
		for(int i = 0; i < origResult.size(); i++){
			
			if(!(origResult.get(i).equals(testResult.get(i)))){
				fail("List Movies Rented On Date failed.");
			}
			
		}
	}

	@Test
	public void testSortedRentalsByCustIDCommand() {
		
		ArrayList<Rental> origResult = origRenSys.system.sortedRentalsByCustIDCommand();
		ArrayList<Rental> testResult = testRenSys.system.sortedRentalsByCustIDCommand();
		
		for(int i = 0; i < origResult.size(); i++){
			
			if(!(origResult.get(i).equals(testResult.get(i)))) {
				fail("Sorted Rentals By Cust ID failed.");
			}
			
		}
	}

	@Test
	public void testSortedRentalsByMovieIDCommand() {
		
		ArrayList<Rental> origResult = origRenSys.system.sortedRentalsByMovieIDCommand();
		ArrayList<Rental> testResult = testRenSys.system.sortedRentalsByMovieIDCommand();
		
		for(int i = 0; i < origResult.size(); i++) {
			
			if(!(origResult.get(i).equals(testResult.get(i)))){
				fail("Sorted Rentals By Movie ID failed.");
			}
			
		}
	}

	@Test
	public void testNumberOfRentalsByCustomer() {
		
		int origResult = origRenSys.system.numberOfRentalsByCustomer(5);
		int testResult = testRenSys.system.numberOfRentalsByCustomer(5);
		
		assertTrue(origResult == testResult);
	}

}
