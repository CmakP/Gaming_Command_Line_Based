/**
 * Project: A00977249Assignment1
 * File: EmailValidator.java
 * Date: May 21, 2016
 * Time: 7:49:57 PM
 */
package a00977249.util;

import java.util.regex.Pattern;

/**
 * @author Siamak Pourian, A009772249
 *
 *         EmailValidator Class
 */
public class EmailValidator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	/**
	 * Zero-Parameter Constructor
	 */
	private EmailValidator() {
	}

	/**
	 * Validate an email string.
	 * 
	 * @param email
	 *            the email string.
	 * @return true if the email address is valid, false otherwise.
	 */
	public static boolean validateEmail(final String email) {
		if (pattern == null) {
			pattern = Pattern.compile(EMAIL_PATTERN);
		}
		return pattern.matcher(email).matches();
	}
}
