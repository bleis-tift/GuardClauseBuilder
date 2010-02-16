package gcb.core;

import java.util.Arrays;

/**
 * メソッド「any」のみを持つクラスで、直接使うことはありません。
 * @see GuardClause
 * @author bleis-tift
 */
public class Any<T> {

	final T arg;

	Any(T arg) {
		this.arg = arg;
	}

	/**
	 * ガード条件を満たす場合GuardConditionExceptionを送出します。
	 * ガード条件を満たさなかった場合、次のガード条件を指定するためのオブジェクトを返します。
	 * @param guardCond 条件を表すオブジェクト。nullを渡すことはできません。
	 * @return 次のガード条件を指定するためのオブジェクト
	 */
	public Or<T> any(GuardCondition<? super T> guardCond) {
		if (guardCond.match(arg)) {
			GuardConditionException e = new GuardConditionException();
			// http://d.hatena.ne.jp/katzchang/20080820/p2
			e.setStackTrace(
					Arrays.asList(e.getStackTrace())
							.subList(1, e.getStackTrace().length)
							.toArray(new StackTraceElement[0]));
			throw e;
		}
		return new Or<T>(arg);
	}

}
