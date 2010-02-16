package gcb.core;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import gcb.core.GuardConditionException;

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
			GuardClause.throwExceptionIf(0, is_(0));
			fail();
		} catch (GuardConditionException e) {
			// stack traceはthrowExceptionIfを書いたメソッドが先頭にくるはず
			String methodNameThrownException =
				e.getStackTrace()[0].getMethodName();
			assertThat(methodNameThrownException, is("adjustedStackTrace"));
		}
	}

	public static GuardCondition is_(final Object obj) {
		return GuardClause.is(obj);
	}
}
