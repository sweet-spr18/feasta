import java.util.ArrayList;
import java.util.Iterator;

public class MovieList {

private ArrayList<Movie> movieList;
	
	
	public MovieList() {
		this.movieList = new ArrayList<Movie>();
	}


	public void add(Movie mov) {
		if(mov == null){
			System.out.println("Cant add a null Movie.");
			return;
		}
		
		this.movieList.add(mov);
		//System.out.println(mov.getTitle() + " was added to the movie list.");
	}

	public void printAllMovies() {
		for(Movie mov : movieList) {
			mov.printInfo();
		}
	}
	
	public Iterator<Movie> getIterator() {
		return new MovieListIter();
	}
	
	private class MovieListIter implements Iterator<Movie>{
		int cursor;
		ArrayList<Movie> theList;
		
		public MovieListIter() {
			cursor = 0;
			theList = new ArrayList<Movie>(movieList);
		}
		
		public boolean hasNext() {
			if(cursor < theList.size()) {
				return true;
			} else {
				return false;
			}
		}
		
		public Movie next() {
			if(hasNext()) {
				Movie elm = theList.get(cursor);
				cursor++;
				return elm ;
			} else {
				return null;
			}
		}
	}

	public boolean validateId(String id) {
		
		for(Movie mov : movieList) {
			if(mov.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public String getTitleForId(String id) {
		
		for(Movie mov : movieList) {
			if(mov.getId().equals(id)) {
				return mov.getTitle();
			}
		}
		return null;
	}

}
