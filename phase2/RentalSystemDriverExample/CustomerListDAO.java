public interface CustomerListDAO {
	
	public void write(CustomerList rl) throws DAOException;
	public CustomerList read() throws DAOException;
}
