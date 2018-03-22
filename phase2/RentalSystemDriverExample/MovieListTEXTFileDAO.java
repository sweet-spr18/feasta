import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class MovieListTEXTFileDAO implements MovieListDAO {

	private String filePath;

	/**
	 * create a object that works with a file specified by a file path
	 * 
	 * @param fPath
	 *            the file path
	 */
	public MovieListTEXTFileDAO(String fPath) {
		filePath = fPath;
		System.err.println(filePath);
	}

	@Override
	public void write(MovieList movs) throws DAOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String output = "";
				Iterator<Movie> iter = movs.getIterator();
				while (iter.hasNext()) {
					Movie mov = iter.next();
					output += mov.toString() + "\n";
				}

				try {
					FileWriter outFile = new FileWriter(new File(filePath));
					outFile.write(output);
					outFile.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
	}

	@Override
	public MovieList read() throws DAOException {
		MovieList movies = new MovieList();
		Scanner fileIn;
	    try {
			fileIn = new Scanner(new File(filePath));
		
		
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

	private Movie processMovieInputLine(String line) {
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
}

