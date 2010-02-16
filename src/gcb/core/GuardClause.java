package gcb.core;

import static gcb.utils.StackTraceUtil.removeTopStackTraceElement;

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
	public static <T> void throwExceptionIf(T arg, GuardCondition<T> guardCond) {
		if (guardCond.match(arg))
			throw removeTopStackTraceElement(new GuardConditionException());
	}

	/**
	 * 引数argがメソッドチェインで指定された複数の条件のうちひとつでも満たす場合にGuardConditionExceptionを送出します。
	 * 送出される例外のスタックトレースに、このメソッドの情報は含まれません。
	 * @param arg 条件を満たすかどうか確認するオブジェクト
	 * @return 条件を指定するための起点となるオブジェクト
	 */
	public static <T> Any<T> throwExceptionIf(T arg) {
		return new Any<T>(arg);
	}

}
