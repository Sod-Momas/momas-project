package cc.momas.smbms.service.impl;

public abstract class BaseServiceImpl {

	<T> T getMapper(T clazz) {
		return clazz;
	}
}
