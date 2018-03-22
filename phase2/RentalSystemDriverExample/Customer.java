
public class Customer {

	private String lname, fname, id;
	
	/**
	 * @param lname
	 * @param fname
	 * @param id
	 */
	public Customer(String lname, String fname, String id) {
		this.lname = lname; 
		this.fname = fname;
		this.id = id;
	}
	
	public void printInfo() {
		System.out.println(fname + " " + lname + " has id number " + id);
	}

	/**
	 * @return the lname
	 */
	public final String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public final void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the fname
	 */
	public final String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public final void setFname(String fname) {
		this.fname = fname;
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
	
	public String toString() {
		//1|10|1|2017-09-17T17:49:46.616|The Red Shoes|already viewed
		return id + "|" + fname + "|" + lname;
	}

}
