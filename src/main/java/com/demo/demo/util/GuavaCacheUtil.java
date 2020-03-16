package com.demo.demo.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.math.BigDecimal;

/**
 * @author luwenxin
 * @create 2020-03-13
 */
public class GuavaCacheUtil {
    private static CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder().maximumSize(2000).initialCapacity(10);
    private static Cache<String, Object> cache;

    static {
        cache = cacheBuilder.build();
    }

    private GuavaCacheUtil() {
    }

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        cache.put(key, value);
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public static void del(String key) {
        cache.invalidate(key);
    }

    /**
     * 根据key取得缓存对象
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return cache.getIfPresent(key);
    }

    public static String getStr(String key) {
        return get(key).toString();
    }

    public static int getInt(String key) {
        Object value = get(key);
        if (value instanceof Integer) {
            return Integer.valueOf(value.toString());
        }
        return 0;
    }

    public static BigDecimal getBigDecimal(String key) {
        Object value = get(key);
        if (value instanceof BigDecimal) {
            return new BigDecimal(value.toString());
        }
        return BigDecimal.ZERO;
    }
}
