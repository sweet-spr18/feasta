public interface RentalListDAO {
	public void write(RentalList rl) throws DAOException;
	public RentalList read() throws DAOException;
}
