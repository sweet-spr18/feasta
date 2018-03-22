/**
 * An exception class for the DAO classes
 * DAOExceptions will wrap the more specific exceptions
 * that may be thrown by the specific kind of persistence
 * mechanism
 * @author Bonnie MacKellar
 *
 */
public class DAOException extends Exception {

	public DAOException() {
		super();
	}

	public DAOException(String str) {
		super(str);
		
	}

	public DAOException(Throwable cause) {
		super(cause);
		
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}


}
