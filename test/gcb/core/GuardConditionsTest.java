/**
 *
 */
package gcb.core;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author bleis-tift
 *
 */
public class GuardConditionsTest {

	@Test
	public void testIs() {
		assertThat(GuardConditions.is(0).match(0), is(true));
		assertThat(GuardConditions.is(1).match(0), is(false));
		// 両方nullならtrue
		assertThat(GuardConditions.is(null).match(null), is(true));
		// 一方のみnullならfalse
		assertThat(GuardConditions.is(null).match(10), is(false));
		assertThat(GuardConditions.is(10).match(null), is(false));
	}
}
