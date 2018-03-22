import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class RentalList {

private ArrayList<Rental> rentalList;
	
	
	public RentalList() {
		this.rentalList = new ArrayList<Rental>();
	}

	public ArrayList<Rental> listMoviesRentedOnDate(LocalDate dateRented){
		
		ArrayList<Rental> rentalsOnDate = new ArrayList<Rental>();
		
		for(Rental r : rentalList) {
			if (r.compareRentalDate(dateRented)) {
				rentalsOnDate.add(r);
			}
		}
		
		return rentalsOnDate;
	}
	
	public void add(Rental ren) {
		if(ren == null){
			System.out.println("Cant add a null Rental.");
			return;
		}
		
		this.rentalList.add(ren);
		updateRecords();
	}

	public void printAllRentalsforCust(String custId) {
		for(Rental ren : rentalList) {
			if(ren.getCustId().equals(custId)) System.out.println(ren.toString());
		}
	}
	
	public boolean customerRentedMoviePrev(String custId, String movieId) {
		
		for(Rental ren : rentalList) {
			if(ren.getCustId().equals(custId) && ren.getMovieId().equals(movieId)) return true;
		}
		return false;
	}
	
	public void rentMovie(String custId, String movieId, MovieList movies) {

		Rental ren = new Rental(String.valueOf(rentalList.size() + 1),custId, movieId, LocalDateTime.now(), movies.getTitleForId(movieId), "not yet viewed");
		
		rentalList.add(ren);
		
		updateRecords();
			
	}
	
	public void updateRecords() {
		RentalListDAO rDAO = DAOManger.getRentalListDAO();
		try {
			rDAO.write(this);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean watchMovie(String custId, String movieId) {
		for(Rental ren : rentalList) {
			if(ren.getCustId().equals(custId) && ren.getMovieId().equals(movieId)) {
				if(ren.getHasBeenViewed().equals("not yet viewed")) {
					ren.setHasBeenViewed("already viewed");
					System.out.println("Once viewed, the movie will no longer be available");
					updateRecords();
					return true;
				} else {
					System.out.println("Movie is not available to view");
					return false;
				}
			}
		}
		System.out.println("Movie is not available to view");
		return false;
	}
	
	public Iterator<Rental> getIterator() {
		return new RentalListIter();
	}
	
	private class RentalListIter implements Iterator<Rental>{
		int cursor;
		ArrayList<Rental> theList;
		
		public RentalListIter() {
			cursor = 0;
			theList = new ArrayList<Rental>(rentalList);
		}
		
		public boolean hasNext() {
			if(cursor < theList.size()) {
				return true;
			} else {
				return false;
			}
		}
		
		public Rental next() {
			if(hasNext()) {
				Rental elm = theList.get(cursor);
				cursor++;
				return elm ;
			} else {
				return null;
			}
		}
	}
	
	public ArrayList<Rental> rentalsSortedByCustID() {
		
		ArrayList<Rental> sortedRentals = new ArrayList<Rental>(rentalList);
		
		Collections.sort(sortedRentals, new Comparator<Rental>() {
			
			public int compare(Rental r1, Rental r2) {
				
				return r1.getCustId().compareTo(r2.getCustId());
				
			}
		});
		
		return sortedRentals;
	}
	
	public ArrayList<Rental> rentalsSortedByMovieID() {
		
		ArrayList<Rental> sortedRentals = new ArrayList<Rental>(rentalList);
		
		Collections.sort(sortedRentals, new Comparator<Rental>() {
			
			public int compare(Rental r1, Rental r2) {
				
				return r1.getMovieId().compareTo(r2.getMovieId());
				
			}
		});
				
		return sortedRentals;
	}
	
	public int numberOfRentalsForCustomer(int custId) {
		
		int numOfRentals = 0;
		
		for(Rental r : rentalList){
			
			int custIdOfRental = Integer.parseInt(r.getCustId());
			
			if(custIdOfRental == custId) numOfRentals++;
		}
		
		System.out.println("The customer with Id " + custId + " has rented " + numOfRentals + " movies.");
		
		return numOfRentals;
	}

}
