package gcb.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

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

	@Test
	public void test() {
		// nullはもちろんtrue
		assertThat(GuardConditions.isNullOrEmpty().match(null), is(true));
		// 空文字列はtrue、空白だけだとしても空じゃなければfalse
		assertThat(GuardConditions.isNullOrEmpty().match(""), is(true));
		assertThat(GuardConditions.isNullOrEmpty().match(" "), is(false));
		// 空のStringBuilderもtrue
		assertThat(GuardConditions.isNullOrEmpty().match(new StringBuilder()), is(true));
		// 空の配列はtrue、そうじゃなければfalse
		assertThat(GuardConditions.isNullOrEmpty().match(new int[0]), is(true));
		assertThat(GuardConditions.isNullOrEmpty().match(new int[] { 1 }), is(false));
		// 空のコレクションもtrue、そうじゃなければfalse
		assertThat(GuardConditions.isNullOrEmpty().match(Collections.EMPTY_LIST), is(true));
		assertThat(GuardConditions.isNullOrEmpty().match(Arrays.asList(1)), is(false));
		// 数値は問答無用でfalse
		assertThat(GuardConditions.isNullOrEmpty().match(0), is(false));
	}

	@Test
	public void testIsFromTo() {
		assertThat(GuardConditions.isOutOfRange(0, 10).match(100), is(true));
	}
}
