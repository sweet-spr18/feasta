import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class CustomerListTEXTFileDAO implements CustomerListDAO{

	private String filePath;

	/**
	 * create a object that works with a file specified by a file path
	 * 
	 * @param fPath
	 *            the file path
	 */
	public CustomerListTEXTFileDAO(String fPath) {
		filePath = fPath;
		System.err.println(filePath);
	}

	@Override
	public void write(CustomerList custs) throws DAOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String output = "";
				Iterator<Customer> iter = custs.getIterator();
				while (iter.hasNext()) {
					Customer ren = iter.next();
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
	public CustomerList read() throws DAOException {
			CustomerList custList = new CustomerList();
			Scanner fileIn;
		    try {
				fileIn = new Scanner(new File(filePath));
			
				while (fileIn.hasNextLine()) {
					String line = fileIn.nextLine();
			 
					Customer cust = processCustomerInputLine(line);
			 
					custList.add(cust);
		    	}
				
				fileIn.close();
				
		    } catch (FileNotFoundException e) {
			    System.err.println("error reading customer file");
				e.printStackTrace();
			}
			
			return custList;
		}
		
		private static Customer processCustomerInputLine(String line) {
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter("\\|");
			String id = lineScanner.next();
			String fname = lineScanner.next();	 
			String lname = lineScanner.next();

		    Customer cust = new Customer(lname, fname, id);
			 		 
			lineScanner.close();
			return cust;
		}
		
}