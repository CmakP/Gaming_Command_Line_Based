/**
 * Project: A00977249Assignment1
 * File: ApplicationException.java
 * Date: May 21, 2016
 * Time: 7:45:16 PM
 */
package a00977249;

/**
 * @author Siamak Pourian, A009772249
 *
 *         ApplicationException Class
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
