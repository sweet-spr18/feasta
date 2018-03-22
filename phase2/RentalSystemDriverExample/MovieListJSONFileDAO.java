import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MovieListJSONFileDAO implements MovieListDAO {

	private String filePath;
	
	public MovieListJSONFileDAO(String filePath) {
		// TODO Auto-generated constructor stub
		this.filePath = filePath;
		System.err.println(filePath);
	}

	@Override
	public void write(MovieList movs) throws DAOException {
		// TODO Auto-generated method stub
		JSONObject finalObj = new JSONObject();
		JSONArray list = new JSONArray();
		Iterator<Movie> iter = movs.getIterator();
		while (iter.hasNext()) {
			Movie mov = iter.next();
			JSONObject obj = new JSONObject();
			obj.put("id", mov.getId());
			obj.put("title", mov.getTitle());
			obj.put("category", mov.getCategory());
			obj.put("rating", mov.getRating());
			list.add(obj);
		}

		finalObj.put("movies", list);

		try {
			FileWriter outFile = new FileWriter(new File(filePath));
			outFile.write(finalObj.toJSONString());
			outFile.close();
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public MovieList read() throws DAOException {
		// TODO Auto-generated method stub
		MovieList movieList = new MovieList();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader(filePath);

			// the JSONObject represents everything in the file
			JSONObject jsonMovieInfo = (JSONObject) jsonParser.parse(reader);
			JSONArray jsonMovieList = (JSONArray) jsonMovieInfo.get("movies");
			Iterator movieIter = jsonMovieList.iterator();
			
			while (movieIter.hasNext()) {
				
				JSONObject jsonMovie = (JSONObject) movieIter.next();
				
				String id = (String) jsonMovie.get("id");
				String title = ((String) jsonMovie.get("title"));
				String category = ((String) jsonMovie.get("category"));
				String rating = ((String) jsonMovie.get("rating"));
				
				Movie movieRec = new Movie(id, title, category, rating);
				
				movieList.add(movieRec);
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} catch (ParseException e) {
			throw new DAOException(e);
		}
		return movieList;
	}
}
