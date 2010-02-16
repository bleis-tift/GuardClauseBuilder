package gcb.core;
import gcb.core.ArgException;

import org.junit.Test;

/**
 *
 */

/**
 * @author bleis-tift
 *
 */
public class GuardClauseTest {

	@Test(expected=ArgException.class)
	public void throwException() {
		int arg = 0;
		GuardClause.throwExceptionIf(arg, is(0));
	}

	/**
	 * @param i
	 * @return
	 */
	private Matcher is(int i) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
