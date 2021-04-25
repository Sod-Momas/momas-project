package cc.momas.car.util;

public abstract class AuthorUtil {

	public static boolean isNullOrEmpty(Object... objs) {
		for (Object o : objs) {
			if(o == null || "".equals(o.toString()))
					return true;
		}
		return false;
	}
}
