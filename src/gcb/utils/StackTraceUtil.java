package gcb.utils;

import java.util.Arrays;

/**
 * スタックトレースに関するユーティリティクラスです。
 * @author bleis-tift
 */
public final class StackTraceUtil {

	/**
	 * 引数で与えられた例外オブジェクトの先頭からスタックトレースを一つ削除します。
	 * @param e スタックトレースの先頭を削除する例外オブジェクト
	 * @return 引数自身
	 */
	public static <X extends Throwable> X removeTopStackTraceElement(X e) {
		// http://d.hatena.ne.jp/katzchang/20080820/p2
		e.setStackTrace(
				Arrays.asList(e.getStackTrace())
						.subList(1, e.getStackTrace().length)
						.toArray(new StackTraceElement[0]));
		return e;
	}

}
