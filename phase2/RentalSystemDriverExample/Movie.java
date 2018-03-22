
/**
 * @author amota511
 *
 */
public class Movie {

	private String id, title, category, rating;
	
	/**
	 * @param id
	 * @param title
	 * @param category
	 * @param rating
	 */
	public Movie(String id, String title, String category, String rating) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.rating = rating;
	}
	
	public void printInfo() {
		System.out.println(id + " " + title + " " + rating);
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
	 * @return the category
	 */
	public final String getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public final void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return the rating
	 */
	public final String getRating() {
		return rating;
	}
	
	/**
	 * @param rating the rating to set
	 */
	public final void setRating(String rating) {
		this.rating = rating;
	}

}
