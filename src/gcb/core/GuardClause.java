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

	/**
	 * 引数で指定したオブジェクトと等しいこと調べるガード条件を返します。
	 * @param obj このオブジェクトと等しいかどうかが調べられる
	 * @return ガード条件を表すオブジェクト
	 */
	public static GuardCondition is(final Object obj) {
		return new GuardCondition() {
			public boolean match(Object arg) {
				if (obj == null)
					return arg == null;
				return obj.equals(arg);
			}
		};
	}

}
