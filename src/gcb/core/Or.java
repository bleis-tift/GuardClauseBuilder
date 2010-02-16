package gcb.core;

import static gcb.utils.StackTraceUtil.removeTopStackTraceElement;

/**
 * メソッド「or」のみを持つクラスで、直接使うことはありません。
 * @see Any
 * @see GuardClause
 * @author bleis-tift
 */
public class Or<T> {

	final T arg;

	Or(T arg) {
		this.arg = arg;
	}

	/**
	 * ガード条件を満たす場合GuardConditionExceptionを送出します。
	 * ガード条件を満たさなかった場合、次のガード条件を指定するためのオブジェクトを返します。
	 * @param guardCond 条件を表すオブジェクト。nullを渡すことはできません。
	 * @return 次のガード条件を指定するためのオブジェクト
	 */
	public Or<T> or(GuardCondition<? super T> guardCond) {
		if (guardCond.match(arg))
			throw removeTopStackTraceElement(new GuardConditionException());
		return this;
	}

}
