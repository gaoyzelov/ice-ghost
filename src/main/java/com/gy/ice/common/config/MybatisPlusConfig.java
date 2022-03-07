package com.gy.ice.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaoye
 * @date 2021/12/24 18:07
 * @desc mybatis-plus配置
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInterceptor());
        return interceptor;
    }

    /**
     * 分页请求拦截器
     * @return PaginationInnerInterceptor
     */
    private PaginationInnerInterceptor paginationInterceptor(){
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        //设置数据库类型
        interceptor.setDbType(DbType.SQLITE);
        //最大单页数量限制
        interceptor.setMaxLimit(500L);
        return interceptor;
    }
}
