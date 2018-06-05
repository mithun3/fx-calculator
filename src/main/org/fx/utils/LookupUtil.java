package org.fx.utils;

/**
 * This is a lookup util that will be used to return the required country.
 * @author 617150
 *
 */
public class LookupUtil {
	/**
	 * 
	 * @param e
	 * @param id
	 * @return
	 */
	public static <E extends Enum<E>> E lookup(Class<E> e, String id) {
		E result = null;
		try {
			result = Enum.valueOf(e, id);
		} catch (IllegalArgumentException ex) {
			// log error or something here
			//throw new CurrencyException("Invalid value for enum ");
			result = Enum.valueOf(e, "INVALID");
		}
		return result;
	}
}
