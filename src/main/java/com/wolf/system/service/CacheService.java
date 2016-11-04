package com.wolf.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by sdyang on 2016/11/3.
 */
public class CacheService {

    @Autowired
    private RedisTemplate<String, String> template;
}
