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

/**
 * A data access object class that persists RentalList to and from a JSON file.
 * 
 * @author Bonnie MacKellar
 *
 */
public class RentalListJSONFileDAO implements RentalListDAO {

	private String filePath;

	/**
	 * create a object that works with a file specified by a file path
	 * 
	 * @param fPath
	 *            the file path
	 */
	public RentalListJSONFileDAO(String fPath) {
		filePath = fPath;
		System.err.println(filePath);
	}

	/**
	 * write a rental list to a JSON file
	 * 
	 * @throws DAOException
	 *             if the file path is incorrect
	 */
	@Override
	public void write(RentalList rentals) throws DAOException {
		JSONObject finalObj = new JSONObject();
		JSONArray list = new JSONArray();
		Iterator<Rental> iter = rentals.getIterator();
		while (iter.hasNext()) {
			Rental rec = iter.next();
			JSONObject obj = new JSONObject();
			obj.put("id", rec.getId());
			obj.put("movieId", rec.getMovieId());
			obj.put("custId", rec.getCustId());
			LocalDateTime dt = rec.getDateTimeRented();
			obj.put("datetime", dt.toString());
			obj.put("hasBeenViewed", rec.getHasBeenViewed());
			obj.put("title", rec.getTitle());
			list.add(obj);
		}
		
		finalObj.put("rentals", list);

		try {
			FileWriter outFile = new FileWriter(new File(filePath));
			outFile.write(finalObj.toJSONString());
			outFile.close();
		} catch (IOException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * Reads a list of rental records from a JSON formatted file
	 * 
	 * @throws DAOException
	 *             if anything goes wrong when reading the file, including a non
	 *             existent file path or a parse error while reading.
	 */
	@Override
	public RentalList read() throws DAOException {
		RentalList rentalList = new RentalList();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader(filePath);

			// the JSONObject represents everything in the file
			JSONObject jsonRentalInfo = (JSONObject) jsonParser.parse(reader);
			JSONArray jsonRentalList = (JSONArray) jsonRentalInfo.get("rentals");
			Iterator rentalIter = jsonRentalList.iterator();
			
			while (rentalIter.hasNext()) {
				
				JSONObject jsonRental = (JSONObject) rentalIter.next();
				String id = (String) jsonRental.get("id");
				String custId = (String) jsonRental.get("custId");
				String movId = (String) jsonRental.get("movieId");
				
				
				String dateStr = ((String) jsonRental.get("datetime"));
				
				DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
				LocalDateTime dateRented = LocalDateTime.parse(dateStr, formatter);
				
				String title = ((String) jsonRental.get("title"));
				String hasBeenViewed = (String) jsonRental.get("hasBeenViewed");
				
				Rental rentalRec = new Rental(id, movId, custId, dateRented, title, hasBeenViewed);
				rentalList.add(rentalRec);
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} catch (ParseException e) {
			throw new DAOException(e);
		}
		return rentalList;
	}
}
