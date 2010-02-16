package gcb.core;
import static gcb.core.GuardConditions.isOutOfRange;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class GuardClauseTest {

	@Test(expected=GuardConditionException.class)
	public void throwException() {
		// マッチするのでArgExceptionが発生するはず
		int arg = 0;
		GuardClause.throwExceptionIf(arg, is_(0));
		fail();
	}

	@Test
	public void notThrowException() {
		// マッチしないので何も起こらないはず
		int arg = 10;
		GuardClause.throwExceptionIf(arg, is_(0));
	}

	@Test
	public void adjustedStackTrace() {
		try {
			GuardClause.throwExceptionIf(100, isOutOfRange(0, 10));
			fail();
		} catch (GuardConditionException e) {
			// stack traceはthrowExceptionIfを書いたメソッドが先頭にくるはず
			String methodNameThrownException =
				e.getStackTrace()[0].getMethodName();
			assertThat(methodNameThrownException, is("adjustedStackTrace"));
		}
	}

	// hamcrestのisと区別するために用意
	public static GuardCondition<Object> is_(final Object obj) {
		return GuardConditions.is(obj);
	}
}
