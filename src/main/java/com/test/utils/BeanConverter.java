package com.test.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;


public class BeanConverter<T, R> {
	private static final Logger logger = LoggerFactory.getLogger(BeanConverter.class);

	public static <T, R> R convert(T source, Class<R> clazz) {
		if (source == null) {
			return null;
		}
		R target = null;
		try {
			target = clazz.newInstance();
			BeanUtils.copyProperties(source, target);
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error("bean转换失败", e);
		}
		return target;
	}

	public static <T, R> List<R> convertList(List<T> source, Class<R> clazz) {
		return source.stream().map(i -> convert(i, clazz)).collect(Collectors.toList());
	}
}
