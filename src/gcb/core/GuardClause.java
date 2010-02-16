/**
 *
 */
package gcb.core;

/**
 * @author bleis-tift
 *
 */
public final class GuardClause {

	/**
	 * @param arg
	 * @param object
	 */
	public static void throwExceptionIf(Object arg, Matcher matcher) {
		throw new ArgException();
	}

}
