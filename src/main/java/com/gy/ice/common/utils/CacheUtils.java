package com.gy.ice.common.utils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gaoye
 * @date 2021/12/27 15:28
 * @desc
 */
public class CacheUtils {
    private static final ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();

    public static void setValue(String key,Object value){
        map.put(key,value);
    }

    public static <T> T getValue(String key){
        return Convert.convert(new TypeReference<T>() {}, map.get(key));
    }

}
