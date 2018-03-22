public interface MovieListDAO {
	public void write(MovieList rl) throws DAOException;
	public MovieList read() throws DAOException;
}