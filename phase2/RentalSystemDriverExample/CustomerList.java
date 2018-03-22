import java.util.ArrayList;
import java.util.Iterator;

public class CustomerList {

	private ArrayList<Customer> customerList;
	
	
	public CustomerList() {
		this.customerList = new ArrayList<Customer>();
	}


	public void add(Customer cust) {
		if(cust == null){
			System.out.println("Cant add a null customer.");
			return;
		}
		this.customerList.add(cust);
		//System.out.println(cust.getFname() + " added to customer list.");
	}
	
	public Iterator<Customer> getIterator() {
		return new CustomerListIter();
	}
	
	private class CustomerListIter implements Iterator<Customer>{
		int cursor;
		ArrayList<Customer> theList;
		
		public CustomerListIter() {
			cursor = 0;
			theList = new ArrayList<Customer>(customerList);
		}
		
		public boolean hasNext() {
			if(cursor < theList.size()) {
				return true;
			} else {
				return false;
			}
		}
		
		public Customer next() {
			if(hasNext()) {
				Customer elm = theList.get(cursor);
				cursor++;
				return elm ;
			} else {
				return null;
			}
		}
	}

	public void printAllCustomers() {
		for(Customer cust : customerList) {
			cust.printInfo();
		}
	}

	public String getFnameForCustomer(String custId) {
		for(Customer cust : customerList){
			if (cust.getId().equals(custId)) return cust.getFname();
		}
		return null;
	}

	public boolean validateCustId(String custId) {
		for(Customer cust : customerList){
			if (cust.getId().equals(custId)) return true;
		}
		return false;
	}
}
