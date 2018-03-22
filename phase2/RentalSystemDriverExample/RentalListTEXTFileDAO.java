import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;


public class RentalListTEXTFileDAO implements RentalListDAO{

	private String filePath;

	/**
	 * create a object that works with a file specified by a file path
	 * 
	 * @param fPath
	 *            the file path
	 */
	public RentalListTEXTFileDAO(String fPath) {
		filePath = fPath;
		System.err.println(filePath);
	}
	
	@Override
	public void write(RentalList rentals) throws DAOException {
		// TODO Auto-generated method stub
		String output = "";
		Iterator<Rental> iter = rentals.getIterator();
		while (iter.hasNext()) {
			Rental ren = iter.next();
			output += ren.toString() + "\n";
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
	public RentalList read() throws DAOException {

		RentalList rentalList = new RentalList();
		Scanner fileIn;
	    try {
			fileIn = new Scanner(new File(filePath));
		
			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
		 
				Rental ren = processRentalInputLine(line); 
		 
				rentalList.add(ren);
	    	}
			
			fileIn.close();
			
	    } catch (FileNotFoundException e) {
		    System.err.println("error reading customer file");
			e.printStackTrace();
		}
		
		return rentalList;
	}
	private static Rental processRentalInputLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("\\|");
		String id = lineScanner.next();
		String custId = lineScanner.next();
		String movieId = lineScanner.next();
		LocalDateTime dateTimeRented = LocalDateTime.parse(lineScanner.next());	 
		String title = lineScanner.next();
		String hasBeenViewed = lineScanner.next();

	    Rental ren = new Rental(id, custId, movieId, dateTimeRented, title, hasBeenViewed);
		 		 
		lineScanner.close();
		return ren;
	}

}
