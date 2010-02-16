package gcb.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StackTraceUtilTest {

	@Test
	public void testRemoveTopStackTraceElement() {
		try {
			internalMethod();
			fail();
		} catch (Exception e) {
			e = StackTraceUtil.removeTopStackTraceElement(e);
			// スタックトレースの先頭(internalMethod)が削除され、
			// このメソッド自身(testRemoveTopStackTraceElement)が先頭に来るはず
			String topMethodName =
				e.getStackTrace()[0].getMethodName();
			assertThat(topMethodName, is("testRemoveTopStackTraceElement"));
		}
	}

	private void internalMethod() {
		throw new RuntimeException();
	}
}
