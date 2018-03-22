import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author amota511
 *
 */
public class Rental {

	private String id;
	private String custId;
	private String movieId;
	private LocalDateTime dateTimeRented;
	private String title;
	private String hasBeenViewed;
	
	/**
	 * @param id
	 * @param dateTimeRented
	 * @param title
	 * @param hasBeenViewed
	 */
	public Rental(String id, String custId, String movieId, LocalDateTime dateTimeRented, String title, String hasBeenViewed) {
		this.id = id;
		this.custId = custId;
		this.movieId = movieId;
		this.dateTimeRented = dateTimeRented;
		this.title = title;
		this.hasBeenViewed = hasBeenViewed;
	}
	
	public boolean compareRentalDate(LocalDate dateRented) {
		
		return dateTimeRented.toLocalDate().equals(dateRented);
	}
	
	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the dateTimeRented
	 */
	public final LocalDateTime getDateTimeRented() {
		return dateTimeRented;
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
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	/**
	 * @param dateTimeRented the dateTimeRented to set
	 */
	public final void setDateTimeRented(LocalDateTime dateTimeRented) {
		this.dateTimeRented = dateTimeRented;
	}
	
	/**
	 * @return the title
	 */
	public final String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public final void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the hasBeenViewed
	 */
	public final String getHasBeenViewed() {
		return hasBeenViewed;
	}
	
	/**
	 * @param hasBeenViewed the hasBeenViewed to set
	 */
	public final void setHasBeenViewed(String hasBeenViewed) {
		this.hasBeenViewed = hasBeenViewed;
	}

	public void printInfo() {
		System.out.println(title + " was rented on " + dateTimeRented + " with rental system id " + id + " and " + hasBeenViewed);
		
	}

	public String toString() {
		//1|10|1|2017-09-17T17:49:46.616|The Red Shoes|already viewed
		return id + "|" + custId + "|" + movieId + "|" + dateTimeRented + "|" + title + "|" + hasBeenViewed;
	}
	
	public boolean equals(Rental r2) {
		
		if(!r2.custId.equals(custId)) return false;
		if(!r2.dateTimeRented.equals(dateTimeRented)) return false;
		if(!r2.hasBeenViewed.equals(hasBeenViewed)) return false;
		if(!r2.movieId.equals(movieId)) return false;
		if(!r2.title.equals(title)) return false;
		if(!r2.id.equals(id)) return false;

		return true;
	}
	
}
