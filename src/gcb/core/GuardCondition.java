package gcb.core;

/**
 * ガード条件を表すインターフェイスです。
 * @author bleis-tift
 */
public interface GuardCondition {

	/**
	 * 引数がガード条件を満たす場合、trueを返します。
	 * @param arg 条件を満たすかどうか確認するオブジェクト
	 * @return 条件を満たす場合true
	 */
	boolean match(Object arg);

}
