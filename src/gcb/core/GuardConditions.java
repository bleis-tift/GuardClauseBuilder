package gcb.core;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * よく使用するガード条件をまとめたユーティリティクラスです。
 * @author bleis-tift
 */
public final class GuardConditions {

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

	/**
	 * null、もしくは空であることを調べるガード条件を返します。
	 * @return ガード条件を表すオブジェクト
	 */
	public static GuardCondition isNullOrEmpty() {
		return new GuardCondition() {
			public boolean match(Object arg) {
				if (arg == null)
					return true;
				if (arg instanceof CharSequence)
					return arg.toString().equals("");
				if (arg.getClass().isArray())
					return isEmptyArray(arg);
				if (arg instanceof Collection<?>)
					return isEmptyCollection(arg);
				return false;
			}
		};
	}

	static boolean isEmptyArray(Object array) {
		assert(array != null && array.getClass().isArray());
		return Array.getLength(array) == 0;
	}

	static boolean isEmptyCollection(Object collection) {
		assert(collection != null && collection instanceof Collection<?>);
		return ((Collection<?>)collection).isEmpty();
	}

}
