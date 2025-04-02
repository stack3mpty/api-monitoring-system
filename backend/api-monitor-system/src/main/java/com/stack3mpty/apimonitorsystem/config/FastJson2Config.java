package com.stack3mpty.apimonitorsystem.config;

import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * @author stack3mpty
 * @description
 * @create 2025/4/1 23:04
 */

@Configuration
public class FastJson2Config implements WebMvcConfigurer {

    private static final Logger log = LoggerFactory.getLogger(FastJson2Config.class);

    /**
     * Fastjson2Config
     * @author <a href="https://zhengkai.blog.csdn.net/">zhengkai.blog.csdn.net</a>
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        // 其他配置...
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converters.add(0, converter);
        log.info("Fastjson2 Initial Done");
    }
}
