package com.huang.builder;

import java.lang.reflect.Modifier;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class NullObjectUtil {
	
	private static final Logger logger = LoggerFactory
			.getLogger(NullObjectUtil.class);

	private static final Map<Class<?>, Object> nullObjMap = Maps.newHashMap();

	/**
	 * 对于 {@code null} 的参数值，自动生成空对象
	 * 
	 * @param inst
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <E> E defaultIfNull(E inst, Class<E> clazz) {
		if (inst != null) {
			return inst;
		}

		if (isNotSupported(clazz)) {
			return null;
		}

		if (nullObjMap.containsKey(clazz)) {
			return (E) nullObjMap.get(clazz);
		}

		E nullInstance = enhance(clazz);
		if (nullInstance == null) {
			return null;
		}

		synchronized (NullObjectUtil.class) {
			if (nullObjMap.containsKey(clazz)) {
				return (E) nullObjMap.get(clazz);
			}
			nullObjMap.put(clazz, nullInstance);
		}
		return nullInstance;
	}

	/**
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <E> E enhance(Class<E> clazz) {
		try {
			Class<?>[] interfaces = { Null.class };
			return (E) Enhancer.create(clazz, interfaces, NoOp.INSTANCE);
		} catch (Exception ex) {
			logger.error(
					"Enhance failed. The class name is " + clazz.getName(), ex);
			return null;
		}
	}

	/**
	 * 目前不支持的使用场景
	 * 
	 * @param clazz
	 * @return
	 */
	private static <E> boolean isNotSupported(Class<E> clazz) {
		return !isSupported(clazz);
	}

	/**
	 * @param clazz
	 * @return
	 */
	private static <E> boolean isSupported(Class<E> clazz) {
		if (clazz == null || Modifier.isFinal(clazz.getModifiers())) {
			return false;
		}

		try {
			if (clazz.getConstructor() == null) {
				return false;
			}
		} catch (Exception e) {
			logger.error(
					"Get the default constructor failed. The class name is "
							+ clazz.getName(), e);
			return false;
		}

		return true;
	}

	private static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}

		return obj instanceof Null;
	}

	/**
	 * 还原null
	 * 
	 * @param ele
	 * @return
	 */
	public static <Ele> Ele resume(Ele ele) {

		return isNull(ele) ? null : ele;
	}

	public static interface Null {
	}

}
