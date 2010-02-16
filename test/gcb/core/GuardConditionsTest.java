package gcb.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class GuardConditionsTest {

	@Test
	public void testIs() {
		assertThat(GuardConditions.is(0).match(0), is(true));
	}
}
