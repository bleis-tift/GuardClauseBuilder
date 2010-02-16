package gcb.core;

import java.util.Arrays;

/**
 * メソッドの先頭に記述する引数チェック用ガード節の記述を簡潔に行うためのクラスです。
 * @author bleis-tift
 */
public final class GuardClause {

	/**
	 * 第一引数argがmatcherで指定された条件を満たす場合にArgExceptionを送出します。
	 * 送出される例外のスタックトレースに、このメソッドの情報は含まれません。
	 * @param arg 条件を満たすかどうか確認するオブジェクト
	 * @param guardCond 条件を表すオブジェクト。nullを渡すことはできません。
	 */
	public static void throwExceptionIf(Object arg, GuardCondition guardCond) {
		if (guardCond.match(arg)) {
			GuardConditionException e = new GuardConditionException();
			// http://d.hatena.ne.jp/katzchang/20080820/p2
			e.setStackTrace(
					Arrays.asList(e.getStackTrace())
							.subList(1, e.getStackTrace().length)
							.toArray(new StackTraceElement[0]));
			throw e;
		}
	}

}
