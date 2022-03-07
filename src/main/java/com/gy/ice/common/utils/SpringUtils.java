package com.gy.ice.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author gaoye
 * @date 2021/12/28 14:09
 * @desc
 */
@Component
public class SpringUtils implements BeanFactoryPostProcessor {

    /** Spring应用上下文环境 */
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }

    /**
     * 根据名称获取bean对象
     * @param name bean名称
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     *
     */
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * 根据类型获取bean对象
     * @param clz bean类型
     * @return Bean对象
     * @throws BeansException 异常
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        return beanFactory.getBean(clz);
    }
}
