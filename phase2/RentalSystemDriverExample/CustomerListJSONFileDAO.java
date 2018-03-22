import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CustomerListJSONFileDAO implements CustomerListDAO {

	private String filePath;

	/**
	 * create a object that works with a file specified by a file path
	 * 
	 * @param fPath
	 *            the file path
	 */
	public CustomerListJSONFileDAO(String fPath) {
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
	public void write(CustomerList custs) throws DAOException {
		JSONObject finalObj = new JSONObject();
		JSONArray list = new JSONArray();
		Iterator<Customer> iter = custs.getIterator();
		while (iter.hasNext()) {
			Customer cus = iter.next();
			JSONObject obj = new JSONObject();
			obj.put("id", cus.getId());
			obj.put("fname", cus.getFname());
			obj.put("lname", cus.getLname());
			list.add(obj);
		}

		finalObj.put("customers", list);

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
	public CustomerList read() throws DAOException {
		CustomerList customerList = new CustomerList();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader(filePath);

			// the JSONObject represents everything in the file
			JSONObject jsonCustomerInfo = (JSONObject) jsonParser.parse(reader);
			JSONArray jsonCustomerList = (JSONArray) jsonCustomerInfo.get("customers");
			Iterator customerIter = jsonCustomerList.iterator();
			
			while (customerIter.hasNext()) {
				
				JSONObject jsonCustomer = (JSONObject) customerIter.next();


				String id = (String) jsonCustomer.get("id");
				String fname = ((String) jsonCustomer.get("fname"));
				String lname = ((String) jsonCustomer.get("lname"));
				
				Customer customerRec = new Customer(id, fname, lname);
				
				customerList.add(customerRec);
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		} catch (ParseException e) {
			throw new DAOException(e);
		}
		return customerList;
	}
}
