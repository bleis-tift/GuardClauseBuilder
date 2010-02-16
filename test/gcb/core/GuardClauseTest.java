package gcb.core;
import static org.junit.Assert.fail;

import org.junit.Test;

public class GuardClauseTest {

	@Test(expected=GuardConditionException.class)
	public void throwException() {
		// マッチするのでArgExceptionが発生するはず
		int arg = 0;
		GuardClause.throwExceptionIf(arg, is(0));
		fail();
	}

	@Test
	public void notThrowException() {
		// マッチしないので何も起こらないはず
		int arg = 10;
		GuardClause.throwExceptionIf(arg, is(0));
	}

	// テスト用のMatcher
	private GuardCondition is(final Object obj) {
		return new GuardCondition() {
			public boolean match(Object arg) {
				if (obj == null)
					return arg == null;
				return obj.equals(arg);
			}
		};
	}
}
